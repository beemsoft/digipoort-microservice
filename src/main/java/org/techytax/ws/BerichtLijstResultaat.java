
package org.techytax.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * <p>Java class for BerichtLijstResultaat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BerichtLijstResultaat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="berichtsoort" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}berichtsoortType"/>
 *         &lt;element name="identiteitBelanghebbende" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}identiteitType"/>
 *         &lt;element name="kenmerk" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}kenmerkType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BerichtLijstResultaat", propOrder = {
    "berichtsoort",
    "identiteitBelanghebbende",
    "kenmerk"
})
public class BerichtLijstResultaat {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String berichtsoort;
    @XmlElement(required = true)
    protected IdentiteitType identiteitBelanghebbende;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String kenmerk;

    /**
     * Gets the value of the berichtsoort property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBerichtsoort() {
        return berichtsoort;
    }

    /**
     * Sets the value of the berichtsoort property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBerichtsoort(String value) {
        this.berichtsoort = value;
    }

    /**
     * Gets the value of the identiteitBelanghebbende property.
     * 
     * @return
     *     possible object is
     *     {@link IdentiteitType }
     *     
     */
    public IdentiteitType getIdentiteitBelanghebbende() {
        return identiteitBelanghebbende;
    }

    /**
     * Sets the value of the identiteitBelanghebbende property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentiteitType }
     *     
     */
    public void setIdentiteitBelanghebbende(IdentiteitType value) {
        this.identiteitBelanghebbende = value;
    }

    /**
     * Gets the value of the kenmerk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getKenmerk() {
        return kenmerk;
    }

    /**
     * Sets the value of the kenmerk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setKenmerk(String value) {
        this.kenmerk = value;
    }

}
