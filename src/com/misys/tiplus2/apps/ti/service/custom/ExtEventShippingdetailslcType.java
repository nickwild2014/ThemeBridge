//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.03.16 at 03:54:00 PM IST 
//


package com.misys.tiplus2.apps.ti.service.custom;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * Shipping Details LC
 * 
 * <p>Java class for ExtEventShippingdetailslcType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ExtEventShippingdetailslcType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="LCBILLNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LCBILDAT" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="LCPORTCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LCLEODATE" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *         &lt;element name="LCCUSTNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LCFORMNO" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LCEXPAGENC" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LCEXPTYPE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LCDESTCOUN" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LCBLLAMT" type="{http://www.w3.org/2001/XMLSchema}decimal" minOccurs="0"/>
 *         &lt;element name="LCIECODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LCADCODE" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="LCSHICOU" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ExtEventShippingdetailslcType", propOrder = {
    "lcbillno",
    "lcbildat",
    "lcportcode",
    "lcleodate",
    "lccustno",
    "lcformno",
    "lcexpagenc",
    "lcexptype",
    "lcdestcoun",
    "lcbllamt",
    "lciecode",
    "lcadcode",
    "lcshicou"
})
public class ExtEventShippingdetailslcType {

    @XmlElement(name = "LCBILLNO")
    protected String lcbillno;
    @XmlElement(name = "LCBILDAT")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lcbildat;
    @XmlElement(name = "LCPORTCODE")
    protected String lcportcode;
    @XmlElement(name = "LCLEODATE")
    @XmlSchemaType(name = "date")
    protected XMLGregorianCalendar lcleodate;
    @XmlElement(name = "LCCUSTNO")
    protected String lccustno;
    @XmlElement(name = "LCFORMNO")
    protected String lcformno;
    @XmlElement(name = "LCEXPAGENC")
    protected String lcexpagenc;
    @XmlElement(name = "LCEXPTYPE")
    protected String lcexptype;
    @XmlElement(name = "LCDESTCOUN")
    protected String lcdestcoun;
    @XmlElement(name = "LCBLLAMT")
    protected BigDecimal lcbllamt;
    @XmlElement(name = "LCIECODE")
    protected String lciecode;
    @XmlElement(name = "LCADCODE")
    protected String lcadcode;
    @XmlElement(name = "LCSHICOU")
    protected String lcshicou;

    /**
     * Gets the value of the lcbillno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLCBILLNO() {
        return lcbillno;
    }

    /**
     * Sets the value of the lcbillno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLCBILLNO(String value) {
        this.lcbillno = value;
    }

    /**
     * Gets the value of the lcbildat property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLCBILDAT() {
        return lcbildat;
    }

    /**
     * Sets the value of the lcbildat property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLCBILDAT(XMLGregorianCalendar value) {
        this.lcbildat = value;
    }

    /**
     * Gets the value of the lcportcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLCPORTCODE() {
        return lcportcode;
    }

    /**
     * Sets the value of the lcportcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLCPORTCODE(String value) {
        this.lcportcode = value;
    }

    /**
     * Gets the value of the lcleodate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getLCLEODATE() {
        return lcleodate;
    }

    /**
     * Sets the value of the lcleodate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setLCLEODATE(XMLGregorianCalendar value) {
        this.lcleodate = value;
    }

    /**
     * Gets the value of the lccustno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLCCUSTNO() {
        return lccustno;
    }

    /**
     * Sets the value of the lccustno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLCCUSTNO(String value) {
        this.lccustno = value;
    }

    /**
     * Gets the value of the lcformno property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLCFORMNO() {
        return lcformno;
    }

    /**
     * Sets the value of the lcformno property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLCFORMNO(String value) {
        this.lcformno = value;
    }

    /**
     * Gets the value of the lcexpagenc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLCEXPAGENC() {
        return lcexpagenc;
    }

    /**
     * Sets the value of the lcexpagenc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLCEXPAGENC(String value) {
        this.lcexpagenc = value;
    }

    /**
     * Gets the value of the lcexptype property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLCEXPTYPE() {
        return lcexptype;
    }

    /**
     * Sets the value of the lcexptype property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLCEXPTYPE(String value) {
        this.lcexptype = value;
    }

    /**
     * Gets the value of the lcdestcoun property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLCDESTCOUN() {
        return lcdestcoun;
    }

    /**
     * Sets the value of the lcdestcoun property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLCDESTCOUN(String value) {
        this.lcdestcoun = value;
    }

    /**
     * Gets the value of the lcbllamt property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getLCBLLAMT() {
        return lcbllamt;
    }

    /**
     * Sets the value of the lcbllamt property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setLCBLLAMT(BigDecimal value) {
        this.lcbllamt = value;
    }

    /**
     * Gets the value of the lciecode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLCIECODE() {
        return lciecode;
    }

    /**
     * Sets the value of the lciecode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLCIECODE(String value) {
        this.lciecode = value;
    }

    /**
     * Gets the value of the lcadcode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLCADCODE() {
        return lcadcode;
    }

    /**
     * Sets the value of the lcadcode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLCADCODE(String value) {
        this.lcadcode = value;
    }

    /**
     * Gets the value of the lcshicou property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLCSHICOU() {
        return lcshicou;
    }

    /**
     * Sets the value of the lcshicou property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLCSHICOU(String value) {
        this.lcshicou = value;
    }

}
