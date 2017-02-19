package org.techytax.ws;

import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.phase.AbstractPhaseInterceptor;
import org.apache.cxf.phase.Phase;
import org.apache.cxf.ws.policy.PolicyConstants;
import org.apache.cxf.ws.policy.PolicyOutInterceptor;
import org.apache.neethi.Policy;

import java.io.FileInputStream;
import java.io.InputStream;

public class PolicyControlOutInterceptor extends
		AbstractPhaseInterceptor<SoapMessage> {

	public PolicyControlOutInterceptor() {
		super(Phase.SETUP);
		getBefore().add(PolicyOutInterceptor.class.getName());
	}

	public void handleMessage(SoapMessage message) {
		try {
			// 1. Build effective policy for response
			org.apache.cxf.ws.policy.PolicyBuilder builder = message
					.getExchange().getBus()
					.getExtension(org.apache.cxf.ws.policy.PolicyBuilder.class);
			InputStream xmlGenericPolicy = new FileInputStream("/home/hans/workspace/TechyTax/src/org/techytax/xbrl/policy.xml");
			Policy effectivePolicy = builder.getPolicy(xmlGenericPolicy);

			// 2. Apply effective policy
			message.put(PolicyConstants.POLICY_OVERRIDE, effectivePolicy);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
