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
import com.misys.tiplus2.apps.ti.service.common.GWRSwiftTag5X;


/**
 * .
 * 
 * <p>Java class for STRClearingSystemCode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="STRClearingSystemCode">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GatewayStatic">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRClearingSystemCodeKey" minOccurs="0"/>
 *         &lt;element name="Description" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRClearingSystemCodeDescription" minOccurs="0"/>
 *         &lt;element name="MinimumLength" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRInteger" minOccurs="0"/>
 *         &lt;element name="MaximumLength" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRInteger" minOccurs="0"/>
 *         &lt;element name="Country" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRCountry" minOccurs="0"/>
 *         &lt;element name="Tag52" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSwiftTag5X" minOccurs="0"/>
 *         &lt;element name="Tag56" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSwiftTag5X" minOccurs="0"/>
 *         &lt;element name="Tag57" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSwiftTag5X" minOccurs="0"/>
 *         &lt;element name="Tag58" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSwiftTag5X" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STRClearingSystemCode", propOrder = {
    "code",
    "description",
    "minimumLength",
    "maximumLength",
    "country",
    "tag52",
    "tag56",
    "tag57",
    "tag58"
})
public class STRClearingSystemCode
    extends GatewayStatic
{

    @XmlElement(name = "Code")
    protected String code;
    @XmlElement(name = "Description")
    protected String description;
    @XmlElementRef(name = "MinimumLength", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<Integer> minimumLength;
    @XmlElementRef(name = "MaximumLength", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<Integer> maximumLength;
    @XmlElementRef(name = "Country", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<String> country;
    @XmlElement(name = "Tag52")
    protected GWRSwiftTag5X tag52;
    @XmlElement(name = "Tag56")
    protected GWRSwiftTag5X tag56;
    @XmlElement(name = "Tag57")
    protected GWRSwiftTag5X tag57;
    @XmlElement(name = "Tag58")
    protected GWRSwiftTag5X tag58;

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

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the minimumLength property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getMinimumLength() {
        return minimumLength;
    }

    /**
     * Sets the value of the minimumLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setMinimumLength(JAXBElement<Integer> value) {
        this.minimumLength = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the maximumLength property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getMaximumLength() {
        return maximumLength;
    }

    /**
     * Sets the value of the maximumLength property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setMaximumLength(JAXBElement<Integer> value) {
        this.maximumLength = ((JAXBElement<Integer> ) value);
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
     * Gets the value of the tag52 property.
     * 
     * @return
     *     possible object is
     *     {@link GWRSwiftTag5X }
     *     
     */
    public GWRSwiftTag5X getTag52() {
        return tag52;
    }

    /**
     * Sets the value of the tag52 property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRSwiftTag5X }
     *     
     */
    public void setTag52(GWRSwiftTag5X value) {
        this.tag52 = value;
    }

    /**
     * Gets the value of the tag56 property.
     * 
     * @return
     *     possible object is
     *     {@link GWRSwiftTag5X }
     *     
     */
    public GWRSwiftTag5X getTag56() {
        return tag56;
    }

    /**
     * Sets the value of the tag56 property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRSwiftTag5X }
     *     
     */
    public void setTag56(GWRSwiftTag5X value) {
        this.tag56 = value;
    }

    /**
     * Gets the value of the tag57 property.
     * 
     * @return
     *     possible object is
     *     {@link GWRSwiftTag5X }
     *     
     */
    public GWRSwiftTag5X getTag57() {
        return tag57;
    }

    /**
     * Sets the value of the tag57 property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRSwiftTag5X }
     *     
     */
    public void setTag57(GWRSwiftTag5X value) {
        this.tag57 = value;
    }

    /**
     * Gets the value of the tag58 property.
     * 
     * @return
     *     possible object is
     *     {@link GWRSwiftTag5X }
     *     
     */
    public GWRSwiftTag5X getTag58() {
        return tag58;
    }

    /**
     * Sets the value of the tag58 property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRSwiftTag5X }
     *     
     */
    public void setTag58(GWRSwiftTag5X value) {
        this.tag58 = value;
    }

}