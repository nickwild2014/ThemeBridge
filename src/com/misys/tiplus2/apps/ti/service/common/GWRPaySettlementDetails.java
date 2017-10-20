//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.22 at 03:37:05 PM IST 
//


package com.misys.tiplus2.apps.ti.service.common;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GWRPaySettlementDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GWRPaySettlementDetails">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSettlementBaseDetails">
 *       &lt;sequence>
 *         &lt;element name="PaySettlesVia" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRPaySettlesVia" minOccurs="0"/>
 *         &lt;element name="PaySettlesBy" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRPaySettlesBy" minOccurs="0"/>
 *         &lt;element name="AccountWith" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSIParty" minOccurs="0"/>
 *         &lt;element name="TimeDetails" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRTimeIndications" minOccurs="0"/>
 *         &lt;element name="PaymentDetails" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRText4x35" minOccurs="0"/>
 *         &lt;element name="SenderToReceiverInfo" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRText6x35" minOccurs="0"/>
 *         &lt;element name="SWIFTChargeFor" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSWIFTChargeCode" minOccurs="0"/>
 *         &lt;element name="MessageType" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRMessageTypeMT103" minOccurs="0"/>
 *         &lt;element name="ServiceLevel" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRMT103ServiceLevel" minOccurs="0"/>
 *         &lt;element name="RegulatoryReporting" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRText6x35" minOccurs="0"/>
 *         &lt;element name="TransactionType" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRTransactionType" minOccurs="0"/>
 *         &lt;element name="Chargess" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Charges" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Currency" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;minLength value="1"/>
 *                                   &lt;maxLength value="3"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Amount" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
 *                                   &lt;fractionDigits value="0"/>
 *                                   &lt;totalDigits value="15"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="Instructionss" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Instructions" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="Code" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRPaySettlementDetails_MT103Instructions_Code" minOccurs="0"/>
 *                             &lt;element name="Text" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="30"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="CoverPaymentTransferMethod" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRTransferMethod" minOccurs="0"/>
 *         &lt;element name="PayingBank" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSIParty" minOccurs="0"/>
 *         &lt;element name="ReceiversCorrespondent" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSIParty" minOccurs="0"/>
 *         &lt;element name="IntermediaryReimbursingBank" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSIParty" minOccurs="0"/>
 *         &lt;element name="CoverSenderToReceiverInfo" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRText6x35" minOccurs="0"/>
 *         &lt;element name="CoverTimeDetails" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRTimeIndications" minOccurs="0"/>
 *         &lt;element name="BeneficiaryAccountNumber" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRAccountNumber" minOccurs="0"/>
 *         &lt;element name="VostroAccount" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRServiceAccount" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GWRPaySettlementDetails", propOrder = {
    "paySettlesVia",
    "paySettlesBy",
    "accountWith",
    "timeDetails",
    "paymentDetails",
    "senderToReceiverInfo",
    "swiftChargeFor",
    "messageType",
    "serviceLevel",
    "regulatoryReporting",
    "transactionType",
    "chargess",
    "instructionss",
    "coverPaymentTransferMethod",
    "payingBank",
    "receiversCorrespondent",
    "intermediaryReimbursingBank",
    "coverSenderToReceiverInfo",
    "coverTimeDetails",
    "beneficiaryAccountNumber",
    "vostroAccount"
})
public class GWRPaySettlementDetails
    extends GWRSettlementBaseDetails
{

    @XmlElement(name = "PaySettlesVia")
    protected GWRPaySettlesVia paySettlesVia;
    @XmlElement(name = "PaySettlesBy")
    protected GWRPaySettlesBy paySettlesBy;
    @XmlElement(name = "AccountWith")
    protected GWRSIParty accountWith;
    @XmlElement(name = "TimeDetails")
    protected GWRTimeIndications timeDetails;
    @XmlElement(name = "PaymentDetails")
    protected String paymentDetails;
    @XmlElement(name = "SenderToReceiverInfo")
    protected String senderToReceiverInfo;
    @XmlElementRef(name = "SWIFTChargeFor", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<GWRSWIFTChargeCode> swiftChargeFor;
    @XmlElement(name = "MessageType")
    protected String messageType;
    @XmlElement(name = "ServiceLevel")
    protected GWRMT103ServiceLevel serviceLevel;
    @XmlElement(name = "RegulatoryReporting")
    protected String regulatoryReporting;
    @XmlElement(name = "TransactionType")
    protected String transactionType;
    @XmlElement(name = "Chargess")
    protected GWRPaySettlementDetails.Chargess chargess;
    @XmlElement(name = "Instructionss")
    protected GWRPaySettlementDetails.Instructionss instructionss;
    @XmlElement(name = "CoverPaymentTransferMethod")
    protected String coverPaymentTransferMethod;
    @XmlElement(name = "PayingBank")
    protected GWRSIParty payingBank;
    @XmlElement(name = "ReceiversCorrespondent")
    protected GWRSIParty receiversCorrespondent;
    @XmlElement(name = "IntermediaryReimbursingBank")
    protected GWRSIParty intermediaryReimbursingBank;
    @XmlElement(name = "CoverSenderToReceiverInfo")
    protected String coverSenderToReceiverInfo;
    @XmlElement(name = "CoverTimeDetails")
    protected GWRTimeIndications coverTimeDetails;
    @XmlElement(name = "BeneficiaryAccountNumber")
    protected String beneficiaryAccountNumber;
    @XmlElement(name = "VostroAccount")
    protected String vostroAccount;

    /**
     * Gets the value of the paySettlesVia property.
     * 
     * @return
     *     possible object is
     *     {@link GWRPaySettlesVia }
     *     
     */
    public GWRPaySettlesVia getPaySettlesVia() {
        return paySettlesVia;
    }

    /**
     * Sets the value of the paySettlesVia property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRPaySettlesVia }
     *     
     */
    public void setPaySettlesVia(GWRPaySettlesVia value) {
        this.paySettlesVia = value;
    }

    /**
     * Gets the value of the paySettlesBy property.
     * 
     * @return
     *     possible object is
     *     {@link GWRPaySettlesBy }
     *     
     */
    public GWRPaySettlesBy getPaySettlesBy() {
        return paySettlesBy;
    }

    /**
     * Sets the value of the paySettlesBy property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRPaySettlesBy }
     *     
     */
    public void setPaySettlesBy(GWRPaySettlesBy value) {
        this.paySettlesBy = value;
    }

    /**
     * Gets the value of the accountWith property.
     * 
     * @return
     *     possible object is
     *     {@link GWRSIParty }
     *     
     */
    public GWRSIParty getAccountWith() {
        return accountWith;
    }

    /**
     * Sets the value of the accountWith property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRSIParty }
     *     
     */
    public void setAccountWith(GWRSIParty value) {
        this.accountWith = value;
    }

    /**
     * Gets the value of the timeDetails property.
     * 
     * @return
     *     possible object is
     *     {@link GWRTimeIndications }
     *     
     */
    public GWRTimeIndications getTimeDetails() {
        return timeDetails;
    }

    /**
     * Sets the value of the timeDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRTimeIndications }
     *     
     */
    public void setTimeDetails(GWRTimeIndications value) {
        this.timeDetails = value;
    }

    /**
     * Gets the value of the paymentDetails property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentDetails() {
        return paymentDetails;
    }

    /**
     * Sets the value of the paymentDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentDetails(String value) {
        this.paymentDetails = value;
    }

    /**
     * Gets the value of the senderToReceiverInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSenderToReceiverInfo() {
        return senderToReceiverInfo;
    }

    /**
     * Sets the value of the senderToReceiverInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSenderToReceiverInfo(String value) {
        this.senderToReceiverInfo = value;
    }

    /**
     * Gets the value of the swiftChargeFor property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GWRSWIFTChargeCode }{@code >}
     *     
     */
    public JAXBElement<GWRSWIFTChargeCode> getSWIFTChargeFor() {
        return swiftChargeFor;
    }

    /**
     * Sets the value of the swiftChargeFor property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GWRSWIFTChargeCode }{@code >}
     *     
     */
    public void setSWIFTChargeFor(JAXBElement<GWRSWIFTChargeCode> value) {
        this.swiftChargeFor = ((JAXBElement<GWRSWIFTChargeCode> ) value);
    }

    /**
     * Gets the value of the messageType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMessageType() {
        return messageType;
    }

    /**
     * Sets the value of the messageType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMessageType(String value) {
        this.messageType = value;
    }

    /**
     * Gets the value of the serviceLevel property.
     * 
     * @return
     *     possible object is
     *     {@link GWRMT103ServiceLevel }
     *     
     */
    public GWRMT103ServiceLevel getServiceLevel() {
        return serviceLevel;
    }

    /**
     * Sets the value of the serviceLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRMT103ServiceLevel }
     *     
     */
    public void setServiceLevel(GWRMT103ServiceLevel value) {
        this.serviceLevel = value;
    }

    /**
     * Gets the value of the regulatoryReporting property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRegulatoryReporting() {
        return regulatoryReporting;
    }

    /**
     * Sets the value of the regulatoryReporting property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRegulatoryReporting(String value) {
        this.regulatoryReporting = value;
    }

    /**
     * Gets the value of the transactionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionType() {
        return transactionType;
    }

    /**
     * Sets the value of the transactionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionType(String value) {
        this.transactionType = value;
    }

    /**
     * Gets the value of the chargess property.
     * 
     * @return
     *     possible object is
     *     {@link GWRPaySettlementDetails.Chargess }
     *     
     */
    public GWRPaySettlementDetails.Chargess getChargess() {
        return chargess;
    }

    /**
     * Sets the value of the chargess property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRPaySettlementDetails.Chargess }
     *     
     */
    public void setChargess(GWRPaySettlementDetails.Chargess value) {
        this.chargess = value;
    }

    /**
     * Gets the value of the instructionss property.
     * 
     * @return
     *     possible object is
     *     {@link GWRPaySettlementDetails.Instructionss }
     *     
     */
    public GWRPaySettlementDetails.Instructionss getInstructionss() {
        return instructionss;
    }

    /**
     * Sets the value of the instructionss property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRPaySettlementDetails.Instructionss }
     *     
     */
    public void setInstructionss(GWRPaySettlementDetails.Instructionss value) {
        this.instructionss = value;
    }

    /**
     * Gets the value of the coverPaymentTransferMethod property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverPaymentTransferMethod() {
        return coverPaymentTransferMethod;
    }

    /**
     * Sets the value of the coverPaymentTransferMethod property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverPaymentTransferMethod(String value) {
        this.coverPaymentTransferMethod = value;
    }

    /**
     * Gets the value of the payingBank property.
     * 
     * @return
     *     possible object is
     *     {@link GWRSIParty }
     *     
     */
    public GWRSIParty getPayingBank() {
        return payingBank;
    }

    /**
     * Sets the value of the payingBank property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRSIParty }
     *     
     */
    public void setPayingBank(GWRSIParty value) {
        this.payingBank = value;
    }

    /**
     * Gets the value of the receiversCorrespondent property.
     * 
     * @return
     *     possible object is
     *     {@link GWRSIParty }
     *     
     */
    public GWRSIParty getReceiversCorrespondent() {
        return receiversCorrespondent;
    }

    /**
     * Sets the value of the receiversCorrespondent property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRSIParty }
     *     
     */
    public void setReceiversCorrespondent(GWRSIParty value) {
        this.receiversCorrespondent = value;
    }

    /**
     * Gets the value of the intermediaryReimbursingBank property.
     * 
     * @return
     *     possible object is
     *     {@link GWRSIParty }
     *     
     */
    public GWRSIParty getIntermediaryReimbursingBank() {
        return intermediaryReimbursingBank;
    }

    /**
     * Sets the value of the intermediaryReimbursingBank property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRSIParty }
     *     
     */
    public void setIntermediaryReimbursingBank(GWRSIParty value) {
        this.intermediaryReimbursingBank = value;
    }

    /**
     * Gets the value of the coverSenderToReceiverInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCoverSenderToReceiverInfo() {
        return coverSenderToReceiverInfo;
    }

    /**
     * Sets the value of the coverSenderToReceiverInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCoverSenderToReceiverInfo(String value) {
        this.coverSenderToReceiverInfo = value;
    }

    /**
     * Gets the value of the coverTimeDetails property.
     * 
     * @return
     *     possible object is
     *     {@link GWRTimeIndications }
     *     
     */
    public GWRTimeIndications getCoverTimeDetails() {
        return coverTimeDetails;
    }

    /**
     * Sets the value of the coverTimeDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRTimeIndications }
     *     
     */
    public void setCoverTimeDetails(GWRTimeIndications value) {
        this.coverTimeDetails = value;
    }

    /**
     * Gets the value of the beneficiaryAccountNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeneficiaryAccountNumber() {
        return beneficiaryAccountNumber;
    }

    /**
     * Sets the value of the beneficiaryAccountNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeneficiaryAccountNumber(String value) {
        this.beneficiaryAccountNumber = value;
    }

    /**
     * Gets the value of the vostroAccount property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVostroAccount() {
        return vostroAccount;
    }

    /**
     * Sets the value of the vostroAccount property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVostroAccount(String value) {
        this.vostroAccount = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Charges" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Currency" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="3"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Amount" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
     *                         &lt;fractionDigits value="0"/>
     *                         &lt;totalDigits value="15"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "charges"
    })
    public static class Chargess {

        @XmlElement(name = "Charges", required = true)
        protected List<GWRPaySettlementDetails.Chargess.Charges> charges;

        /**
         * Gets the value of the charges property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the charges property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getCharges().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GWRPaySettlementDetails.Chargess.Charges }
         * 
         * 
         */
        public List<GWRPaySettlementDetails.Chargess.Charges> getCharges() {
            if (charges == null) {
                charges = new ArrayList<GWRPaySettlementDetails.Chargess.Charges>();
            }
            return this.charges;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Currency" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="3"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Amount" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}long">
         *               &lt;fractionDigits value="0"/>
         *               &lt;totalDigits value="15"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "currency",
            "amount"
        })
        public static class Charges {

            @XmlElementRef(name = "Currency", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
            protected JAXBElement<String> currency;
            @XmlElementRef(name = "Amount", namespace = "urn:common.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
            protected JAXBElement<Long> amount;

            /**
             * Gets the value of the currency property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getCurrency() {
                return currency;
            }

            /**
             * Sets the value of the currency property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setCurrency(JAXBElement<String> value) {
                this.currency = ((JAXBElement<String> ) value);
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

        }

    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="Instructions" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="Code" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRPaySettlementDetails_MT103Instructions_Code" minOccurs="0"/>
     *                   &lt;element name="Text" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="30"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "instructions"
    })
    public static class Instructionss {

        @XmlElement(name = "Instructions", required = true)
        protected List<GWRPaySettlementDetails.Instructionss.Instructions> instructions;

        /**
         * Gets the value of the instructions property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the instructions property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getInstructions().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GWRPaySettlementDetails.Instructionss.Instructions }
         * 
         * 
         */
        public List<GWRPaySettlementDetails.Instructionss.Instructions> getInstructions() {
            if (instructions == null) {
                instructions = new ArrayList<GWRPaySettlementDetails.Instructionss.Instructions>();
            }
            return this.instructions;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="Code" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRPaySettlementDetails_MT103Instructions_Code" minOccurs="0"/>
         *         &lt;element name="Text" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="30"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "code",
            "text"
        })
        public static class Instructions {

            @XmlElement(name = "Code")
            protected GWRPaySettlementDetailsMT103InstructionsCode code;
            @XmlElement(name = "Text")
            protected String text;

            /**
             * Gets the value of the code property.
             * 
             * @return
             *     possible object is
             *     {@link GWRPaySettlementDetailsMT103InstructionsCode }
             *     
             */
            public GWRPaySettlementDetailsMT103InstructionsCode getCode() {
                return code;
            }

            /**
             * Sets the value of the code property.
             * 
             * @param value
             *     allowed object is
             *     {@link GWRPaySettlementDetailsMT103InstructionsCode }
             *     
             */
            public void setCode(GWRPaySettlementDetailsMT103InstructionsCode value) {
                this.code = value;
            }

            /**
             * Gets the value of the text property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getText() {
                return text;
            }

            /**
             * Sets the value of the text property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setText(String value) {
                this.text = value;
            }

        }

    }

}
