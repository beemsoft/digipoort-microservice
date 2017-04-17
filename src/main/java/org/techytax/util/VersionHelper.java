package org.techytax.util;

public class VersionHelper {
	
	public static String getVersion() {
		StringBuilder sb = new StringBuilder();
		if (isSaasVersion()) {
			sb.append("SaaS-");
		}
		sb.append(VersionHelper.class.getPackage().getImplementationVersion());
		return sb.toString();
	}

    public static String getXbrlVersion() {
        return getVersion().replace("-SNAPSHOT", "");
    }
	
	public static boolean isSaasVersion() {
		return "true".equals(System.getProperty("saas.version"));
	}
	
}
