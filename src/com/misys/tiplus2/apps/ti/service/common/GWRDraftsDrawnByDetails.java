//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.22 at 03:37:05 PM IST 
//


package com.misys.tiplus2.apps.ti.service.common;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GWRDraftsDrawnByDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GWRDraftsDrawnByDetails">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="WhoDraftsDrawnBy" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;enumeration value="C"/>
 *               &lt;enumeration value="O"/>
 *               &lt;enumeration value="B"/>
 *               &lt;enumeration value="N"/>
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="1"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="DraftsDrawnBy" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRParty" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GWRDraftsDrawnByDetails", propOrder = {
    "whoDraftsDrawnBy",
    "draftsDrawnBy"
})
public class GWRDraftsDrawnByDetails {

    @XmlElementRef(name = "WhoDraftsDrawnBy", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<String> whoDraftsDrawnBy;
    @XmlElement(name = "DraftsDrawnBy")
    protected GWRParty draftsDrawnBy;

    /**
     * Gets the value of the whoDraftsDrawnBy property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getWhoDraftsDrawnBy() {
        return whoDraftsDrawnBy;
    }

    /**
     * Sets the value of the whoDraftsDrawnBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setWhoDraftsDrawnBy(JAXBElement<String> value) {
        this.whoDraftsDrawnBy = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the draftsDrawnBy property.
     * 
     * @return
     *     possible object is
     *     {@link GWRParty }
     *     
     */
    public GWRParty getDraftsDrawnBy() {
        return draftsDrawnBy;
    }

    /**
     * Sets the value of the draftsDrawnBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRParty }
     *     
     */
    public void setDraftsDrawnBy(GWRParty value) {
        this.draftsDrawnBy = value;
    }

}
