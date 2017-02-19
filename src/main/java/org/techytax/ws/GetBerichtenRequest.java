
package org.techytax.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="berichtsoort" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}berichtsoortType" minOccurs="0"/>
 *         &lt;element name="identiteitBelanghebbende" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}identiteitType"/>
 *         &lt;element name="autorisatieAdres" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}autorisatieAdresType" minOccurs="0"/>
 *         &lt;element name="tijdstempelVanaf" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="tijdstempelTot" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "berichtsoort",
    "identiteitBelanghebbende",
    "autorisatieAdres",
    "tijdstempelVanaf",
    "tijdstempelTot"
})
@XmlRootElement(name = "getBerichtenRequest")
public class GetBerichtenRequest {

    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String berichtsoort;
    @XmlElement(required = true)
    protected IdentiteitType identiteitBelanghebbende;
    protected String autorisatieAdres;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tijdstempelVanaf;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tijdstempelTot;

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
     * Gets the value of the autorisatieAdres property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAutorisatieAdres() {
        return autorisatieAdres;
    }

    /**
     * Sets the value of the autorisatieAdres property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAutorisatieAdres(String value) {
        this.autorisatieAdres = value;
    }

    /**
     * Gets the value of the tijdstempelVanaf property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTijdstempelVanaf() {
        return tijdstempelVanaf;
    }

    /**
     * Sets the value of the tijdstempelVanaf property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTijdstempelVanaf(XMLGregorianCalendar value) {
        this.tijdstempelVanaf = value;
    }

    /**
     * Gets the value of the tijdstempelTot property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTijdstempelTot() {
        return tijdstempelTot;
    }

    /**
     * Sets the value of the tijdstempelTot property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTijdstempelTot(XMLGregorianCalendar value) {
        this.tijdstempelTot = value;
    }

}
