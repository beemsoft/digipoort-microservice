package org.techytax.security;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.transport.http.HTTPConduit;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;

public class SecureConnectionHelper {

	public static void setupTLS(Object port, Properties keyProperties, Properties trustProperties) throws FileNotFoundException, IOException,
			GeneralSecurityException {

		HTTPConduit httpConduit = (HTTPConduit) ClientProxy.getClient(port).getConduit();

		TLSClientParameters tlsCP = new TLSClientParameters();
		String keyPassword = keyProperties.getProperty("org.apache.ws.security.crypto.merlin.keystore.private.password");
		KeyStore keyStore = KeyStore.getInstance(keyProperties.getProperty("org.apache.ws.security.crypto.merlin.keystore.type"));
		String keyStoreLoc = keyProperties.getProperty("org.apache.ws.security.crypto.merlin.file");
		keyStore.load(new FileInputStream(keyStoreLoc), keyPassword.toCharArray());
		KeyManager[] myKeyManagers = getKeyManagers(keyStore, keyPassword);
		tlsCP.setKeyManagers(myKeyManagers);

		KeyStore trustStore = KeyStore.getInstance(trustProperties.getProperty("org.apache.ws.security.crypto.merlin.keystore.type"));
		keyPassword = trustProperties.getProperty("org.apache.ws.security.crypto.merlin.keystore.password");
		String trustStoreLoc = trustProperties.getProperty("org.apache.ws.security.crypto.merlin.file");
		trustStore.load(new FileInputStream(trustStoreLoc), keyPassword.toCharArray());
		TrustManager[] myTrustStoreKeyManagers = getTrustManagers(trustStore);
		tlsCP.setTrustManagers(myTrustStoreKeyManagers);

		httpConduit.setTlsClientParameters(tlsCP);

	}

	private static TrustManager[] getTrustManagers(KeyStore trustStore) throws NoSuchAlgorithmException, KeyStoreException {
		String alg = KeyManagerFactory.getDefaultAlgorithm();
		TrustManagerFactory fac = TrustManagerFactory.getInstance(alg);
		fac.init(trustStore);
		return fac.getTrustManagers();
	}

	private static KeyManager[] getKeyManagers(KeyStore keyStore, String keyPassword) throws GeneralSecurityException, IOException {
		String alg = KeyManagerFactory.getDefaultAlgorithm();
		char[] keyPass = keyPassword != null ? keyPassword.toCharArray() : null;
		KeyManagerFactory fac = KeyManagerFactory.getInstance(alg);
		fac.init(keyStore, keyPass);
		return fac.getKeyManagers();
	}

}
