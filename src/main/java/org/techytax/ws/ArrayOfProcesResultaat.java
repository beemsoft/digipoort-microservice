
package org.techytax.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * <p>Java class for ArrayOfProcesResultaat complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ArrayOfProcesResultaat">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProcesResultaat" type="{http://logius.nl/digipoort/koppelvlakservices/1.2/}ProcesResultaat" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArrayOfProcesResultaat", propOrder = {
    "procesResultaat"
})
public class ArrayOfProcesResultaat {

    @XmlElement(name = "ProcesResultaat")
    protected List<ProcesResultaat> procesResultaat;

    /**
     * Gets the value of the procesResultaat property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the procesResultaat property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getProcesResultaat().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ProcesResultaat }
     * 
     * 
     */
    public List<ProcesResultaat> getProcesResultaat() {
        if (procesResultaat == null) {
            procesResultaat = new ArrayList<ProcesResultaat>();
        }
        return this.procesResultaat;
    }

}
