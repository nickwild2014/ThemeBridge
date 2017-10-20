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


/**
 * Document of title definition.
 * 
 * <p>Java class for STRDocumentOfTitleDefinition complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="STRDocumentOfTitleDefinition">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GatewayStatic">
 *       &lt;sequence>
 *         &lt;element name="Code" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRDocumentOfTitleDefinitionKey" minOccurs="0"/>
 *         &lt;element name="RequiresReturn" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBool" minOccurs="0"/>
 *         &lt;element name="DocumentFields" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="DocumentField" maxOccurs="unbounded">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="FieldType" type="{urn:messages.service.ti.apps.tiplus2.misys.com}STRDocumentOfTitleDefinition_DocumentFields_FieldType" minOccurs="0"/>
 *                             &lt;element name="Title" minOccurs="0">
 *                               &lt;simpleType>
 *                                 &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *                                   &lt;maxLength value="35"/>
 *                                 &lt;/restriction>
 *                               &lt;/simpleType>
 *                             &lt;/element>
 *                             &lt;element name="Mandatory" type="{urn:common.service.ti.apps.tiplus2.misys.com}EnigmaBoolean" minOccurs="0"/>
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
@XmlType(name = "STRDocumentOfTitleDefinition", propOrder = {
    "code",
    "requiresReturn",
    "documentFields"
})
public class STRDocumentOfTitleDefinition
    extends GatewayStatic
{

    @XmlElement(name = "Code")
    protected String code;
    @XmlElement(name = "RequiresReturn")
    protected EnigmaBoolean requiresReturn;
    @XmlElement(name = "DocumentFields")
    protected STRDocumentOfTitleDefinition.DocumentFields documentFields;

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
     * Gets the value of the requiresReturn property.
     * 
     * @return
     *     possible object is
     *     {@link EnigmaBoolean }
     *     
     */
    public EnigmaBoolean getRequiresReturn() {
        return requiresReturn;
    }

    /**
     * Sets the value of the requiresReturn property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnigmaBoolean }
     *     
     */
    public void setRequiresReturn(EnigmaBoolean value) {
        this.requiresReturn = value;
    }

    /**
     * Gets the value of the documentFields property.
     * 
     * @return
     *     possible object is
     *     {@link STRDocumentOfTitleDefinition.DocumentFields }
     *     
     */
    public STRDocumentOfTitleDefinition.DocumentFields getDocumentFields() {
        return documentFields;
    }

    /**
     * Sets the value of the documentFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link STRDocumentOfTitleDefinition.DocumentFields }
     *     
     */
    public void setDocumentFields(STRDocumentOfTitleDefinition.DocumentFields value) {
        this.documentFields = value;
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
     *         &lt;element name="DocumentField" maxOccurs="unbounded">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="FieldType" type="{urn:messages.service.ti.apps.tiplus2.misys.com}STRDocumentOfTitleDefinition_DocumentFields_FieldType" minOccurs="0"/>
     *                   &lt;element name="Title" minOccurs="0">
     *                     &lt;simpleType>
     *                       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
     *                         &lt;maxLength value="35"/>
     *                       &lt;/restriction>
     *                     &lt;/simpleType>
     *                   &lt;/element>
     *                   &lt;element name="Mandatory" type="{urn:common.service.ti.apps.tiplus2.misys.com}EnigmaBoolean" minOccurs="0"/>
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
        "documentField"
    })
    public static class DocumentFields {

        @XmlElement(name = "DocumentField", required = true)
        protected List<STRDocumentOfTitleDefinition.DocumentFields.DocumentField> documentField;

        /**
         * Gets the value of the documentField property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the documentField property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getDocumentField().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link STRDocumentOfTitleDefinition.DocumentFields.DocumentField }
         * 
         * 
         */
        public List<STRDocumentOfTitleDefinition.DocumentFields.DocumentField> getDocumentField() {
            if (documentField == null) {
                documentField = new ArrayList<STRDocumentOfTitleDefinition.DocumentFields.DocumentField>();
            }
            return this.documentField;
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
         *         &lt;element name="FieldType" type="{urn:messages.service.ti.apps.tiplus2.misys.com}STRDocumentOfTitleDefinition_DocumentFields_FieldType" minOccurs="0"/>
         *         &lt;element name="Title" minOccurs="0">
         *           &lt;simpleType>
         *             &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
         *               &lt;maxLength value="35"/>
         *             &lt;/restriction>
         *           &lt;/simpleType>
         *         &lt;/element>
         *         &lt;element name="Mandatory" type="{urn:common.service.ti.apps.tiplus2.misys.com}EnigmaBoolean" minOccurs="0"/>
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
            "fieldType",
            "title",
            "mandatory"
        })
        public static class DocumentField {

            @XmlElement(name = "FieldType")
            protected STRDocumentOfTitleDefinitionDocumentFieldsFieldType fieldType;
            @XmlElement(name = "Title")
            protected String title;
            @XmlElementRef(name = "Mandatory", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
            protected JAXBElement<EnigmaBoolean> mandatory;

            /**
             * Gets the value of the fieldType property.
             * 
             * @return
             *     possible object is
             *     {@link STRDocumentOfTitleDefinitionDocumentFieldsFieldType }
             *     
             */
            public STRDocumentOfTitleDefinitionDocumentFieldsFieldType getFieldType() {
                return fieldType;
            }

            /**
             * Sets the value of the fieldType property.
             * 
             * @param value
             *     allowed object is
             *     {@link STRDocumentOfTitleDefinitionDocumentFieldsFieldType }
             *     
             */
            public void setFieldType(STRDocumentOfTitleDefinitionDocumentFieldsFieldType value) {
                this.fieldType = value;
            }

            /**
             * Gets the value of the title property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getTitle() {
                return title;
            }

            /**
             * Sets the value of the title property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setTitle(String value) {
                this.title = value;
            }

            /**
             * Gets the value of the mandatory property.
             * 
             * @return
             *     possible object is
             *     {@link JAXBElement }{@code <}{@link EnigmaBoolean }{@code >}
             *     
             */
            public JAXBElement<EnigmaBoolean> getMandatory() {
                return mandatory;
            }

            /**
             * Sets the value of the mandatory property.
             * 
             * @param value
             *     allowed object is
             *     {@link JAXBElement }{@code <}{@link EnigmaBoolean }{@code >}
             *     
             */
            public void setMandatory(JAXBElement<EnigmaBoolean> value) {
                this.mandatory = ((JAXBElement<EnigmaBoolean> ) value);
            }

        }

    }

}
