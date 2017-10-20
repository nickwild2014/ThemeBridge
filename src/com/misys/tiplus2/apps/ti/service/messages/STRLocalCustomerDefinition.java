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
 * Local Customer Definition.
 * 
 * <p>Java class for STRLocalCustomerDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="STRLocalCustomerDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GatewaySystemTailoring">
 *       &lt;sequence>
 *         &lt;element name="SourceBankingBusiness" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSourceBankingBusiness" minOccurs="0"/>
 *         &lt;element name="Prefix" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRLocalCustomerPrefix" minOccurs="0"/>
 *         &lt;element name="StartRange" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBigInteger" minOccurs="0"/>
 *         &lt;element name="EndRange" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBigInteger" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STRLocalCustomerDefinition", propOrder = {
    "sourceBankingBusiness",
    "prefix",
    "startRange",
    "endRange"
})
public class STRLocalCustomerDefinition
    extends GatewaySystemTailoring
{

    @XmlElement(name = "SourceBankingBusiness")
    protected String sourceBankingBusiness;
    @XmlElement(name = "Prefix")
    protected String prefix;
    @XmlElementRef(name = "StartRange", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<Integer> startRange;
    @XmlElementRef(name = "EndRange", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<Integer> endRange;

    /**
     * Gets the value of the sourceBankingBusiness property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSourceBankingBusiness() {
        return sourceBankingBusiness;
    }

    /**
     * Sets the value of the sourceBankingBusiness property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSourceBankingBusiness(String value) {
        this.sourceBankingBusiness = value;
    }

    /**
     * Gets the value of the prefix property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrefix() {
        return prefix;
    }

    /**
     * Sets the value of the prefix property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrefix(String value) {
        this.prefix = value;
    }

    /**
     * Gets the value of the startRange property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getStartRange() {
        return startRange;
    }

    /**
     * Sets the value of the startRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setStartRange(JAXBElement<Integer> value) {
        this.startRange = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the endRange property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getEndRange() {
        return endRange;
    }

    /**
     * Sets the value of the endRange property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setEndRange(JAXBElement<Integer> value) {
        this.endRange = ((JAXBElement<Integer> ) value);
    }

}