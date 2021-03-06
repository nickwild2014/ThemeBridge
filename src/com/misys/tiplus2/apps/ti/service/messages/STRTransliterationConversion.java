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
 * <p>Java class for STRTransliterationConversion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="STRTransliterationConversion">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GatewayStatic">
 *       &lt;sequence>
 *         &lt;element name="Latin" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRCharacter" minOccurs="0"/>
 *         &lt;element name="RussianUpper" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRCharacter" minOccurs="0"/>
 *         &lt;element name="RussianLower" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRCharacter" minOccurs="0"/>
 *         &lt;element name="Comment" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRTransliterationComment" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STRTransliterationConversion", propOrder = {
    "latin",
    "russianUpper",
    "russianLower",
    "comment"
})
public class STRTransliterationConversion
    extends GatewayStatic
{

    @XmlElement(name = "Latin")
    protected String latin;
    @XmlElement(name = "RussianUpper")
    protected String russianUpper;
    @XmlElement(name = "RussianLower")
    protected String russianLower;
    @XmlElement(name = "Comment")
    protected String comment;

    /**
     * Gets the value of the latin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLatin() {
        return latin;
    }

    /**
     * Sets the value of the latin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLatin(String value) {
        this.latin = value;
    }

    /**
     * Gets the value of the russianUpper property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRussianUpper() {
        return russianUpper;
    }

    /**
     * Sets the value of the russianUpper property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRussianUpper(String value) {
        this.russianUpper = value;
    }

    /**
     * Gets the value of the russianLower property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRussianLower() {
        return russianLower;
    }

    /**
     * Sets the value of the russianLower property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRussianLower(String value) {
        this.russianLower = value;
    }

    /**
     * Gets the value of the comment property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the value of the comment property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setComment(String value) {
        this.comment = value;
    }

}
