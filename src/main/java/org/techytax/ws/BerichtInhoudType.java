
package org.techytax.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


/**
 * 
 * 						Beschrijving			:	De berichtinhoud is dat deel van het bericht dat de eigenlijke bedrijfsprocesinformatie bevat.
 * 					
 * 
 * <p>Java class for berichtInhoudType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="berichtInhoudType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mimeType">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;maxLength value="255"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="bestandsnaam">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}normalizedString">
 *               &lt;whiteSpace value="collapse"/>
 *               &lt;maxLength value="80"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="inhoud">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}base64Binary">
 *               &lt;maxLength value="20971520"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "berichtInhoudType", propOrder = {
    "mimeType",
    "bestandsnaam",
    "inhoud"
})
public class BerichtInhoudType {

    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String mimeType;
    @XmlElement(required = true)
    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected String bestandsnaam;
    @XmlElement(required = true)
    protected byte[] inhoud;

    /**
     * Gets the value of the mimeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMimeType() {
        return mimeType;
    }

    /**
     * Sets the value of the mimeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMimeType(String value) {
        this.mimeType = value;
    }

    /**
     * Gets the value of the bestandsnaam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBestandsnaam() {
        return bestandsnaam;
    }

    /**
     * Sets the value of the bestandsnaam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBestandsnaam(String value) {
        this.bestandsnaam = value;
    }

    /**
     * Gets the value of the inhoud property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getInhoud() {
        return inhoud;
    }

    /**
     * Sets the value of the inhoud property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setInhoud(byte[] value) {
        this.inhoud = value;
    }

}
