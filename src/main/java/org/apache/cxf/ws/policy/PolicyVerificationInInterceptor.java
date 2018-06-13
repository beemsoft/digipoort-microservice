//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.apache.cxf.ws.policy;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import org.apache.cxf.Bus;
import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.Exchange;
import org.apache.cxf.message.Message;
import org.apache.cxf.message.MessageUtils;
import org.apache.cxf.service.model.BindingOperationInfo;
import org.apache.cxf.service.model.EndpointInfo;
import org.apache.neethi.Assertion;

public class PolicyVerificationInInterceptor extends AbstractPolicyInterceptor {
  public static final PolicyVerificationInInterceptor INSTANCE = new PolicyVerificationInInterceptor();
  private static final Logger LOG = LogUtils.getL7dLogger(PolicyVerificationInInterceptor.class);

  public PolicyVerificationInInterceptor() {
    super("pre-invoke");
  }

  protected void handle(Message message) {
    AssertionInfoMap aim = (AssertionInfoMap)message.get(AssertionInfoMap.class);
    if (null != aim) {
      Exchange exchange = message.getExchange();
      BindingOperationInfo boi = exchange.getBindingOperationInfo();
      if (null == boi) {
        LOG.fine("No binding operation info.");
      } else {
        Endpoint e = exchange.getEndpoint();
        if (null == e) {
          LOG.fine("No endpoint.");
        } else {
          Bus bus = exchange.getBus();
          PolicyEngine pe = (PolicyEngine)bus.getExtension(PolicyEngine.class);
          if (null != pe) {
            if (MessageUtils.isPartialResponse(message)) {
              LOG.fine("Not verifying policies on inbound partial response.");
            } else {
              this.getTransportAssertions(message);
              EffectivePolicy effectivePolicy = (EffectivePolicy)message.get(EffectivePolicy.class);
              if (effectivePolicy == null) {
                EndpointInfo ei = e.getEndpointInfo();
                if (MessageUtils.isRequestor(message)) {
                  effectivePolicy = pe.getEffectiveClientResponsePolicy(ei, boi, message);
                } else {
                  effectivePolicy = pe.getEffectiveServerRequestPolicy(ei, boi, message);
                }
              }

//              try {
//                List<List<Assertion>> usedAlternatives = aim.checkEffectivePolicy(effectivePolicy.getPolicy());
//                if (usedAlternatives != null && !usedAlternatives.isEmpty() && message.getExchange() != null) {
//                  message.getExchange().put("ws-policy.validated.alternatives", usedAlternatives);
//                }
//              } catch (PolicyException var10) {
//                LOG.log(Level.SEVERE, "Inbound policy verification failed: " + var10.getMessage());
//                if (var10.getMessage().indexOf("Addressing") > -1) {
//                  throw (new Fault("A required header representing a Message Addressing Property is not present", LOG)).setFaultCode(new QName("http://www.w3.org/2005/08/addressing", "MessageAddressingHeaderRequired"));
//                }
//
//                throw var10;
//              }

              LOG.fine("Verified policies for inbound message.");
            }
          }
        }
      }
    }
  }
}
