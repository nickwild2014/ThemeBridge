//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.22 at 03:37:05 PM IST 
//


package com.misys.tiplus2.apps.ti.service.messages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.misys.tiplus2.apps.ti.service.custom.PpPosting;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}EQ3Movement">
 *       &lt;sequence>
 *         &lt;element name="ExtraData" type="{urn:custom.service.ti.apps.tiplus2.misys.com}PpPosting" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "extraData"
})
public class Projection
    extends EQ3Movement
{

    @XmlElement(name = "ExtraData")
    protected PpPosting extraData;

    /**
     * Gets the value of the extraData property.
     * 
     * @return
     *     possible object is
     *     {@link PpPosting }
     *     
     */
    public PpPosting getExtraData() {
        return extraData;
    }

    /**
     * Sets the value of the extraData property.
     * 
     * @param value
     *     allowed object is
     *     {@link PpPosting }
     *     
     */
    public void setExtraData(PpPosting value) {
        this.extraData = value;
    }

}
