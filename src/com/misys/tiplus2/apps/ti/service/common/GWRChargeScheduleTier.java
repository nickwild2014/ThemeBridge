//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.22 at 03:37:05 PM IST 
//


package com.misys.tiplus2.apps.ti.service.common;

import java.math.BigDecimal;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * The cutoff value for a tiered charge.  For example there may be a discounted rate where the amount (converted to charge ccy) is over 500,000.
 * 
 * <p>Java class for GWRChargeScheduleTier complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GWRChargeScheduleTier">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ChargeTierBasic" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRChargeTierBasic" minOccurs="0"/>
 *         &lt;element name="Amount" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRAmount" minOccurs="0"/>
 *         &lt;element name="BaseRate" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBaseRateCode" minOccurs="0"/>
 *         &lt;element name="DifferentialRate" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRDifferentialRate" minOccurs="0"/>
 *         &lt;element name="Interest" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRRate" minOccurs="0"/>
 *         &lt;element name="Percent" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRRate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GWRChargeScheduleTier", propOrder = {
    "chargeTierBasic",
    "amount",
    "baseRate",
    "differentialRate",
    "interest",
    "percent"
})
public class GWRChargeScheduleTier {

    @XmlElement(name = "ChargeTierBasic")
    protected GWRChargeTierBasic chargeTierBasic;
    @XmlElementRef(name = "Amount", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<Long> amount;
    @XmlElement(name = "BaseRate")
    protected String baseRate;
    @XmlElement(name = "DifferentialRate")
    protected String differentialRate;
    @XmlElement(name = "Interest")
    protected BigDecimal interest;
    @XmlElement(name = "Percent")
    protected BigDecimal percent;

    /**
     * Gets the value of the chargeTierBasic property.
     * 
     * @return
     *     possible object is
     *     {@link GWRChargeTierBasic }
     *     
     */
    public GWRChargeTierBasic getChargeTierBasic() {
        return chargeTierBasic;
    }

    /**
     * Sets the value of the chargeTierBasic property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRChargeTierBasic }
     *     
     */
    public void setChargeTierBasic(GWRChargeTierBasic value) {
        this.chargeTierBasic = value;
    }

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
     * Gets the value of the baseRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBaseRate() {
        return baseRate;
    }

    /**
     * Sets the value of the baseRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBaseRate(String value) {
        this.baseRate = value;
    }

    /**
     * Gets the value of the differentialRate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDifferentialRate() {
        return differentialRate;
    }

    /**
     * Sets the value of the differentialRate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDifferentialRate(String value) {
        this.differentialRate = value;
    }

    /**
     * Gets the value of the interest property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getInterest() {
        return interest;
    }

    /**
     * Sets the value of the interest property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setInterest(BigDecimal value) {
        this.interest = value;
    }

    /**
     * Gets the value of the percent property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getPercent() {
        return percent;
    }

    /**
     * Sets the value of the percent property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setPercent(BigDecimal value) {
        this.percent = value;
    }

}
