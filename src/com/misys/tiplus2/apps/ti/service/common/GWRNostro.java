//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.22 at 03:37:05 PM IST 
//


package com.misys.tiplus2.apps.ti.service.common;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Nostro.
 * 
 * <p>Java class for GWRNostro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GWRNostro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="MainBankingEntity" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRMainBankingEntity" minOccurs="0"/>
 *         &lt;element name="Code" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRNostroCode" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GWRNostro", propOrder = {
    "mainBankingEntity",
    "code"
})
public class GWRNostro {

    @XmlElement(name = "MainBankingEntity")
    protected String mainBankingEntity;
    @XmlElement(name = "Code")
    protected String code;

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
     * Gets the value of the code property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets the value of the code property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCode(String value) {
        this.code = value;
    }

}
