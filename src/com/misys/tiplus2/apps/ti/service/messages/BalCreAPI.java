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


/**
 * .
 * 
 * <p>Java class for BalCreAPI complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="BalCreAPI">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MSTEVTREF" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="BATCHSIZE" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="POSTINGS" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="30000"/>
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
@XmlType(name = "BalCreAPI", propOrder = {
    "mstevtref",
    "batchsize",
    "postings"
})
public class BalCreAPI {

    @XmlElement(name = "MSTEVTREF")
    protected String mstevtref;
    @XmlElementRef(name = "BATCHSIZE", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<Integer> batchsize;
    @XmlElement(name = "POSTINGS")
    protected String postings;

    /**
     * Gets the value of the mstevtref property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMSTEVTREF() {
        return mstevtref;
    }

    /**
     * Sets the value of the mstevtref property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMSTEVTREF(String value) {
        this.mstevtref = value;
    }

    /**
     * Gets the value of the batchsize property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getBATCHSIZE() {
        return batchsize;
    }

    /**
     * Sets the value of the batchsize property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setBATCHSIZE(JAXBElement<Integer> value) {
        this.batchsize = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the postings property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPOSTINGS() {
        return postings;
    }

    /**
     * Sets the value of the postings property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPOSTINGS(String value) {
        this.postings = value;
    }

}
