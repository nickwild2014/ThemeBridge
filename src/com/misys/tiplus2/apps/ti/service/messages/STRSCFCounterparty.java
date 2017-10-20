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
import com.misys.tiplus2.apps.ti.service.common.EnigmaBoolean;
import com.misys.tiplus2.apps.ti.service.common.GWRBuyerSeller;
import com.misys.tiplus2.apps.ti.service.common.GWRCustomer;
import com.misys.tiplus2.apps.ti.service.common.GWRInvoiceBuyerStatus;
import com.misys.tiplus2.apps.ti.service.common.GWRMoney;


/**
 * .
 * 
 * <p>Java class for STRSCFCounterparty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="STRSCFCounterparty">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GatewayStatic">
 *       &lt;sequence>
 *         &lt;element name="Programme" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSCFProgramme" minOccurs="0"/>
 *         &lt;element name="BuyerOrSeller" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRCustomerMnemonic" minOccurs="0"/>
 *         &lt;element name="Role" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBuyerSeller" minOccurs="0"/>
 *         &lt;element name="Customer" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRCustomer" minOccurs="0"/>
 *         &lt;element name="Name" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRFullName" minOccurs="0"/>
 *         &lt;element name="Salutation" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSalutation" minOccurs="0"/>
 *         &lt;element name="NameAndAddress" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRNameAndAddress" minOccurs="0"/>
 *         &lt;element name="ZIP" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRZip" minOccurs="0"/>
 *         &lt;element name="Phone" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRPhoneNumber" minOccurs="0"/>
 *         &lt;element name="Fax" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRFaxNumber" minOccurs="0"/>
 *         &lt;element name="Telex" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRTelex" minOccurs="0"/>
 *         &lt;element name="TelexAnswerBack" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRTelexAnswerBack" minOccurs="0"/>
 *         &lt;element name="Email" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWREmailAddress" minOccurs="0"/>
 *         &lt;element name="SwiftAddress" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSwiftAddress" minOccurs="0"/>
 *         &lt;element name="SWIFTCompatibleAddress" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRNameAndAddress" minOccurs="0"/>
 *         &lt;element name="Country" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRCountry" minOccurs="0"/>
 *         &lt;element name="TransferMethod" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRTransferMethod" minOccurs="0"/>
 *         &lt;element name="Language" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRLanguage" minOccurs="0"/>
 *         &lt;element name="Status" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRInvoiceBuyerStatus" minOccurs="0"/>
 *         &lt;element name="InvoiceLimit" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRMoney" minOccurs="0"/>
 *         &lt;element name="TransliterateSWIFT" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBool" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STRSCFCounterparty", propOrder = {
    "programme",
    "buyerOrSeller",
    "role",
    "customer",
    "name",
    "salutation",
    "nameAndAddress",
    "zip",
    "phone",
    "fax",
    "telex",
    "telexAnswerBack",
    "email",
    "swiftAddress",
    "swiftCompatibleAddress",
    "country",
    "transferMethod",
    "language",
    "status",
    "invoiceLimit",
    "transliterateSWIFT"
})
public class STRSCFCounterparty
    extends GatewayStatic
{

    @XmlElement(name = "Programme")
    protected String programme;
    @XmlElement(name = "BuyerOrSeller")
    protected String buyerOrSeller;
    @XmlElementRef(name = "Role", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<GWRBuyerSeller> role;
    @XmlElement(name = "Customer")
    protected GWRCustomer customer;
    @XmlElement(name = "Name")
    protected String name;
    @XmlElement(name = "Salutation")
    protected String salutation;
    @XmlElement(name = "NameAndAddress")
    protected String nameAndAddress;
    @XmlElement(name = "ZIP")
    protected String zip;
    @XmlElement(name = "Phone")
    protected String phone;
    @XmlElement(name = "Fax")
    protected String fax;
    @XmlElement(name = "Telex")
    protected String telex;
    @XmlElement(name = "TelexAnswerBack")
    protected String telexAnswerBack;
    @XmlElement(name = "Email")
    protected String email;
    @XmlElement(name = "SwiftAddress")
    protected String swiftAddress;
    @XmlElement(name = "SWIFTCompatibleAddress")
    protected String swiftCompatibleAddress;
    @XmlElementRef(name = "Country", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<String> country;
    @XmlElement(name = "TransferMethod")
    protected String transferMethod;
    @XmlElement(name = "Language")
    protected String language;
    @XmlElement(name = "Status")
    protected GWRInvoiceBuyerStatus status;
    @XmlElement(name = "InvoiceLimit")
    protected GWRMoney invoiceLimit;
    @XmlElement(name = "TransliterateSWIFT")
    protected EnigmaBoolean transliterateSWIFT;

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

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link GWRCustomer }
     *     
     */
    public GWRCustomer getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRCustomer }
     *     
     */
    public void setCustomer(GWRCustomer value) {
        this.customer = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the salutation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSalutation() {
        return salutation;
    }

    /**
     * Sets the value of the salutation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSalutation(String value) {
        this.salutation = value;
    }

    /**
     * Gets the value of the nameAndAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameAndAddress() {
        return nameAndAddress;
    }

    /**
     * Sets the value of the nameAndAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameAndAddress(String value) {
        this.nameAndAddress = value;
    }

    /**
     * Gets the value of the zip property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZIP() {
        return zip;
    }

    /**
     * Sets the value of the zip property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZIP(String value) {
        this.zip = value;
    }

    /**
     * Gets the value of the phone property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the value of the phone property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPhone(String value) {
        this.phone = value;
    }

    /**
     * Gets the value of the fax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFax() {
        return fax;
    }

    /**
     * Sets the value of the fax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFax(String value) {
        this.fax = value;
    }

    /**
     * Gets the value of the telex property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelex() {
        return telex;
    }

    /**
     * Sets the value of the telex property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelex(String value) {
        this.telex = value;
    }

    /**
     * Gets the value of the telexAnswerBack property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelexAnswerBack() {
        return telexAnswerBack;
    }

    /**
     * Sets the value of the telexAnswerBack property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelexAnswerBack(String value) {
        this.telexAnswerBack = value;
    }

    /**
     * Gets the value of the email property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the value of the email property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEmail(String value) {
        this.email = value;
    }

    /**
     * Gets the value of the swiftAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSwiftAddress() {
        return swiftAddress;
    }

    /**
     * Sets the value of the swiftAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSwiftAddress(String value) {
        this.swiftAddress = value;
    }

    /**
     * Gets the value of the swiftCompatibleAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSWIFTCompatibleAddress() {
        return swiftCompatibleAddress;
    }

    /**
     * Sets the value of the swiftCompatibleAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSWIFTCompatibleAddress(String value) {
        this.swiftCompatibleAddress = value;
    }

    /**
     * Gets the value of the country property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCountry() {
        return country;
    }

    /**
     * Sets the value of the country property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCountry(JAXBElement<String> value) {
        this.country = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the transferMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransferMethod() {
        return transferMethod;
    }

    /**
     * Sets the value of the transferMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransferMethod(String value) {
        this.transferMethod = value;
    }

    /**
     * Gets the value of the language property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets the value of the language property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLanguage(String value) {
        this.language = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link GWRInvoiceBuyerStatus }
     *     
     */
    public GWRInvoiceBuyerStatus getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRInvoiceBuyerStatus }
     *     
     */
    public void setStatus(GWRInvoiceBuyerStatus value) {
        this.status = value;
    }

    /**
     * Gets the value of the invoiceLimit property.
     * 
     * @return
     *     possible object is
     *     {@link GWRMoney }
     *     
     */
    public GWRMoney getInvoiceLimit() {
        return invoiceLimit;
    }

    /**
     * Sets the value of the invoiceLimit property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRMoney }
     *     
     */
    public void setInvoiceLimit(GWRMoney value) {
        this.invoiceLimit = value;
    }

    /**
     * Gets the value of the transliterateSWIFT property.
     * 
     * @return
     *     possible object is
     *     {@link EnigmaBoolean }
     *     
     */
    public EnigmaBoolean getTransliterateSWIFT() {
        return transliterateSWIFT;
    }

    /**
     * Sets the value of the transliterateSWIFT property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnigmaBoolean }
     *     
     */
    public void setTransliterateSWIFT(EnigmaBoolean value) {
        this.transliterateSWIFT = value;
    }

}
