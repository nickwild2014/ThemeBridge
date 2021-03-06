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
import com.misys.tiplus2.apps.ti.service.common.EnigmaBoolean;


/**
 * .
 * 
 * <p>Java class for STRTeamUserEntity complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="STRTeamUserEntity">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GatewaySecurity">
 *       &lt;sequence>
 *         &lt;element name="Team" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRTeamCode" minOccurs="0"/>
 *         &lt;element name="User" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRUserName" minOccurs="0"/>
 *         &lt;element name="BankingEntity" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBranchCode" minOccurs="0"/>
 *         &lt;element name="TransactionBranch" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBranchCode" minOccurs="0"/>
 *         &lt;element name="Locked" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBool" minOccurs="0"/>
 *         &lt;element name="EnquiryBranch" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBranchCode" minOccurs="0"/>
 *         &lt;element name="Excluded" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBool" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STRTeamUserEntity", propOrder = {
    "team",
    "user",
    "bankingEntity",
    "transactionBranch",
    "locked",
    "enquiryBranch",
    "excluded"
})
public class STRTeamUserEntity
    extends GatewaySecurity
{

    @XmlElement(name = "Team")
    protected String team;
    @XmlElement(name = "User")
    protected String user;
    @XmlElement(name = "BankingEntity")
    protected String bankingEntity;
    @XmlElement(name = "TransactionBranch")
    protected String transactionBranch;
    @XmlElement(name = "Locked")
    protected EnigmaBoolean locked;
    @XmlElement(name = "EnquiryBranch")
    protected String enquiryBranch;
    @XmlElement(name = "Excluded")
    protected EnigmaBoolean excluded;

    /**
     * Gets the value of the team property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeam() {
        return team;
    }

    /**
     * Sets the value of the team property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeam(String value) {
        this.team = value;
    }

    /**
     * Gets the value of the user property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUser() {
        return user;
    }

    /**
     * Sets the value of the user property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUser(String value) {
        this.user = value;
    }

    /**
     * Gets the value of the bankingEntity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBankingEntity() {
        return bankingEntity;
    }

    /**
     * Sets the value of the bankingEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBankingEntity(String value) {
        this.bankingEntity = value;
    }

    /**
     * Gets the value of the transactionBranch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionBranch() {
        return transactionBranch;
    }

    /**
     * Sets the value of the transactionBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionBranch(String value) {
        this.transactionBranch = value;
    }

    /**
     * Gets the value of the locked property.
     * 
     * @return
     *     possible object is
     *     {@link EnigmaBoolean }
     *     
     */
    public EnigmaBoolean getLocked() {
        return locked;
    }

    /**
     * Sets the value of the locked property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnigmaBoolean }
     *     
     */
    public void setLocked(EnigmaBoolean value) {
        this.locked = value;
    }

    /**
     * Gets the value of the enquiryBranch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnquiryBranch() {
        return enquiryBranch;
    }

    /**
     * Sets the value of the enquiryBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnquiryBranch(String value) {
        this.enquiryBranch = value;
    }

    /**
     * Gets the value of the excluded property.
     * 
     * @return
     *     possible object is
     *     {@link EnigmaBoolean }
     *     
     */
    public EnigmaBoolean getExcluded() {
        return excluded;
    }

    /**
     * Sets the value of the excluded property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnigmaBoolean }
     *     
     */
    public void setExcluded(EnigmaBoolean value) {
        this.excluded = value;
    }

}
