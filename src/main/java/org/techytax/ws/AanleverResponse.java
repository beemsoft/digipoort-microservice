
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
 *         &lt;element name="kenmerk" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}kenmerkType"/>
 *         &lt;element name="berichtsoort" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}berichtsoortType"/>
 *         &lt;element name="aanleverkenmerk" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}aanleverkenmerkType" minOccurs="0"/>
 *         &lt;element name="eerderAanleverkenmerk" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}aanleverkenmerkType" minOccurs="0"/>
 *         &lt;element name="tijdstempelAangeleverd" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="identiteitBelanghebbende" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}identiteitType"/>
 *         &lt;element name="rolBelanghebbende" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}rolType"/>
 *         &lt;element name="identiteitOntvanger" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}identiteitType" minOccurs="0"/>
 *         &lt;element name="rolOntvanger" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}rolType" minOccurs="0"/>
 *         &lt;element name="autorisatieAdres" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}autorisatieAdresType" minOccurs="0"/>
 *         &lt;element name="statuscode" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}statuscodeType" minOccurs="0"/>
 *         &lt;element name="tijdstempelStatus" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="statusomschrijving" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}statusomschrijvingType" minOccurs="0"/>
 *         &lt;element name="statusFoutcode" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}foutType" minOccurs="0"/>
 *         &lt;element name="statusdetails" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}statusdetailsType" minOccurs="0"/>
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
    "kenmerk",
    "berichtsoort",
    "aanleverkenmerk",
    "eerderAanleverkenmerk",
    "tijdstempelAangeleverd",
    "identiteitBelanghebbende",
    "rolBelanghebbende",
    "identiteitOntvanger",
    "rolOntvanger",
    "autorisatieAdres",
    "statuscode",
    "tijdstempelStatus",
    "statusomschrijving",
    "statusFoutcode",
    "statusdetails"
})
@XmlRootElement(name = "aanleverResponse")
public class AanleverResponse {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String kenmerk;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String berichtsoort;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String aanleverkenmerk;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String eerderAanleverkenmerk;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tijdstempelAangeleverd;
    @XmlElement(required = true)
    protected IdentiteitType identiteitBelanghebbende;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String rolBelanghebbende;
    protected IdentiteitType identiteitOntvanger;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String rolOntvanger;
    protected String autorisatieAdres;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String statuscode;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tijdstempelStatus;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String statusomschrijving;
    protected FoutType statusFoutcode;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String statusdetails;

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
     * Gets the value of the aanleverkenmerk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAanleverkenmerk() {
        return aanleverkenmerk;
    }

    /**
     * Sets the value of the aanleverkenmerk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAanleverkenmerk(String value) {
        this.aanleverkenmerk = value;
    }

    /**
     * Gets the value of the eerderAanleverkenmerk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEerderAanleverkenmerk() {
        return eerderAanleverkenmerk;
    }

    /**
     * Sets the value of the eerderAanleverkenmerk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEerderAanleverkenmerk(String value) {
        this.eerderAanleverkenmerk = value;
    }

    /**
     * Gets the value of the tijdstempelAangeleverd property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTijdstempelAangeleverd() {
        return tijdstempelAangeleverd;
    }

    /**
     * Sets the value of the tijdstempelAangeleverd property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTijdstempelAangeleverd(XMLGregorianCalendar value) {
        this.tijdstempelAangeleverd = value;
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
     * Gets the value of the rolBelanghebbende property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRolBelanghebbende() {
        return rolBelanghebbende;
    }

    /**
     * Sets the value of the rolBelanghebbende property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRolBelanghebbende(String value) {
        this.rolBelanghebbende = value;
    }

    /**
     * Gets the value of the identiteitOntvanger property.
     * 
     * @return
     *     possible object is
     *     {@link IdentiteitType }
     *     
     */
    public IdentiteitType getIdentiteitOntvanger() {
        return identiteitOntvanger;
    }

    /**
     * Sets the value of the identiteitOntvanger property.
     * 
     * @param value
     *     allowed object is
     *     {@link IdentiteitType }
     *     
     */
    public void setIdentiteitOntvanger(IdentiteitType value) {
        this.identiteitOntvanger = value;
    }

    /**
     * Gets the value of the rolOntvanger property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRolOntvanger() {
        return rolOntvanger;
    }

    /**
     * Sets the value of the rolOntvanger property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRolOntvanger(String value) {
        this.rolOntvanger = value;
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
     * Gets the value of the statuscode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatuscode() {
        return statuscode;
    }

    /**
     * Sets the value of the statuscode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatuscode(String value) {
        this.statuscode = value;
    }

    /**
     * Gets the value of the tijdstempelStatus property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTijdstempelStatus() {
        return tijdstempelStatus;
    }

    /**
     * Sets the value of the tijdstempelStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTijdstempelStatus(XMLGregorianCalendar value) {
        this.tijdstempelStatus = value;
    }

    /**
     * Gets the value of the statusomschrijving property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusomschrijving() {
        return statusomschrijving;
    }

    /**
     * Sets the value of the statusomschrijving property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusomschrijving(String value) {
        this.statusomschrijving = value;
    }

    /**
     * Gets the value of the statusFoutcode property.
     * 
     * @return
     *     possible object is
     *     {@link FoutType }
     *     
     */
    public FoutType getStatusFoutcode() {
        return statusFoutcode;
    }

    /**
     * Sets the value of the statusFoutcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link FoutType }
     *     
     */
    public void setStatusFoutcode(FoutType value) {
        this.statusFoutcode = value;
    }

    /**
     * Gets the value of the statusdetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatusdetails() {
        return statusdetails;
    }

    /**
     * Sets the value of the statusdetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatusdetails(String value) {
        this.statusdetails = value;
    }

}
