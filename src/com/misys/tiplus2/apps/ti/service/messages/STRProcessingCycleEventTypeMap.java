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
import com.misys.tiplus2.apps.ti.service.common.GWRSchedule;
import com.misys.tiplus2.apps.ti.service.common.GWRTracerType;


/**
 * .
 * 
 * <p>Java class for STRProcessingCycleEventTypeMap complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="STRProcessingCycleEventTypeMap">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GatewaySystemTailoring">
 *       &lt;sequence>
 *         &lt;element name="ProcessingCycle" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRProcessingCycle" minOccurs="0"/>
 *         &lt;element name="EventType" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWREventType" minOccurs="0"/>
 *         &lt;element name="TracerType" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRTracerType" minOccurs="0"/>
 *         &lt;element name="Schedule" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSchedule" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STRProcessingCycleEventTypeMap", propOrder = {
    "processingCycle",
    "eventType",
    "tracerType",
    "schedule"
})
public class STRProcessingCycleEventTypeMap
    extends GatewaySystemTailoring
{

    @XmlElement(name = "ProcessingCycle")
    protected String processingCycle;
    @XmlElement(name = "EventType")
    protected String eventType;
    @XmlElement(name = "TracerType")
    protected GWRTracerType tracerType;
    @XmlElement(name = "Schedule")
    protected GWRSchedule schedule;

    /**
     * Gets the value of the processingCycle property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessingCycle() {
        return processingCycle;
    }

    /**
     * Sets the value of the processingCycle property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessingCycle(String value) {
        this.processingCycle = value;
    }

    /**
     * Gets the value of the eventType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEventType() {
        return eventType;
    }

    /**
     * Sets the value of the eventType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEventType(String value) {
        this.eventType = value;
    }

    /**
     * Gets the value of the tracerType property.
     * 
     * @return
     *     possible object is
     *     {@link GWRTracerType }
     *     
     */
    public GWRTracerType getTracerType() {
        return tracerType;
    }

    /**
     * Sets the value of the tracerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRTracerType }
     *     
     */
    public void setTracerType(GWRTracerType value) {
        this.tracerType = value;
    }

    /**
     * Gets the value of the schedule property.
     * 
     * @return
     *     possible object is
     *     {@link GWRSchedule }
     *     
     */
    public GWRSchedule getSchedule() {
        return schedule;
    }

    /**
     * Sets the value of the schedule property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRSchedule }
     *     
     */
    public void setSchedule(GWRSchedule value) {
        this.schedule = value;
    }

}
