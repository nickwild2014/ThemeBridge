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
import javax.xml.bind.annotation.XmlType;
import com.misys.tiplus2.apps.ti.service.common.GWRInterestSubType;


/**
 * name to RelatedTaxChargeType.
 * 
 * <p>Java class for STRInterestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="STRInterestType">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}STRReleaseTemplate">
 *       &lt;sequence>
 *         &lt;element name="RelatedTaxChargeType" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRChargeType" minOccurs="0"/>
 *         &lt;element name="InterestSubType" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRInterestSubType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STRInterestType", propOrder = {
    "relatedTaxChargeType",
    "interestSubType"
})
public class STRInterestType
    extends STRReleaseTemplate
{

    @XmlElement(name = "RelatedTaxChargeType")
    protected String relatedTaxChargeType;
    @XmlElement(name = "InterestSubType")
    protected GWRInterestSubType interestSubType;

    /**
     * Gets the value of the relatedTaxChargeType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelatedTaxChargeType() {
        return relatedTaxChargeType;
    }

    /**
     * Sets the value of the relatedTaxChargeType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelatedTaxChargeType(String value) {
        this.relatedTaxChargeType = value;
    }

    /**
     * Gets the value of the interestSubType property.
     * 
     * @return
     *     possible object is
     *     {@link GWRInterestSubType }
     *     
     */
    public GWRInterestSubType getInterestSubType() {
        return interestSubType;
    }

    /**
     * Sets the value of the interestSubType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRInterestSubType }
     *     
     */
    public void setInterestSubType(GWRInterestSubType value) {
        this.interestSubType = value;
    }

}
