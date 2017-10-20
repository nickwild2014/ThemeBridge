//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.01.29 at 06:14:37 PM IST 
//


package com.misys.tiplus2.apps.ti.service.messages;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import com.misys.tiplus2.apps.ti.service.common.GWRSLAProcessingTimes;


/**
 * <p>Java class for STREventTypeProcessingTimes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="STREventTypeProcessingTimes">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GatewaySystemTailoring">
 *       &lt;sequence>
 *         &lt;element name="StepProcessingTimes" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRSLAProcessingTimes" minOccurs="0"/>
 *         &lt;element name="ParameterSet" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRParameterSet" minOccurs="0"/>
 *         &lt;element name="EventType" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWREventType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STREventTypeProcessingTimes", propOrder = {
    "stepProcessingTimes",
    "parameterSet",
    "eventType"
})
public class STREventTypeProcessingTimes
    extends GatewaySystemTailoring
{

    @XmlElement(name = "StepProcessingTimes")
    protected GWRSLAProcessingTimes stepProcessingTimes;
    @XmlElement(name = "ParameterSet")
    protected String parameterSet;
    @XmlElement(name = "EventType")
    protected String eventType;

    /**
     * Gets the value of the stepProcessingTimes property.
     * 
     * @return
     *     possible object is
     *     {@link GWRSLAProcessingTimes }
     *     
     */
    public GWRSLAProcessingTimes getStepProcessingTimes() {
        return stepProcessingTimes;
    }

    /**
     * Sets the value of the stepProcessingTimes property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRSLAProcessingTimes }
     *     
     */
    public void setStepProcessingTimes(GWRSLAProcessingTimes value) {
        this.stepProcessingTimes = value;
    }

    /**
     * Gets the value of the parameterSet property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getParameterSet() {
        return parameterSet;
    }

    /**
     * Sets the value of the parameterSet property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setParameterSet(String value) {
        this.parameterSet = value;
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

}