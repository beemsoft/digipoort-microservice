//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.apache.cxf.ws.security.wss4j;

import java.security.Provider;
import java.security.cert.Certificate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.security.auth.callback.CallbackHandler;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.dom.DOMSource;
import org.apache.cxf.attachment.AttachmentUtil;
import org.apache.cxf.binding.soap.SoapFault;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.binding.soap.SoapVersion;
import org.apache.cxf.binding.soap.saaj.SAAJInInterceptor;
import org.apache.cxf.binding.soap.saaj.SAAJUtils;
import org.apache.cxf.common.i18n.Message;
import org.apache.cxf.common.logging.LogUtils;
import org.apache.cxf.endpoint.Endpoint;
import org.apache.cxf.helpers.CastUtils;
import org.apache.cxf.interceptor.Fault;
import org.apache.cxf.message.MessageUtils;
import org.apache.cxf.rt.security.utils.SecurityUtils;
import org.apache.cxf.security.transport.TLSSessionInfo;
import org.apache.cxf.staxutils.StaxUtils;
import org.apache.cxf.ws.security.tokenstore.TokenStore;
import org.apache.cxf.ws.security.tokenstore.TokenStoreUtils;
import org.apache.wss4j.common.cache.ReplayCache;
import org.apache.wss4j.common.crypto.Crypto;
import org.apache.wss4j.common.crypto.ThreadLocalSecurityProvider;
import org.apache.wss4j.common.ext.WSSecurityException;
import org.apache.wss4j.common.ext.WSSecurityException.ErrorCode;
import org.apache.wss4j.dom.WSConstants;
import org.apache.wss4j.dom.engine.WSSConfig;
import org.apache.wss4j.dom.engine.WSSecurityEngine;
import org.apache.wss4j.dom.engine.WSSecurityEngineResult;
import org.apache.wss4j.dom.handler.RequestData;
import org.apache.wss4j.dom.handler.WSHandlerResult;
import org.apache.wss4j.dom.processor.Processor;
import org.apache.wss4j.dom.util.WSSecurityUtil;
import org.apache.wss4j.dom.validate.NoOpValidator;
import org.apache.wss4j.dom.validate.Validator;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class WSS4JInInterceptor extends AbstractWSS4JInterceptor {
  public static final String SAML_ROLE_ATTRIBUTENAME_DEFAULT = "http://schemas.xmlsoap.org/ws/2005/05/identity/claims/role";
  public static final String PROCESSOR_MAP = "wss4j.processor.map";
  public static final String VALIDATOR_MAP = "wss4j.validator.map";
  public static final String SECURITY_PROCESSED = WSS4JInInterceptor.class.getName() + ".DONE";
  private static final Logger LOG = LogUtils.getL7dLogger(WSS4JInInterceptor.class);
  private boolean ignoreActions;
  private WSSecurityEngine secEngineOverride;

  public WSS4JInInterceptor() {
    this.setPhase("pre-protocol");
    this.getAfter().add(SAAJInInterceptor.class.getName());
    this.getAfter().add("org.apache.cxf.ws.addressing.soap.MAPCodec");
  }

  public WSS4JInInterceptor(boolean ignore) {
    this();
    this.ignoreActions = ignore;
  }

  public WSS4JInInterceptor(Map<String, Object> properties) {
    this();
    this.setProperties(properties);
    Map<QName, Object> processorMap = CastUtils.cast((Map)properties.get("wss4j.processor.map"));
    Map<QName, Object> validatorMap = CastUtils.cast((Map)properties.get("wss4j.validator.map"));
    if (processorMap != null) {
      if (validatorMap != null) {
        processorMap.putAll(validatorMap);
      }

      this.secEngineOverride = createSecurityEngine(processorMap);
    } else if (validatorMap != null) {
      this.secEngineOverride = createSecurityEngine(validatorMap);
    }

  }

  public void setIgnoreActions(boolean i) {
    this.ignoreActions = i;
  }

  private SOAPMessage getSOAPMessage(SoapMessage msg) {
    SAAJInInterceptor.INSTANCE.handleMessage(msg);
    return (SOAPMessage)msg.getContent(SOAPMessage.class);
  }

  public Object getProperty(Object msgContext, String key) {
    Object result = super.getProperty(msgContext, key);
    if (result == null && "_sendSignatureValues_".equals(key) && this.isRequestor((SoapMessage)msgContext)) {
      result = ((SoapMessage)msgContext).getExchange().getOutMessage().get(key);
    }

    return result;
  }

  public final boolean isGET(SoapMessage message) {
    String method = (String)message.get("org.apache.cxf.request.method");
    boolean isGet = "GET".equals(method) && message.getContent(XMLStreamReader.class) == null;
    return isGet;
  }

  public void handleMessage(SoapMessage msg) throws Fault {
    if (!msg.containsKey(SECURITY_PROCESSED) && !this.isGET(msg) && msg.getExchange() != null) {
      Object provider = msg.getExchange().get(Provider.class);
      boolean useCustomProvider = provider != null && ThreadLocalSecurityProvider.isInstalled();

      try {
        if (useCustomProvider) {
          ThreadLocalSecurityProvider.setProvider((Provider)provider);
        }

        this.handleMessageInternal(msg);
      } finally {
        if (useCustomProvider) {
          ThreadLocalSecurityProvider.unsetProvider();
        }

      }

    }
  }

  private void handleMessageInternal(SoapMessage msg) throws Fault {

  }

  private void configureAudienceRestriction(SoapMessage msg, RequestData reqData) {
    boolean enableAudienceRestriction = SecurityUtils.getSecurityPropertyBoolean("security.validate.audience-restriction", msg, true);
    if (enableAudienceRestriction) {
      List<String> audiences = new ArrayList();
      if (msg.get("org.apache.cxf.request.url") != null) {
        audiences.add((String)msg.get("org.apache.cxf.request.url"));
      } else if (msg.get("org.apache.cxf.request.uri") != null) {
        audiences.add((String)msg.get("org.apache.cxf.request.uri"));
      }

      if (msg.getContextualProperty("javax.xml.ws.wsdl.service") != null) {
        audiences.add(msg.getContextualProperty("javax.xml.ws.wsdl.service").toString());
      }

      reqData.setAudienceRestrictions(audiences);
    }

  }

  private void checkActions(SoapMessage msg, RequestData reqData, List<WSSecurityEngineResult> wsResult, List<Integer> actions, Element body) {
  }

  protected void computeAction(SoapMessage msg, RequestData reqData) {
    Crypto encCrypto = (Crypto)SecurityUtils.getSecurityPropertyValue("security.encryption.crypto", msg);
    if (encCrypto != null) {
      reqData.setDecCrypto(encCrypto);
    }

    Crypto sigCrypto = (Crypto)SecurityUtils.getSecurityPropertyValue("security.signature.crypto", msg);
    if (sigCrypto != null) {
      reqData.setSigVerCrypto(sigCrypto);
    }

  }

  protected void configureReplayCaches(RequestData reqData, List<Integer> actions, SoapMessage msg) {
    reqData.setEnableNonceReplayCache(false);
    ReplayCache samlCache;
    if (this.isNonceCacheRequired(actions, msg)) {
      samlCache = this.getReplayCache(msg, "ws-security.enable.nonce.cache", "ws-security.nonce.cache.instance");
      reqData.setNonceReplayCache(samlCache);
      if (samlCache != null) {
        reqData.setEnableNonceReplayCache(true);
      }
    }

    reqData.setEnableTimestampReplayCache(false);
    if (this.isTimestampCacheRequired(actions, msg)) {
      samlCache = this.getReplayCache(msg, "ws-security.enable.timestamp.cache", "ws-security.timestamp.cache.instance");
      reqData.setTimestampReplayCache(samlCache);
      if (samlCache != null) {
        reqData.setEnableTimestampReplayCache(true);
      }
    }

    reqData.setEnableSamlOneTimeUseReplayCache(false);
    if (this.isSamlCacheRequired(actions, msg)) {
      samlCache = this.getReplayCache(msg, "ws-security.enable.saml.cache", "ws-security.saml.cache.instance");
      reqData.setSamlOneTimeUseReplayCache(samlCache);
      if (samlCache != null) {
        reqData.setEnableSamlOneTimeUseReplayCache(true);
      }
    }

  }

  protected boolean isNonceCacheRequired(List<Integer> actions, SoapMessage msg) {
    return actions.contains(1) || actions.contains(8192);
  }

  protected boolean isTimestampCacheRequired(List<Integer> actions, SoapMessage msg) {
    return actions.contains(32);
  }

  protected boolean isSamlCacheRequired(List<Integer> actions, SoapMessage msg) {
    return actions.contains(8) || actions.contains(16);
  }

  protected static WSSecurityEngine createSecurityEngine(Map<QName, Object> map) {
    assert map != null;

    WSSConfig config = WSSConfig.getNewInstance();
    Iterator var2 = map.entrySet().iterator();

    while(var2.hasNext()) {
      Entry<QName, Object> entry = (Entry)var2.next();
      QName key = (QName)entry.getKey();
      Object val = entry.getValue();
      if (val instanceof Class) {
        config.setProcessor(key, (Class)val);
      } else if (val instanceof Processor) {
        config.setProcessor(key, (Processor)val);
      } else if (val instanceof Validator) {
        config.setValidator(key, (Validator)val);
      } else if (val == null) {
        config.setProcessor(key, (Class)null);
      }
    }

    WSSecurityEngine ret = new WSSecurityEngine();
    ret.setWssConfig(config);
    return ret;
  }

  protected ReplayCache getReplayCache(SoapMessage message, String booleanKey, String instanceKey) {
    return WSS4JUtils.getReplayCache(message, booleanKey, instanceKey);
  }
}
