
package org.techytax.status;

import javax.xml.ws.WebFault;


/**
 * This class was generated by Apache CXF 2.7.1
 * 2013-01-16T21:54:45.267+01:00
 * Generated source version: 2.7.1
 */

@WebFault(name = "statusinformatieFault", targetNamespace = "http://logius.nl/digipoort/koppelvlakservices/1.2/")
public class StatusinformatieServiceFault extends Exception {
    
	private static final long serialVersionUID = -6368130405981779829L;
	private org.techytax.ws.FoutType statusinformatieFault;

    public StatusinformatieServiceFault() {
        super();
    }
    
    public StatusinformatieServiceFault(String message) {
        super(message);
    }
    
    public StatusinformatieServiceFault(String message, Throwable cause) {
        super(message, cause);
    }

    public StatusinformatieServiceFault(String message, org.techytax.ws.FoutType statusinformatieFault) {
        super(message);
        this.statusinformatieFault = statusinformatieFault;
    }

    public StatusinformatieServiceFault(String message, org.techytax.ws.FoutType statusinformatieFault, Throwable cause) {
        super(message, cause);
        this.statusinformatieFault = statusinformatieFault;
    }

    public org.techytax.ws.FoutType getFaultInfo() {
        return this.statusinformatieFault;
    }
}
