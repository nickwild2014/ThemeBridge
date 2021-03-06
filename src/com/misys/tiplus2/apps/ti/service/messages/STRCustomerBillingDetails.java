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
import com.misys.tiplus2.apps.ti.service.common.GWRBillingLevel;
import com.misys.tiplus2.apps.ti.service.common.GWRPeriodAndDayInMonth;


/**
 * .
 * 
 * <p>Java class for STRCustomerBillingDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="STRCustomerBillingDetails">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GatewayStatic">
 *       &lt;sequence>
 *         &lt;element name="MainBankingEntity" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBranch" minOccurs="0"/>
 *         &lt;element name="Customer" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRCustomerMnemonic" minOccurs="0"/>
 *         &lt;element name="BehalfOfBranch" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBranch" minOccurs="0"/>
 *         &lt;element name="BillingLevel" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBillingLevel" minOccurs="0"/>
 *         &lt;element name="NoticeRequired" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBool" minOccurs="0"/>
 *         &lt;element name="NoticeDays" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRInteger" minOccurs="0"/>
 *         &lt;element name="FrequencyPeriod" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRPeriodAndDayInMonth" minOccurs="0"/>
 *         &lt;element name="InvoicingRequired" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBool" minOccurs="0"/>
 *         &lt;element name="AppliesToAllProducts" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBool" minOccurs="0"/>
 *         &lt;element name="ProductMappingsToAdds" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Product" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="ProductMappingsToDeletes" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="Product" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
@XmlType(name = "STRCustomerBillingDetails", propOrder = {
    "mainBankingEntity",
    "customer",
    "behalfOfBranch",
    "billingLevel",
    "noticeRequired",
    "noticeDays",
    "frequencyPeriod",
    "invoicingRequired",
    "appliesToAllProducts",
    "productMappingsToAdds",
    "productMappingsToDeletes"
})
public class STRCustomerBillingDetails
    extends GatewayStatic
{

    @XmlElement(name = "MainBankingEntity")
    protected String mainBankingEntity;
    @XmlElement(name = "Customer")
    protected String customer;
    @XmlElement(name = "BehalfOfBranch")
    protected String behalfOfBranch;
    @XmlElementRef(name = "BillingLevel", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<GWRBillingLevel> billingLevel;
    @XmlElement(name = "NoticeRequired")
    protected EnigmaBoolean noticeRequired;
    @XmlElementRef(name = "NoticeDays", namespace = "urn:messages.service.ti.apps.tiplus2.misys.com", type = JAXBElement.class)
    protected JAXBElement<Integer> noticeDays;
    @XmlElement(name = "FrequencyPeriod")
    protected GWRPeriodAndDayInMonth frequencyPeriod;
    @XmlElement(name = "InvoicingRequired")
    protected EnigmaBoolean invoicingRequired;
    @XmlElement(name = "AppliesToAllProducts")
    protected EnigmaBoolean appliesToAllProducts;
    @XmlElement(name = "ProductMappingsToAdds")
    protected STRCustomerBillingDetails.ProductMappingsToAdds productMappingsToAdds;
    @XmlElement(name = "ProductMappingsToDeletes")
    protected STRCustomerBillingDetails.ProductMappingsToDeletes productMappingsToDeletes;

    /**
     * Gets the value of the mainBankingEntity property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMainBankingEntity() {
        return mainBankingEntity;
    }

    /**
     * Sets the value of the mainBankingEntity property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMainBankingEntity(String value) {
        this.mainBankingEntity = value;
    }

    /**
     * Gets the value of the customer property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomer() {
        return customer;
    }

    /**
     * Sets the value of the customer property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomer(String value) {
        this.customer = value;
    }

    /**
     * Gets the value of the behalfOfBranch property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBehalfOfBranch() {
        return behalfOfBranch;
    }

    /**
     * Sets the value of the behalfOfBranch property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBehalfOfBranch(String value) {
        this.behalfOfBranch = value;
    }

    /**
     * Gets the value of the billingLevel property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link GWRBillingLevel }{@code >}
     *     
     */
    public JAXBElement<GWRBillingLevel> getBillingLevel() {
        return billingLevel;
    }

    /**
     * Sets the value of the billingLevel property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link GWRBillingLevel }{@code >}
     *     
     */
    public void setBillingLevel(JAXBElement<GWRBillingLevel> value) {
        this.billingLevel = ((JAXBElement<GWRBillingLevel> ) value);
    }

    /**
     * Gets the value of the noticeRequired property.
     * 
     * @return
     *     possible object is
     *     {@link EnigmaBoolean }
     *     
     */
    public EnigmaBoolean getNoticeRequired() {
        return noticeRequired;
    }

    /**
     * Sets the value of the noticeRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnigmaBoolean }
     *     
     */
    public void setNoticeRequired(EnigmaBoolean value) {
        this.noticeRequired = value;
    }

    /**
     * Gets the value of the noticeDays property.
     * 
     * @return
     *     possible object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public JAXBElement<Integer> getNoticeDays() {
        return noticeDays;
    }

    /**
     * Sets the value of the noticeDays property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link Integer }{@code >}
     *     
     */
    public void setNoticeDays(JAXBElement<Integer> value) {
        this.noticeDays = ((JAXBElement<Integer> ) value);
    }

    /**
     * Gets the value of the frequencyPeriod property.
     * 
     * @return
     *     possible object is
     *     {@link GWRPeriodAndDayInMonth }
     *     
     */
    public GWRPeriodAndDayInMonth getFrequencyPeriod() {
        return frequencyPeriod;
    }

    /**
     * Sets the value of the frequencyPeriod property.
     * 
     * @param value
     *     allowed object is
     *     {@link GWRPeriodAndDayInMonth }
     *     
     */
    public void setFrequencyPeriod(GWRPeriodAndDayInMonth value) {
        this.frequencyPeriod = value;
    }

    /**
     * Gets the value of the invoicingRequired property.
     * 
     * @return
     *     possible object is
     *     {@link EnigmaBoolean }
     *     
     */
    public EnigmaBoolean getInvoicingRequired() {
        return invoicingRequired;
    }

    /**
     * Sets the value of the invoicingRequired property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnigmaBoolean }
     *     
     */
    public void setInvoicingRequired(EnigmaBoolean value) {
        this.invoicingRequired = value;
    }

    /**
     * Gets the value of the appliesToAllProducts property.
     * 
     * @return
     *     possible object is
     *     {@link EnigmaBoolean }
     *     
     */
    public EnigmaBoolean getAppliesToAllProducts() {
        return appliesToAllProducts;
    }

    /**
     * Sets the value of the appliesToAllProducts property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnigmaBoolean }
     *     
     */
    public void setAppliesToAllProducts(EnigmaBoolean value) {
        this.appliesToAllProducts = value;
    }

    /**
     * Gets the value of the productMappingsToAdds property.
     * 
     * @return
     *     possible object is
     *     {@link STRCustomerBillingDetails.ProductMappingsToAdds }
     *     
     */
    public STRCustomerBillingDetails.ProductMappingsToAdds getProductMappingsToAdds() {
        return productMappingsToAdds;
    }

    /**
     * Sets the value of the productMappingsToAdds property.
     * 
     * @param value
     *     allowed object is
     *     {@link STRCustomerBillingDetails.ProductMappingsToAdds }
     *     
     */
    public void setProductMappingsToAdds(STRCustomerBillingDetails.ProductMappingsToAdds value) {
        this.productMappingsToAdds = value;
    }

    /**
     * Gets the value of the productMappingsToDeletes property.
     * 
     * @return
     *     possible object is
     *     {@link STRCustomerBillingDetails.ProductMappingsToDeletes }
     *     
     */
    public STRCustomerBillingDetails.ProductMappingsToDeletes getProductMappingsToDeletes() {
        return productMappingsToDeletes;
    }

    /**
     * Sets the value of the productMappingsToDeletes property.
     * 
     * @param value
     *     allowed object is
     *     {@link STRCustomerBillingDetails.ProductMappingsToDeletes }
     *     
     */
    public void setProductMappingsToDeletes(STRCustomerBillingDetails.ProductMappingsToDeletes value) {
        this.productMappingsToDeletes = value;
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
     *         &lt;element name="Product" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "product"
    })
    public static class ProductMappingsToAdds {

        @XmlElement(name = "Product")
        protected List<String> product;

        /**
         * Gets the value of the product property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the product property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProduct().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getProduct() {
            if (product == null) {
                product = new ArrayList<String>();
            }
            return this.product;
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
     *         &lt;element name="Product" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
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
        "product"
    })
    public static class ProductMappingsToDeletes {

        @XmlElement(name = "Product")
        protected List<String> product;

        /**
         * Gets the value of the product property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the product property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getProduct().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link String }
         * 
         * 
         */
        public List<String> getProduct() {
            if (product == null) {
                product = new ArrayList<String>();
            }
            return this.product;
        }

    }

}
