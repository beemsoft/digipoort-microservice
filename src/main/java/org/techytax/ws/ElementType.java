
package org.techytax.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 						Element				:	elementType
 * 						Type						:	Combinatie van element naam en waarde.
 * 					
 * 
 * <p>Java class for elementType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="elementType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="naam" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}elementnaamType"/>
 *         &lt;element name="waarde" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}elementwaardeType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "elementType", propOrder = {
    "naam",
    "waarde"
})
public class ElementType {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String naam;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String waarde;

    /**
     * Gets the value of the naam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNaam() {
        return naam;
    }

    /**
     * Sets the value of the naam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNaam(String value) {
        this.naam = value;
    }

    /**
     * Gets the value of the waarde property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWaarde() {
        return waarde;
    }

    /**
     * Sets the value of the waarde property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWaarde(String value) {
        this.waarde = value;
    }

}
