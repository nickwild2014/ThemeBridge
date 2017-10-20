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
import javax.xml.bind.annotation.XmlType;
import com.misys.tiplus2.apps.ti.service.common.EnigmaBoolean;
import com.misys.tiplus2.apps.ti.service.common.GWRPrinterProperties;


/**
 * .
 * 
 * <p>Java class for STRPrinterSetup complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="STRPrinterSetup">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GatewayPrinterBase">
 *       &lt;sequence>
 *         &lt;element name="PrinterType" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRPrinterType" minOccurs="0"/>
 *         &lt;element name="PrinterID" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRPrinterID" minOccurs="0"/>
 *         &lt;element name="Team" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRTeam" minOccurs="0"/>
 *         &lt;element name="NumberOfCopies" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRInteger" minOccurs="0"/>
 *         &lt;element name="PrinterProperties" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRPrinterProperties" minOccurs="0"/>
 *         &lt;element name="PrintAttributeFinals" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PrintAttributeFinal" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ID" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;minLength value="1"/>
 *                                   &lt;maxLength value="32"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Value" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="128"/>
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
 *         &lt;element name="UseDraftAttributes" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBool" minOccurs="0"/>
 *         &lt;element name="PrintAttributeDrafts" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="PrintAttributeDraft" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="ID" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;minLength value="1"/>
 *                                   &lt;maxLength value="32"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Value" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="128"/>
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
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "STRPrinterSetup", propOrder = {
    "printerType",
    "printerID",
    "team",
    "numberOfCopies",
    "printerProperties",
    "printAttributeFinals",
    "useDraftAttributes",
    "printAttributeDrafts"
})
public class STRPrinterSetup
    extends GatewayPrinterBase
{

    @XmlElement(name = "PrinterType")
    protected String printerType;
    @XmlElement(name = "PrinterID")
    protected String printerID;
    @XmlElement(name = "Team")
    protected String team;
    @XmlElementRef(name = "NumberOfCopies", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<Integer> numberOfCopies;
    @XmlElement(name = "PrinterProperties")
    protected GWRPrinterProperties printerProperties;
    @XmlElement(name = "PrintAttributeFinals")
    protected STRPrinterSetup.PrintAttributeFinals printAttributeFinals;
    @XmlElement(name = "UseDraftAttributes")
    protected EnigmaBoolean useDraftAttributes;
    @XmlElement(name = "PrintAttributeDrafts")
    protected STRPrinterSetup.PrintAttributeDrafts printAttributeDrafts;

    /**
     * Gets the value of the printerType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrinterType() {
        return printerType;
    }

    /**
     * Sets the value of the printerType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrinterType(String value) {
        this.printerType = value;
    }

    /**
     * Gets the value of the printerID property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPrinterID() {
        return printerID;
    }

    /**
     * Sets the value of the printerID property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPrinterID(String value) {
        this.printerID = value;
    }

    /**
     * Gets the value of the team property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTeam() {
        return team;
    }

    /**
     * Sets the value of the team property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTeam(String value) {
        this.team = value;
    }

    /**
     * Gets the value of the numberOfCopies property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getNumberOfCopies() {
        return numberOfCopies;
    }

    /**
     * Sets the value of the numberOfCopies property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setNumberOfCopies(JAXBElement<Integer> value) {
        this.numberOfCopies = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the printerProperties property.
     * 
     * @return
     *     possible object is
     *     {@link GWRPrinterProperties }
     *     
     */
    public GWRPrinterProperties getPrinterProperties() {
        return printerProperties;
    }

    /**
     * Sets the value of the printerProperties property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRPrinterProperties }
     *     
     */
    public void setPrinterProperties(GWRPrinterProperties value) {
        this.printerProperties = value;
    }

    /**
     * Gets the value of the printAttributeFinals property.
     * 
     * @return
     *     possible object is
     *     {@link STRPrinterSetup.PrintAttributeFinals }
     *     
     */
    public STRPrinterSetup.PrintAttributeFinals getPrintAttributeFinals() {
        return printAttributeFinals;
    }

    /**
     * Sets the value of the printAttributeFinals property.
     * 
     * @param value
     *     allowed object is
     *     {@link STRPrinterSetup.PrintAttributeFinals }
     *     
     */
    public void setPrintAttributeFinals(STRPrinterSetup.PrintAttributeFinals value) {
        this.printAttributeFinals = value;
    }

    /**
     * Gets the value of the useDraftAttributes property.
     * 
     * @return
     *     possible object is
     *     {@link EnigmaBoolean }
     *     
     */
    public EnigmaBoolean getUseDraftAttributes() {
        return useDraftAttributes;
    }

    /**
     * Sets the value of the useDraftAttributes property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnigmaBoolean }
     *     
     */
    public void setUseDraftAttributes(EnigmaBoolean value) {
        this.useDraftAttributes = value;
    }

    /**
     * Gets the value of the printAttributeDrafts property.
     * 
     * @return
     *     possible object is
     *     {@link STRPrinterSetup.PrintAttributeDrafts }
     *     
     */
    public STRPrinterSetup.PrintAttributeDrafts getPrintAttributeDrafts() {
        return printAttributeDrafts;
    }

    /**
     * Sets the value of the printAttributeDrafts property.
     * 
     * @param value
     *     allowed object is
     *     {@link STRPrinterSetup.PrintAttributeDrafts }
     *     
     */
    public void setPrintAttributeDrafts(STRPrinterSetup.PrintAttributeDrafts value) {
        this.printAttributeDrafts = value;
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
     *         &lt;element name="PrintAttributeDraft" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ID" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="32"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Value" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="128"/>
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
        "printAttributeDraft"
    })
    public static class PrintAttributeDrafts {

        @XmlElement(name = "PrintAttributeDraft", required = true)
        protected List<STRPrinterSetup.PrintAttributeDrafts.PrintAttributeDraft> printAttributeDraft;

        /**
         * Gets the value of the printAttributeDraft property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the printAttributeDraft property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPrintAttributeDraft().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link STRPrinterSetup.PrintAttributeDrafts.PrintAttributeDraft }
         * 
         * 
         */
        public List<STRPrinterSetup.PrintAttributeDrafts.PrintAttributeDraft> getPrintAttributeDraft() {
            if (printAttributeDraft == null) {
                printAttributeDraft = new ArrayList<STRPrinterSetup.PrintAttributeDrafts.PrintAttributeDraft>();
            }
            return this.printAttributeDraft;
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
         *         &lt;element name="ID" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="32"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Value" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="128"/>
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
            "id",
            "value"
        })
        public static class PrintAttributeDraft {

            @XmlElementRef(name = "ID", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
            protected JAXBElement<String> id;
            @XmlElement(name = "Value")
            protected String value;

            /**
             * Gets the value of the id property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getID() {
                return id;
            }

            /**
             * Sets the value of the id property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setID(JAXBElement<String> value) {
                this.id = ((JAXBElement<String> ) value);
            }

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

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
     *         &lt;element name="PrintAttributeFinal" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="ID" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;minLength value="1"/>
     *                         &lt;maxLength value="32"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Value" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="128"/>
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
        "printAttributeFinal"
    })
    public static class PrintAttributeFinals {

        @XmlElement(name = "PrintAttributeFinal", required = true)
        protected List<STRPrinterSetup.PrintAttributeFinals.PrintAttributeFinal> printAttributeFinal;

        /**
         * Gets the value of the printAttributeFinal property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the printAttributeFinal property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getPrintAttributeFinal().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link STRPrinterSetup.PrintAttributeFinals.PrintAttributeFinal }
         * 
         * 
         */
        public List<STRPrinterSetup.PrintAttributeFinals.PrintAttributeFinal> getPrintAttributeFinal() {
            if (printAttributeFinal == null) {
                printAttributeFinal = new ArrayList<STRPrinterSetup.PrintAttributeFinals.PrintAttributeFinal>();
            }
            return this.printAttributeFinal;
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
         *         &lt;element name="ID" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;minLength value="1"/>
         *               &lt;maxLength value="32"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Value" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="128"/>
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
            "id",
            "value"
        })
        public static class PrintAttributeFinal {

            @XmlElementRef(name = "ID", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
            protected JAXBElement<String> id;
            @XmlElement(name = "Value")
            protected String value;

            /**
             * Gets the value of the id property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public JAXBElement<String> getID() {
                return id;
            }

            /**
             * Sets the value of the id property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link String }{@code >}
             *     
             */
            public void setID(JAXBElement<String> value) {
                this.id = ((JAXBElement<String> ) value);
            }

            /**
             * Gets the value of the value property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getValue() {
                return value;
            }

            /**
             * Sets the value of the value property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setValue(String value) {
                this.value = value;
            }

        }

    }

}
