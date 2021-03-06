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
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Invoice Table
 * 
 * <p>Java class for ExtEventInvoiceTableType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtEventInvoiceTableType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="INVNUM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INVDAT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="INVOIAM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INVSHIP" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="INVCSTM" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="FBANK" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtEventInvoiceTableType", propOrder = {
    "invnum",
    "invdat",
    "invoiam",
    "invship",
    "invcstm",
    "fbank"
})
public class ExtEventInvoiceTableType {

    @XmlElement(name = "INVNUM")
    protected String invnum;
    @XmlElement(name = "INVDAT")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar invdat;
    @XmlElement(name = "INVOIAM")
    protected String invoiam;
    @XmlElement(name = "INVSHIP")
    protected String invship;
    @XmlElement(name = "INVCSTM")
    protected String invcstm;
    @XmlElement(name = "FBANK")
    protected String fbank;

    /**
     * Gets the value of the invnum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVNUM() {
        return invnum;
    }

    /**
     * Sets the value of the invnum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVNUM(String value) {
        this.invnum = value;
    }

    /**
     * Gets the value of the invdat property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getINVDAT() {
        return invdat;
    }

    /**
     * Sets the value of the invdat property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setINVDAT(XMLGregorianCalendar value) {
        this.invdat = value;
    }

    /**
     * Gets the value of the invoiam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVOIAM() {
        return invoiam;
    }

    /**
     * Sets the value of the invoiam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVOIAM(String value) {
        this.invoiam = value;
    }

    /**
     * Gets the value of the invship property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVSHIP() {
        return invship;
    }

    /**
     * Sets the value of the invship property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVSHIP(String value) {
        this.invship = value;
    }

    /**
     * Gets the value of the invcstm property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getINVCSTM() {
        return invcstm;
    }

    /**
     * Sets the value of the invcstm property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setINVCSTM(String value) {
        this.invcstm = value;
    }

    /**
     * Gets the value of the fbank property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFBANK() {
        return fbank;
    }

    /**
     * Sets the value of the fbank property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFBANK(String value) {
        this.fbank = value;
    }

}
