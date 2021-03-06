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
 * <p>Java class for GWRSCFCounterparty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GWRSCFCounterparty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Programme" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSCFProgramme" minOccurs="0"/>
 *         &lt;element name="BuyerOrSeller" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRCustomerMnemonic" minOccurs="0"/>
 *         &lt;element name="Role" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBuyerSeller" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GWRSCFCounterparty", propOrder = {
    "programme",
    "buyerOrSeller",
    "role"
})
public class GWRSCFCounterparty {

    @XmlElement(name = "Programme")
    protected String programme;
    @XmlElement(name = "BuyerOrSeller")
    protected String buyerOrSeller;
    @XmlElementRef(name = "Role", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<GWRBuyerSeller> role;

    /**
     * Gets the value of the programme property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProgramme() {
        return programme;
    }

    /**
     * Sets the value of the programme property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProgramme(String value) {
        this.programme = value;
    }

    /**
     * Gets the value of the buyerOrSeller property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyerOrSeller() {
        return buyerOrSeller;
    }

    /**
     * Sets the value of the buyerOrSeller property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyerOrSeller(String value) {
        this.buyerOrSeller = value;
    }

    /**
     * Gets the value of the role property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GWRBuyerSeller }{@code >}
     *     
     */
    public JAXBElement<GWRBuyerSeller> getRole() {
        return role;
    }

    /**
     * Sets the value of the role property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GWRBuyerSeller }{@code >}
     *     
     */
    public void setRole(JAXBElement<GWRBuyerSeller> value) {
        this.role = ((JAXBElement<GWRBuyerSeller> ) value);
    }

}
