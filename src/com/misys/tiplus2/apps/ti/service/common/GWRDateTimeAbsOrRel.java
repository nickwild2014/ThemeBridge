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
 * <p>Java class for GWRDateTimeAbsOrRel complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GWRDateTimeAbsOrRel">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="DateTimeStamp" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRDateTimeStampRelativeDays" minOccurs="0"/>
 *         &lt;element name="RelativeTime" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRRelativeTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GWRDateTimeAbsOrRel", propOrder = {
    "dateTimeStamp",
    "relativeTime"
})
public class GWRDateTimeAbsOrRel {

    @XmlElement(name = "DateTimeStamp")
    protected GWRDateTimeStampRelativeDays dateTimeStamp;
    @XmlElement(name = "RelativeTime")
    protected String relativeTime;

    /**
     * Gets the value of the dateTimeStamp property.
     * 
     * @return
     *     possible object is
     *     {@link GWRDateTimeStampRelativeDays }
     *     
     */
    public GWRDateTimeStampRelativeDays getDateTimeStamp() {
        return dateTimeStamp;
    }

    /**
     * Sets the value of the dateTimeStamp property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRDateTimeStampRelativeDays }
     *     
     */
    public void setDateTimeStamp(GWRDateTimeStampRelativeDays value) {
        this.dateTimeStamp = value;
    }

    /**
     * Gets the value of the relativeTime property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getRelativeTime() {
        return relativeTime;
    }

    /**
     * Sets the value of the relativeTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setRelativeTime(String value) {
        this.relativeTime = value;
    }

}
