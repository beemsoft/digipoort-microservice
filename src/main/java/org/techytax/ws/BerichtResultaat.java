
package org.techytax.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for BerichtResultaat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BerichtResultaat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="kenmerk" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}kenmerkType"/>
 *         &lt;element name="berichtsoort" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}berichtsoortType"/>
 *         &lt;element name="berichtkenmerk" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}berichtkenmerkType"/>
 *         &lt;element name="aanleverkenmerk" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}aanleverkenmerkType" minOccurs="0"/>
 *         &lt;element name="eerderAanleverkenmerk" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}aanleverkenmerkType" minOccurs="0"/>
 *         &lt;element name="tijdstempelAangeleverd" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *         &lt;element name="identiteitBelanghebbende" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}identiteitType"/>
 *         &lt;element name="rolBelanghebbende" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}rolType"/>
 *         &lt;element name="identiteitAanleveraar" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}identiteitsnummerType" minOccurs="0"/>
 *         &lt;element name="identiteitOntvanger" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}identiteitType" minOccurs="0"/>
 *         &lt;element name="rolOntvanger" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}rolType" minOccurs="0"/>
 *         &lt;element name="berichtInhoud" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}berichtInhoudType"/>
 *         &lt;element name="berichtBijlagen" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}berichtBijlagenType" minOccurs="0"/>
 *         &lt;element name="constateringenLijst" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}constateringenLijstType" minOccurs="0"/>
 *         &lt;element name="additioneleElementenLijst" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}additioneleElementenLijstType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BerichtResultaat", propOrder = {
    "kenmerk",
    "berichtsoort",
    "berichtkenmerk",
    "aanleverkenmerk",
    "eerderAanleverkenmerk",
    "tijdstempelAangeleverd",
    "identiteitBelanghebbende",
    "rolBelanghebbende",
    "identiteitAanleveraar",
    "identiteitOntvanger",
    "rolOntvanger",
    "berichtInhoud",
    "berichtBijlagen",
    "constateringenLijst",
    "additioneleElementenLijst"
})
public class BerichtResultaat {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String kenmerk;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String berichtsoort;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String berichtkenmerk;
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
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String identiteitAanleveraar;
    protected IdentiteitType identiteitOntvanger;
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String rolOntvanger;
    @XmlElement(required = true)
    protected BerichtInhoudType berichtInhoud;
    protected BerichtBijlagenType berichtBijlagen;
    protected ConstateringenLijstType constateringenLijst;
    protected AdditioneleElementenLijstType additioneleElementenLijst;

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
     * Gets the value of the berichtkenmerk property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBerichtkenmerk() {
        return berichtkenmerk;
    }

    /**
     * Sets the value of the berichtkenmerk property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBerichtkenmerk(String value) {
        this.berichtkenmerk = value;
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
     * Gets the value of the identiteitAanleveraar property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIdentiteitAanleveraar() {
        return identiteitAanleveraar;
    }

    /**
     * Sets the value of the identiteitAanleveraar property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIdentiteitAanleveraar(String value) {
        this.identiteitAanleveraar = value;
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
     * Gets the value of the berichtInhoud property.
     * 
     * @return
     *     possible object is
     *     {@link BerichtInhoudType }
     *     
     */
    public BerichtInhoudType getBerichtInhoud() {
        return berichtInhoud;
    }

    /**
     * Sets the value of the berichtInhoud property.
     * 
     * @param value
     *     allowed object is
     *     {@link BerichtInhoudType }
     *     
     */
    public void setBerichtInhoud(BerichtInhoudType value) {
        this.berichtInhoud = value;
    }

    /**
     * Gets the value of the berichtBijlagen property.
     * 
     * @return
     *     possible object is
     *     {@link BerichtBijlagenType }
     *     
     */
    public BerichtBijlagenType getBerichtBijlagen() {
        return berichtBijlagen;
    }

    /**
     * Sets the value of the berichtBijlagen property.
     * 
     * @param value
     *     allowed object is
     *     {@link BerichtBijlagenType }
     *     
     */
    public void setBerichtBijlagen(BerichtBijlagenType value) {
        this.berichtBijlagen = value;
    }

    /**
     * Gets the value of the constateringenLijst property.
     * 
     * @return
     *     possible object is
     *     {@link ConstateringenLijstType }
     *     
     */
    public ConstateringenLijstType getConstateringenLijst() {
        return constateringenLijst;
    }

    /**
     * Sets the value of the constateringenLijst property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConstateringenLijstType }
     *     
     */
    public void setConstateringenLijst(ConstateringenLijstType value) {
        this.constateringenLijst = value;
    }

    /**
     * Gets the value of the additioneleElementenLijst property.
     * 
     * @return
     *     possible object is
     *     {@link AdditioneleElementenLijstType }
     *     
     */
    public AdditioneleElementenLijstType getAdditioneleElementenLijst() {
        return additioneleElementenLijst;
    }

    /**
     * Sets the value of the additioneleElementenLijst property.
     * 
     * @param value
     *     allowed object is
     *     {@link AdditioneleElementenLijstType }
     *     
     */
    public void setAdditioneleElementenLijst(AdditioneleElementenLijstType value) {
        this.additioneleElementenLijst = value;
    }

}
