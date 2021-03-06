//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.22 at 03:37:05 PM IST 
//


package com.misys.tiplus2.apps.ti.service.messages;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;
import com.misys.tiplus2.apps.ti.service.common.EnigmaBoolean;


/**
 * <p>Java class for TIBaseRateResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TIBaseRateResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="RATE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="15"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BSBOECODE" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="4"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BSBOMSGE" type="{urn:common.service.ti.apps.tiplus2.misys.com}EnigmaBoolean" minOccurs="0"/>
 *         &lt;element name="BSBOMSG" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;minLength value="1"/>
 *               &lt;maxLength value="100"/>
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
@XmlType(name = "TIBaseRateResponse", propOrder = {
    "rate",
    "bsboecode",
    "bsbomsge",
    "bsbomsg"
})
public class TIBaseRateResponse {

    @XmlElement(name = "RATE")
    protected String rate;
    @XmlElementRef(name = "BSBOECODE", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<String> bsboecode;
    @XmlElementRef(name = "BSBOMSGE", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<EnigmaBoolean> bsbomsge;
    @XmlElementRef(name = "BSBOMSG", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<String> bsbomsg;

    /**
     * Gets the value of the rate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRATE() {
        return rate;
    }

    /**
     * Sets the value of the rate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRATE(String value) {
        this.rate = value;
    }

    /**
     * Gets the value of the bsboecode property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBSBOECODE() {
        return bsboecode;
    }

    /**
     * Sets the value of the bsboecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBSBOECODE(JAXBElement<String> value) {
        this.bsboecode = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the bsbomsge property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link EnigmaBoolean }{@code >}
     *     
     */
    public JAXBElement<EnigmaBoolean> getBSBOMSGE() {
        return bsbomsge;
    }

    /**
     * Sets the value of the bsbomsge property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link EnigmaBoolean }{@code >}
     *     
     */
    public void setBSBOMSGE(JAXBElement<EnigmaBoolean> value) {
        this.bsbomsge = ((JAXBElement<EnigmaBoolean> ) value);
    }

    /**
     * Gets the value of the bsbomsg property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getBSBOMSG() {
        return bsbomsg;
    }

    /**
     * Sets the value of the bsbomsg property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setBSBOMSG(JAXBElement<String> value) {
        this.bsbomsg = ((JAXBElement<String> ) value);
    }

}
