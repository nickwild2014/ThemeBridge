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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.misys.tiplus2.apps.ti.service.common.GWRCustomer;


/**
 * <p>Java class for GWRSCFDefiningMessageBase complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GWRSCFDefiningMessageBase">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GatewayRWorkingCapitalFinance">
 *       &lt;sequence>
 *         &lt;element name="TheirRef" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRReference" minOccurs="0"/>
 *         &lt;element name="eBankMasterRef" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWREBankReference" minOccurs="0"/>
 *         &lt;element name="eBankEventRef" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWREBankReference" minOccurs="0"/>
 *         &lt;element name="AnchorParty" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRCustomer" minOccurs="0"/>
 *         &lt;element name="Programme" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSCFProgramme" minOccurs="0"/>
 *         &lt;element name="Seller" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRCustomerMnemonic" minOccurs="0"/>
 *         &lt;element name="Buyer" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRCustomerMnemonic" minOccurs="0"/>
 *         &lt;element name="ReceivedOn" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRDate" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GWRSCFDefiningMessageBase", propOrder = {
    "theirRef",
    "eBankMasterRef",
    "eBankEventRef",
    "anchorParty",
    "programme",
    "seller",
    "buyer",
    "receivedOn"
})
@XmlSeeAlso({
    GWRSCFDiscountCancel.class,
    GWRSCFDiscount.class,
    GatewayRCreditNote.class,
    GatewayRInvoice.class
})
public class GWRSCFDefiningMessageBase
    extends GatewayRWorkingCapitalFinance
{

    @XmlElement(name = "TheirRef")
    protected String theirRef;
    protected String eBankMasterRef;
    protected String eBankEventRef;
    @XmlElement(name = "AnchorParty")
    protected GWRCustomer anchorParty;
    @XmlElement(name = "Programme")
    protected String programme;
    @XmlElement(name = "Seller")
    protected String seller;
    @XmlElement(name = "Buyer")
    protected String buyer;
    @XmlElementRef(name = "ReceivedOn", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<XMLGregorianCalendar> receivedOn;

    /**
     * Gets the value of the theirRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTheirRef() {
        return theirRef;
    }

    /**
     * Sets the value of the theirRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTheirRef(String value) {
        this.theirRef = value;
    }

    /**
     * Gets the value of the eBankMasterRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEBankMasterRef() {
        return eBankMasterRef;
    }

    /**
     * Sets the value of the eBankMasterRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEBankMasterRef(String value) {
        this.eBankMasterRef = value;
    }

    /**
     * Gets the value of the eBankEventRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEBankEventRef() {
        return eBankEventRef;
    }

    /**
     * Sets the value of the eBankEventRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEBankEventRef(String value) {
        this.eBankEventRef = value;
    }

    /**
     * Gets the value of the anchorParty property.
     * 
     * @return
     *     possible object is
     *     {@link GWRCustomer }
     *     
     */
    public GWRCustomer getAnchorParty() {
        return anchorParty;
    }

    /**
     * Sets the value of the anchorParty property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRCustomer }
     *     
     */
    public void setAnchorParty(GWRCustomer value) {
        this.anchorParty = value;
    }

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
     * Gets the value of the seller property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeller() {
        return seller;
    }

    /**
     * Sets the value of the seller property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeller(String value) {
        this.seller = value;
    }

    /**
     * Gets the value of the buyer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBuyer() {
        return buyer;
    }

    /**
     * Sets the value of the buyer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBuyer(String value) {
        this.buyer = value;
    }

    /**
     * Gets the value of the receivedOn property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public JAXBElement<XMLGregorianCalendar> getReceivedOn() {
        return receivedOn;
    }

    /**
     * Sets the value of the receivedOn property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     *     
     */
    public void setReceivedOn(JAXBElement<XMLGregorianCalendar> value) {
        this.receivedOn = ((JAXBElement<XMLGregorianCalendar> ) value);
    }

}
