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
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for GWRRevolving complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GWRRevolving">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Revolving" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBool" minOccurs="0"/>
 *         &lt;element name="Cumulative" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBool" minOccurs="0"/>
 *         &lt;element name="Period" minOccurs="0">
 *           &lt;simpleType>
 *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               &lt;maxLength value="6"/>
 *             &lt;/restriction>
 *           &lt;/simpleType>
 *         &lt;/element>
 *         &lt;element name="Revolutions" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRInteger" minOccurs="0"/>
 *         &lt;element name="NextDate" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRDate" minOccurs="0"/>
 *         &lt;element name="NoticeDays" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRInteger" minOccurs="0"/>
 *         &lt;element name="ChargeToFirstPeriod" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBool" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GWRRevolving", propOrder = {
    "revolving",
    "cumulative",
    "period",
    "revolutions",
    "nextDate",
    "noticeDays",
    "chargeToFirstPeriod"
})
public class GWRRevolving {

    @XmlElement(name = "Revolving")
    protected EnigmaBoolean revolving;
    @XmlElement(name = "Cumulative")
    protected EnigmaBoolean cumulative;
    @XmlElement(name = "Period")
    protected String period;
    @XmlElementRef(name = "Revolutions", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<Integer> revolutions;
    @XmlElementRef(name = "NextDate", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> nextDate;
    @XmlElementRef(name = "NoticeDays", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<Integer> noticeDays;
    @XmlElement(name = "ChargeToFirstPeriod")
    protected EnigmaBoolean chargeToFirstPeriod;

    /**
     * Gets the value of the revolving property.
     * 
     * @return
     *     possible object is
     *     {@link EnigmaBoolean }
     *     
     */
    public EnigmaBoolean getRevolving() {
        return revolving;
    }

    /**
     * Sets the value of the revolving property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnigmaBoolean }
     *     
     */
    public void setRevolving(EnigmaBoolean value) {
        this.revolving = value;
    }

    /**
     * Gets the value of the cumulative property.
     * 
     * @return
     *     possible object is
     *     {@link EnigmaBoolean }
     *     
     */
    public EnigmaBoolean getCumulative() {
        return cumulative;
    }

    /**
     * Sets the value of the cumulative property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnigmaBoolean }
     *     
     */
    public void setCumulative(EnigmaBoolean value) {
        this.cumulative = value;
    }

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPeriod(String value) {
        this.period = value;
    }

    /**
     * Gets the value of the revolutions property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getRevolutions() {
        return revolutions;
    }

    /**
     * Sets the value of the revolutions property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setRevolutions(JAXBElement<Integer> value) {
        this.revolutions = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the nextDate property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getNextDate() {
        return nextDate;
    }

    /**
     * Sets the value of the nextDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setNextDate(JAXBElement<XMLGregorianCalendar> value) {
        this.nextDate = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

    /**
     * Gets the value of the noticeDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getNoticeDays() {
        return noticeDays;
    }

    /**
     * Sets the value of the noticeDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setNoticeDays(JAXBElement<Integer> value) {
        this.noticeDays = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the chargeToFirstPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link EnigmaBoolean }
     *     
     */
    public EnigmaBoolean getChargeToFirstPeriod() {
        return chargeToFirstPeriod;
    }

    /**
     * Sets the value of the chargeToFirstPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnigmaBoolean }
     *     
     */
    public void setChargeToFirstPeriod(EnigmaBoolean value) {
        this.chargeToFirstPeriod = value;
    }

}
