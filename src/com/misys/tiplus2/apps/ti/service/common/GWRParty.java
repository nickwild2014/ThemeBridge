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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * TelexAnswerBack, Email, FaxNumber .
 * 
 * <p>Java class for GWRParty complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GWRParty">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Customer" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRCustomerMnemonic" minOccurs="0"/>
 *         &lt;element name="NameAddress" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRFreeFormatNameAndAddress" minOccurs="0"/>
 *         &lt;element name="SwiftAddress" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSwiftAddress" minOccurs="0"/>
 *         &lt;element name="Reference" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRReference" minOccurs="0"/>
 *         &lt;element name="Contact" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSalutation" minOccurs="0"/>
 *         &lt;element name="ZipCode" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRZip" minOccurs="0"/>
 *         &lt;element name="Telephone" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRPhoneNumber" minOccurs="0"/>
 *         &lt;element name="FaxNumber" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRFaxNumber" minOccurs="0"/>
 *         &lt;element name="TelexNumber" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRTelex" minOccurs="0"/>
 *         &lt;element name="Country" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRCountry" minOccurs="0"/>
 *         &lt;element name="TelexAnswerBack" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRTelexAnswerBack" minOccurs="0"/>
 *         &lt;element name="Email" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWREmailAddress" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GWRParty", propOrder = {
    "customer",
    "nameAddress",
    "swiftAddress",
    "reference",
    "contact",
    "zipCode",
    "telephone",
    "faxNumber",
    "telexNumber",
    "country",
    "telexAnswerBack",
    "email"
})
@XmlSeeAlso({
    GWRBuyerParty.class,
    GWRAdditionalParty.class
})
public class GWRParty {

    @XmlElementRef(name = "Customer", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<String> customer;
    @XmlElement(name = "NameAddress")
    protected String nameAddress;
    @XmlElementRef(name = "SwiftAddress", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<String> swiftAddress;
    @XmlElement(name = "Reference")
    protected String reference;
    @XmlElement(name = "Contact")
    protected String contact;
    @XmlElement(name = "ZipCode")
    protected String zipCode;
    @XmlElementRef(name = "Telephone", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<String> telephone;
    @XmlElement(name = "FaxNumber")
    protected String faxNumber;
    @XmlElement(name = "TelexNumber")
    protected String telexNumber;
    @XmlElementRef(name = "Country", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<String> country;
    @XmlElement(name = "TelexAnswerBack")
    protected String telexAnswerBack;
    @XmlElement(name = "Email")
    protected String email;

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setCustomer(JAXBElement<String> value) {
        this.customer = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the nameAddress property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameAddress() {
        return nameAddress;
    }

    /**
     * Sets the value of the nameAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameAddress(String value) {
        this.nameAddress = value;
    }

    /**
     * Gets the value of the swiftAddress property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSwiftAddress() {
        return swiftAddress;
    }

    /**
     * Sets the value of the swiftAddress property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSwiftAddress(JAXBElement<String> value) {
        this.swiftAddress = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the reference property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReference() {
        return reference;
    }

    /**
     * Sets the value of the reference property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReference(String value) {
        this.reference = value;
    }

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContact(String value) {
        this.contact = value;
    }

    /**
     * Gets the value of the zipCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * Sets the value of the zipCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setZipCode(String value) {
        this.zipCode = value;
    }

    /**
     * Gets the value of the telephone property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getTelephone() {
        return telephone;
    }

    /**
     * Sets the value of the telephone property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setTelephone(JAXBElement<String> value) {
        this.telephone = ((JAXBElement<String> ) value);
    }

    /**
     * Gets the value of the faxNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFaxNumber() {
        return faxNumber;
    }

    /**
     * Sets the value of the faxNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFaxNumber(String value) {
        this.faxNumber = value;
    }

    /**
     * Gets the value of the telexNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTelexNumber() {
        return telexNumber;
    }

    /**
     * Sets the value of the telexNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTelexNumber(String value) {
        this.telexNumber = value;
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

}
