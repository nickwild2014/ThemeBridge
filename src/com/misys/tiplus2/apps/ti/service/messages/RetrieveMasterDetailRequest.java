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
import com.misys.tiplus2.apps.ti.service.common.GWRMasterReferenceDetails;


/**
 * .
 * 
 * <p>Java class for RetrieveMasterDetailRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="RetrieveMasterDetailRequest">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}IncomingEnquiryRequest">
 *       &lt;sequence>
 *         &lt;element name="MasterReference" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRMasterReferenceDetails" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RetrieveMasterDetailRequest", propOrder = {
    "masterReference"
})
public class RetrieveMasterDetailRequest
    extends IncomingEnquiryRequest
{

    @XmlElement(name = "MasterReference")
    protected GWRMasterReferenceDetails masterReference;

    /**
     * Gets the value of the masterReference property.
     * 
     * @return
     *     possible object is
     *     {@link GWRMasterReferenceDetails }
     *     
     */
    public GWRMasterReferenceDetails getMasterReference() {
        return masterReference;
    }

    /**
     * Sets the value of the masterReference property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRMasterReferenceDetails }
     *     
     */
    public void setMasterReference(GWRMasterReferenceDetails value) {
        this.masterReference = value;
    }

}
