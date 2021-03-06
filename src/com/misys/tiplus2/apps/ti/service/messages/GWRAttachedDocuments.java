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


/**
 * GetProductType() and removed, removed ValidatePreallocatedNumber().
 * 
 * <p>Java class for GWRAttachedDocuments complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GWRAttachedDocuments">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GatewayEventR">
 *       &lt;sequence>
 *         &lt;element name="PreallocatedNo" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRPreallocatedReferenceNumber" minOccurs="0"/>
 *         &lt;element name="MasterTeam" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRTeam" minOccurs="0"/>
 *         &lt;element name="EventFurtherID" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWREventFurtherID" minOccurs="0"/>
 *         &lt;element name="ExtraInformation" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRExtraInformation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GWRAttachedDocuments", propOrder = {
    "preallocatedNo",
    "masterTeam",
    "eventFurtherID",
    "extraInformation"
})
@XmlSeeAlso({
    TFATTDOC.class
})
public class GWRAttachedDocuments
    extends GatewayEventR
{

    @XmlElementRef(name = "PreallocatedNo", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<Integer> preallocatedNo;
    @XmlElement(name = "MasterTeam")
    protected String masterTeam;
    @XmlElement(name = "EventFurtherID")
    protected String eventFurtherID;
    @XmlElement(name = "ExtraInformation")
    protected String extraInformation;

    /**
     * Gets the value of the preallocatedNo property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getPreallocatedNo() {
        return preallocatedNo;
    }

    /**
     * Sets the value of the preallocatedNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setPreallocatedNo(JAXBElement<Integer> value) {
        this.preallocatedNo = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the masterTeam property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMasterTeam() {
        return masterTeam;
    }

    /**
     * Sets the value of the masterTeam property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMasterTeam(String value) {
        this.masterTeam = value;
    }

    /**
     * Gets the value of the eventFurtherID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventFurtherID() {
        return eventFurtherID;
    }

    /**
     * Sets the value of the eventFurtherID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventFurtherID(String value) {
        this.eventFurtherID = value;
    }

    /**
     * Gets the value of the extraInformation property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExtraInformation() {
        return extraInformation;
    }

    /**
     * Sets the value of the extraInformation property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExtraInformation(String value) {
        this.extraInformation = value;
    }

}
