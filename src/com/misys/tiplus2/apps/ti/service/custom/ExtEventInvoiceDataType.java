//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.16 at 03:54:00 PM IST 
//


package com.misys.tiplus2.apps.ti.service.custom;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Invoice Data
 * 
 * <p>Java class for ExtEventInvoiceDataType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtEventInvoiceDataType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="INVNUMB" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INDATE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INAMOUT" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtEventInvoiceDataType", propOrder = {
    "invnumb",
    "indate",
    "inamout"
})
public class ExtEventInvoiceDataType {

    @XmlElement(name = "INVNUMB")
    protected String invnumb;
    @XmlElement(name = "INDATE")
    protected String indate;
    @XmlElement(name = "INAMOUT")
    protected String inamout;

    /**
     * Gets the value of the invnumb property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVNUMB() {
        return invnumb;
    }

    /**
     * Sets the value of the invnumb property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVNUMB(String value) {
        this.invnumb = value;
    }

    /**
     * Gets the value of the indate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINDATE() {
        return indate;
    }

    /**
     * Sets the value of the indate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINDATE(String value) {
        this.indate = value;
    }

    /**
     * Gets the value of the inamout property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINAMOUT() {
        return inamout;
    }

    /**
     * Sets the value of the inamout property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINAMOUT(String value) {
        this.inamout = value;
    }

}
