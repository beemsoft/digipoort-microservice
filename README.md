# digipoort-microservice
Provides a service for communicating XBRL messages with Digipoort, the digital gateway for the Dutch tax office.

## Requirements

### Certificate

For accessing the Digipoort, this service requires a private certificate.
* Place the certificate in the project root.
* Add the certificate info to client_sign.properties.

Also, public certificates need to be installed:
* In target/classed, run: java org.techytax.xbrl.InstallCert logius.nl
* https://whatsmychaincert.com/?logius.nl
* keytool -import -noprompt -trustcacerts -alias logius.nl -file www.logius.nl.chain+root.crt -keystore jssecacerts 
* Place the jssecacerts file in the project root. 

Handy commands:
* openssl pkcs12 -info -nodes -in certificate.p12
* keytool -list -v -storetype pkcs12 -keystore certificate.p12

### CXF dependency

The microservice has been tested with CXF version 2.7.1.

## Start command

The microservice can be started with `mvn spring-boot:run`

