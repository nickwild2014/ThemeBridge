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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * .
 * 
 * <p>Java class for GWR499AMR complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GWR499AMR">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GWR799">
 *       &lt;sequence>
 *         &lt;element name="AmendmentNarrative" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GWR499AMR", propOrder = {
    "amendmentNarrative"
})
@XmlSeeAlso({
    TFCOLAMR.class
})
public class GWR499AMR
    extends GWR799
{

    @XmlElement(name = "AmendmentNarrative")
    protected String amendmentNarrative;

    /**
     * Gets the value of the amendmentNarrative property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAmendmentNarrative() {
        return amendmentNarrative;
    }

    /**
     * Sets the value of the amendmentNarrative property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAmendmentNarrative(String value) {
        this.amendmentNarrative = value;
    }

}
