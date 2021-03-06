//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.22 at 03:37:05 PM IST 
//


package com.misys.tiplus2.apps.ti.service.messages;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;
import com.misys.tiplus2.apps.ti.service.common.GatewayContext;


/**
 * The base pane of all the event-related Gateway panes. Annotated as a subpane as it is used in the GatewayRepairMessage API call. gateway annotation ResponseStatus process() DoMessageProcess() MessageSuccessful.
 * 
 * <p>Java class for GatewayBasePane complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GatewayBasePane">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Context" type="{urn:common.service.ti.apps.tiplus2.misys.com}GatewayContext" minOccurs="0"/>
 *         &lt;element name="DocumentsReceiveds" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DocumentsReceived" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="DocID" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="128"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="DMSID" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="35"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="DocType" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="3"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Description" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="35"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="ReceivedDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
 *                             &lt;element name="ReceivedTime" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="8"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GatewayBasePane", propOrder = {
    "context",
    "documentsReceiveds"
})
@XmlSeeAlso({
    ReprocessableGatewayPane.class
})
public class GatewayBasePane {

    @XmlElement(name = "Context")
    protected GatewayContext context;
    @XmlElement(name = "DocumentsReceiveds")
    protected GatewayBasePane.DocumentsReceiveds documentsReceiveds;

    /**
     * Gets the value of the context property.
     * 
     * @return
     *     possible object is
     *     {@link GatewayContext }
     *     
     */
    public GatewayContext getContext() {
        return context;
    }

    /**
     * Sets the value of the context property.
     * 
     * @param value
     *     allowed object is
     *     {@link GatewayContext }
     *     
     */
    public void setContext(GatewayContext value) {
        this.context = value;
    }

    /**
     * Gets the value of the documentsReceiveds property.
     * 
     * @return
     *     possible object is
     *     {@link GatewayBasePane.DocumentsReceiveds }
     *     
     */
    public GatewayBasePane.DocumentsReceiveds getDocumentsReceiveds() {
        return documentsReceiveds;
    }

    /**
     * Sets the value of the documentsReceiveds property.
     * 
     * @param value
     *     allowed object is
     *     {@link GatewayBasePane.DocumentsReceiveds }
     *     
     */
    public void setDocumentsReceiveds(GatewayBasePane.DocumentsReceiveds value) {
        this.documentsReceiveds = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="DocumentsReceived" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="DocID" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="128"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="DMSID" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="35"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="DocType" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="3"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Description" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="35"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="ReceivedDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
     *                   &lt;element name="ReceivedTime" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="8"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "documentsReceived"
    })
    public static class DocumentsReceiveds {

        @XmlElement(name = "DocumentsReceived", required = true)
        protected List<GatewayBasePane.DocumentsReceiveds.DocumentsReceived> documentsReceived;

        /**
         * Gets the value of the documentsReceived property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the documentsReceived property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDocumentsReceived().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GatewayBasePane.DocumentsReceiveds.DocumentsReceived }
         * 
         * 
         */
        public List<GatewayBasePane.DocumentsReceiveds.DocumentsReceived> getDocumentsReceived() {
            if (documentsReceived == null) {
                documentsReceived = new ArrayList<GatewayBasePane.DocumentsReceiveds.DocumentsReceived>();
            }
            return this.documentsReceived;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="DocID" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="128"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="DMSID" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="35"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="DocType" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="3"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Description" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="35"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="ReceivedDate" type="{http://www.w3.org/2001/XMLSchema}date" minOccurs="0"/>
         *         &lt;element name="ReceivedTime" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="8"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "docID",
            "dmsid",
            "docType",
            "description",
            "receivedDate",
            "receivedTime"
        })
        public static class DocumentsReceived {

            @XmlElement(name = "DocID")
            protected String docID;
            @XmlElement(name = "DMSID")
            protected String dmsid;
            @XmlElement(name = "DocType")
            protected String docType;
            @XmlElement(name = "Description")
            protected String description;
            @XmlElementRef(name = "ReceivedDate", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
            protected JAXBElement<XMLGregorianCalendar> receivedDate;
            @XmlElement(name = "ReceivedTime")
            protected String receivedTime;

            /**
             * Gets the value of the docID property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDocID() {
                return docID;
            }

            /**
             * Sets the value of the docID property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDocID(String value) {
                this.docID = value;
            }

            /**
             * Gets the value of the dmsid property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDMSID() {
                return dmsid;
            }

            /**
             * Sets the value of the dmsid property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDMSID(String value) {
                this.dmsid = value;
            }

            /**
             * Gets the value of the docType property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getDocType() {
                return docType;
            }

            /**
             * Sets the value of the docType property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setDocType(String value) {
                this.docType = value;
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
             * Gets the value of the receivedDate property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
             *     
             */
            public JAXBElement<XMLGregorianCalendar> getReceivedDate() {
                return receivedDate;
            }

            /**
             * Sets the value of the receivedDate property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
             *     
             */
            public void setReceivedDate(JAXBElement<XMLGregorianCalendar> value) {
                this.receivedDate = ((JAXBElement<XMLGregorianCalendar> ) value);
            }

            /**
             * Gets the value of the receivedTime property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getReceivedTime() {
                return receivedTime;
            }

            /**
             * Sets the value of the receivedTime property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setReceivedTime(String value) {
                this.receivedTime = value;
            }

        }

    }

}
