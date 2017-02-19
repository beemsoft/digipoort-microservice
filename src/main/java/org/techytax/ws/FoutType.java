
package org.techytax.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 						Element				:	foutType
 * 						Type						:	Combinatie van foutcode en foutomschrijving.
 * 					
 * 
 * <p>Java class for foutType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="foutType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="foutcode" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}foutcodeType"/>
 *         &lt;element name="foutbeschrijving" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}foutbeschrijvingType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "foutType", propOrder = {
    "foutcode",
    "foutbeschrijving"
})
public class FoutType {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String foutcode;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String foutbeschrijving;

    /**
     * Gets the value of the foutcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoutcode() {
        return foutcode;
    }

    /**
     * Sets the value of the foutcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoutcode(String value) {
        this.foutcode = value;
    }

    /**
     * Gets the value of the foutbeschrijving property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFoutbeschrijving() {
        return foutbeschrijving;
    }

    /**
     * Sets the value of the foutbeschrijving property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFoutbeschrijving(String value) {
        this.foutbeschrijving = value;
    }

}
