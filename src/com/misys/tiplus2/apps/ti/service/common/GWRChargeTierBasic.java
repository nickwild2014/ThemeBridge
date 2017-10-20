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
 * Charge Tier basic.
 * 
 * <p>Java class for GWRChargeTierBasic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GWRChargeTierBasic">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Amount" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRAmount" minOccurs="0"/>
 *         &lt;element name="MinAmount" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRAmount" minOccurs="0"/>
 *         &lt;element name="MaxAmount" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRAmount" minOccurs="0"/>
 *         &lt;element name="Period" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRPeriod" minOccurs="0"/>
 *         &lt;element name="ChargeFrequency" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRChargeFrequency" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GWRChargeTierBasic", propOrder = {
    "amount",
    "minAmount",
    "maxAmount",
    "period",
    "chargeFrequency"
})
public class GWRChargeTierBasic {

    @XmlElementRef(name = "Amount", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<Long> amount;
    @XmlElementRef(name = "MinAmount", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<Long> minAmount;
    @XmlElementRef(name = "MaxAmount", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<Long> maxAmount;
    @XmlElement(name = "Period")
    protected GWRPeriod period;
    @XmlElementRef(name = "ChargeFrequency", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<GWRChargeFrequency> chargeFrequency;

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setAmount(JAXBElement<Long> value) {
        this.amount = ((JAXBElement<Long> ) value);
    }

    /**
     * Gets the value of the minAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getMinAmount() {
        return minAmount;
    }

    /**
     * Sets the value of the minAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setMinAmount(JAXBElement<Long> value) {
        this.minAmount = ((JAXBElement<Long> ) value);
    }

    /**
     * Gets the value of the maxAmount property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public JAXBElement<Long> getMaxAmount() {
        return maxAmount;
    }

    /**
     * Sets the value of the maxAmount property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Long }{@code >}
     *     
     */
    public void setMaxAmount(JAXBElement<Long> value) {
        this.maxAmount = ((JAXBElement<Long> ) value);
    }

    /**
     * Gets the value of the period property.
     * 
     * @return
     *     possible object is
     *     {@link GWRPeriod }
     *     
     */
    public GWRPeriod getPeriod() {
        return period;
    }

    /**
     * Sets the value of the period property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRPeriod }
     *     
     */
    public void setPeriod(GWRPeriod value) {
        this.period = value;
    }

    /**
     * Gets the value of the chargeFrequency property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GWRChargeFrequency }{@code >}
     *     
     */
    public JAXBElement<GWRChargeFrequency> getChargeFrequency() {
        return chargeFrequency;
    }

    /**
     * Sets the value of the chargeFrequency property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GWRChargeFrequency }{@code >}
     *     
     */
    public void setChargeFrequency(JAXBElement<GWRChargeFrequency> value) {
        this.chargeFrequency = ((JAXBElement<GWRChargeFrequency> ) value);
    }

}
