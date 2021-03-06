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
 * AccountBranchChange.
 * 
 * <p>Java class for STRAccountBranchChange complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="STRAccountBranchChange">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}STRAccountAndDealBranchChange">
 *       &lt;sequence>
 *         &lt;element name="OldBranchMnemonic" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBranch" minOccurs="0"/>
 *         &lt;element name="OldBackOfficeAccNumber" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRAccountNumber" minOccurs="0"/>
 *         &lt;element name="NewBranchMnemonic" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBranch" minOccurs="0"/>
 *         &lt;element name="NewBackOfficeAccNumber" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRAccountNumber" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STRAccountBranchChange", propOrder = {
    "oldBranchMnemonic",
    "oldBackOfficeAccNumber",
    "newBranchMnemonic",
    "newBackOfficeAccNumber"
})
public class STRAccountBranchChange
    extends STRAccountAndDealBranchChange
{

    @XmlElement(name = "OldBranchMnemonic")
    protected String oldBranchMnemonic;
    @XmlElement(name = "OldBackOfficeAccNumber")
    protected String oldBackOfficeAccNumber;
    @XmlElement(name = "NewBranchMnemonic")
    protected String newBranchMnemonic;
    @XmlElement(name = "NewBackOfficeAccNumber")
    protected String newBackOfficeAccNumber;

    /**
     * Gets the value of the oldBranchMnemonic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldBranchMnemonic() {
        return oldBranchMnemonic;
    }

    /**
     * Sets the value of the oldBranchMnemonic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldBranchMnemonic(String value) {
        this.oldBranchMnemonic = value;
    }

    /**
     * Gets the value of the oldBackOfficeAccNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOldBackOfficeAccNumber() {
        return oldBackOfficeAccNumber;
    }

    /**
     * Sets the value of the oldBackOfficeAccNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOldBackOfficeAccNumber(String value) {
        this.oldBackOfficeAccNumber = value;
    }

    /**
     * Gets the value of the newBranchMnemonic property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewBranchMnemonic() {
        return newBranchMnemonic;
    }

    /**
     * Sets the value of the newBranchMnemonic property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewBranchMnemonic(String value) {
        this.newBranchMnemonic = value;
    }

    /**
     * Gets the value of the newBackOfficeAccNumber property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNewBackOfficeAccNumber() {
        return newBackOfficeAccNumber;
    }

    /**
     * Sets the value of the newBackOfficeAccNumber property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNewBackOfficeAccNumber(String value) {
        this.newBackOfficeAccNumber = value;
    }

}
