package org.techytax.xbrl;

import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.interceptor.Interceptor;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageUtils;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.addressing.AddressingProperties;
import org.apache.cxf.ws.addressing.ContextUtils;
import org.apache.cxf.ws.security.wss4j.WSS4JOutInterceptor;
import org.apache.wss4j.dom.handler.WSHandlerConstants;

import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;
import java.util.logging.Logger;


/**
 * Interceptor that can dynamically add signature coverage of WS-A headers
 * if they are present in the message.  This interceptor allows these
 * headers to always be signed when using traditional static WSS4J configuration
 * in CXF.
 *
 * @author David Valeri
 */
public class DynamicWsaSignaturePartsInterceptor extends
        AbstractPhaseInterceptor<Message> {

    private static final Logger LOG = LogUtils
            .getL7dLogger(DynamicWsaSignaturePartsInterceptor.class);

    public DynamicWsaSignaturePartsInterceptor() {
        super(Phase.PRE_PROTOCOL);
        this.addBefore(WSS4JOutInterceptor.class.getName());
    }

    public void handleMessage(Message message) throws Fault {

        if (MessageUtils.isOutbound(message)) {

            String signatureParts = null;

            WSS4JOutInterceptor wss4jOutInterceptor = this.findWss4JOutInterceptor(message);

            if (wss4jOutInterceptor != null && this.isSigning(wss4jOutInterceptor)) {

                signatureParts = (String) wss4jOutInterceptor.getProperties().get(
                        WSHandlerConstants.SIGNATURE_PARTS);

                // The parts are set in the interceptor properties and not in the
                // broader context of the client or server.  If we were to simply edit
                // the property value, it will affect all other messages sent since the
                // interceptor instance is shared across all requests/responses.
                if (signatureParts != null) {
                    LOG.warning("The WSS4JOutInterceptor specifies "
                            + WSHandlerConstants.SIGNATURE_PARTS
                            + " directly as a property on the interceptor "
                            + "a performance increase is possible by setting this "
                            + " configuration option on the server or client itself.");
                }
                // The parts are set on the client or server context and at this point have
                // been transposed to the current message.  We can overwrite the value
                // and not affect other message calls.
                else {
                    signatureParts = (String) message.get(WSHandlerConstants.SIGNATURE_PARTS);
                    // Clear it as this is our flag used later to determine where to stuff
                    // the updated configuration.
                    wss4jOutInterceptor = null;
                }

                AddressingProperties maps =
                    ContextUtils.retrieveMAPs(message, false, true);

                if (maps != null) {
                    final StringBuilder builder = new StringBuilder();

                    if (signatureParts != null) {
                        builder.append(signatureParts);
                    }

                    if (maps.getAction() != null) {
                        this.appendSignaturePart(builder,
                                "{Element}{http://www.w3.org/2005/08/addressing}Action");
                    }

                    if (maps.getTo() != null) {
                        this.appendSignaturePart(builder,
                                "{Element}{http://www.w3.org/2005/08/addressing}To");
                    }

                    if (maps.getFaultTo() != null
                            && maps.getFaultTo().getAddress() != null
                            && maps.getFaultTo().getAddress().getValue() != null
                            && !maps.getFaultTo().getAddress().getValue()
                                .equals(maps.getReplyTo().getAddress().getValue())) {
                        this.appendSignaturePart(builder,
                                "{Element}{http://www.w3.org/2005/08/addressing}FaultTo");
                    }

                    if (maps.getReplyTo() != null) {
                        this.appendSignaturePart(builder,
                                "{Element}{http://www.w3.org/2005/08/addressing}ReplyTo");
                    }

                    if (maps.getRelatesTo() != null) {
                        this.appendSignaturePart(builder,
                                "{Element}{http://www.w3.org/2005/08/addressing}RelatesTo");
                    }

                    if (maps.getMessageID() != null) {
                        this.appendSignaturePart(builder,
                                "{Element}{http://www.w3.org/2005/08/addressing}MessageID");
                    }

                    if ((signatureParts != null && builder.length() > signatureParts.length())
                            || (signatureParts == null && builder.length() > 0)) {

                        this.setSignatureParts(message, wss4jOutInterceptor, builder.toString());
                    }
                }
            }
        }
    }

    /**
     * Determines if the WSS4J action includes an action that would be affected
     * by the {@link WSHandlerConstants#SIGNATURE_PARTS} configuration property.
     * <p/>
     * This implementation looks for the "Signature" and "SAMLTokenSigned"
     * values. Subclasses may override this implementation to support additional
     * action values.
     *
     * @param interceptor
     *            the interceptor to look at the configuration of
     *
     * @return true if {@code interceptor} is configured in a way that this
     *         interceptor can affect a change in the signed message content
     */
    protected boolean isSigning(WSS4JOutInterceptor interceptor) {
        final String action = (String) interceptor.getProperties().get(
                WSHandlerConstants.ACTION);

        return action != null
                && (action.contains(WSHandlerConstants.SIGNATURE)
                        || action.contains(WSHandlerConstants.SAML_TOKEN_SIGNED));
    }

    private void appendSignaturePart(StringBuilder builder, String part) {
        if (builder.length() != 0) {
            builder.append("; ");
        }

        builder.append(part);
    }

    /**
     * Sets the signature parts for the outbound interceptor. Sets the property
     * directly on a new instance of the interceptor and replaces the current
     * interceptor if {@code interceptor} is not {@code null}. Sets the property
     * on the message if {@code inerceptor} is {@code null}.
     *
     * @param message the current message
     * @param interceptor the optional interceptor, replaced if not null
     * @param signatureParts the value of the property to set
     */
    private void setSignatureParts(Message message, WSS4JOutInterceptor interceptor,
            String signatureParts) {

        if (interceptor == null) {
            message.put(WSHandlerConstants.SIGNATURE_PARTS, signatureParts);
        }
        else {
            Map<String, Object> properties = new HashMap<>(
                    interceptor.getProperties());
            properties.put(WSHandlerConstants.SIGNATURE_PARTS, signatureParts);

            message.getInterceptorChain().remove(interceptor);
            message.getInterceptorChain().add(new WSS4JOutInterceptor(properties));
        }
    }

    private WSS4JOutInterceptor findWss4JOutInterceptor(Message message) {

        WSS4JOutInterceptor wss4jOutInterceptor = null;

        ListIterator<Interceptor<? extends Message>> interceptors =
                message.getInterceptorChain().getIterator();

        while (interceptors.hasNext() && wss4jOutInterceptor == null) {
            Interceptor<? extends Message> interceptor = interceptors.next();

            if (interceptor instanceof WSS4JOutInterceptor) {
                wss4jOutInterceptor = (WSS4JOutInterceptor) interceptor;
            }
        }

        return wss4jOutInterceptor;
    }
}

