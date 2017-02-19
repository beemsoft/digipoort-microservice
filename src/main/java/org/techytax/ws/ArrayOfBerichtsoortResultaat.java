
package org.techytax.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.NormalizedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfBerichtsoortResultaat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfBerichtsoortResultaat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="berichtsoort" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}berichtsoortType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfBerichtsoortResultaat", propOrder = {
    "berichtsoort"
})
public class ArrayOfBerichtsoortResultaat {

    @XmlJavaTypeAdapter(NormalizedStringAdapter.class)
    protected List<String> berichtsoort;

    /**
     * Gets the value of the berichtsoort property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the berichtsoort property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getBerichtsoort().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getBerichtsoort() {
        if (berichtsoort == null) {
            berichtsoort = new ArrayList<String>();
        }
        return this.berichtsoort;
    }

}
