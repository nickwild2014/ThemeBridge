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


/**
 * .
 * 
 * <p>Java class for STRProcessingCycleMap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="STRProcessingCycleMap">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GatewaySystemTailoring">
 *       &lt;sequence>
 *         &lt;element name="MainBankingEntity" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBranch" minOccurs="0"/>
 *         &lt;element name="ProcessingCycle" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRProcessingCycle" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STRProcessingCycleMap", propOrder = {
    "mainBankingEntity",
    "processingCycle"
})
public class STRProcessingCycleMap
    extends GatewaySystemTailoring
{

    @XmlElement(name = "MainBankingEntity")
    protected String mainBankingEntity;
    @XmlElement(name = "ProcessingCycle")
    protected String processingCycle;

    /**
     * Gets the value of the mainBankingEntity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainBankingEntity() {
        return mainBankingEntity;
    }

    /**
     * Sets the value of the mainBankingEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainBankingEntity(String value) {
        this.mainBankingEntity = value;
    }

    /**
     * Gets the value of the processingCycle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessingCycle() {
        return processingCycle;
    }

    /**
     * Sets the value of the processingCycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessingCycle(String value) {
        this.processingCycle = value;
    }

}
