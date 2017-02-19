# digipoort-microservice
Provides a service for communicating XBRL messages with Digipoort, the digital gateway for the Dutch tax office.

### Requirement:

For accessing the Digipoort, this service requires a valid certificate.
* Place the certificate in the project root.
* Add the certificate info to client_sign.properties.

Handy commands:
* openssl pkcs12 -info -nodes -in certificate.p12
* keytool -list -v -storetype pkcs12 -keystore certificate.p12

