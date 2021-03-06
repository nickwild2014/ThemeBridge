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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import com.misys.tiplus2.apps.ti.service.common.EnigmaBoolean;


/**
 * Parent of the Gateway panes used to maintain Static data. Gatewaymaintenance .
 * 
 * <p>Java class for GatewayStatic complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="GatewayStatic">
 *   &lt;complexContent>
 *     &lt;extension base="{urn:messages.service.ti.apps.tiplus2.misys.com}GatewayMaintenance">
 *       &lt;sequence>
 *         &lt;element name="MaintainedInBackOffice" type="{urn:common.service.ti.apps.tiplus2.misys.com}GWRBool" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "GatewayStatic", propOrder = {
    "maintainedInBackOffice"
})
@XmlSeeAlso({
    STRCodeDescriptions.class,
    STRLocalDictionary.class,
    STRStatistics.class,
    STRChequeNumber.class,
    STRCustomerAddress.class,
    STRTransliterationExclusion.class,
    STRTransferMethod.class,
    STRCurrencySpotRate.class,
    STRTeam.class,
    STRCountry.class,
    STRSwiftAddress.class,
    STRAccountOfficer.class,
    STRExternalServiceDefinition.class,
    STRSCFProgramme.class,
    STRChargeGroup.class,
    STRSCFCounterparty.class,
    STRCollateralType.class,
    STRBaseRate.class,
    STRDomainList.class,
    STRSystemParameter.class,
    STRLanguage.class,
    STRBICPlusIBAN.class,
    STRNoteType.class,
    STRBranchAddress.class,
    STRChargeCode.class,
    STRFXRate.class,
    STRCustomerType.class,
    STRNostro.class,
    STRInstructionGroup.class,
    STRIncoterms.class,
    STRGoodsCode.class,
    STRDocumentOfTitleDefinition.class,
    STRTransactionCode.class,
    STRStaticDataAlias.class,
    STRAnalysisCode.class,
    STRClearingSystemCode.class,
    STRCustomerBillingDetails.class,
    STREntityType.class,
    STRAddressType.class,
    STRDifferentialRate.class,
    STRCorporateAccess.class,
    STRSCFBuyer.class,
    STRGroup.class,
    STRUserOption.class,
    STRDefaultNostro.class,
    STRSCFRelationshipMap.class,
    STRCurrency.class,
    STRBranch.class,
    STRBaseRateCode.class,
    STRSystemDictionary.class,
    STRClearingSystemID.class,
    STRFXRateCode.class,
    STRAttachedDocumentType.class,
    STRIBANStructure.class,
    STRAccountType.class,
    STRSCFSellerBuyerMap.class,
    STRTransliterationConversion.class,
    STRPaymentRejectCode.class,
    STRAccount.class,
    STRCorrespondent.class,
    STRExternalSystem.class,
    STRInvoiceCustomer.class,
    STRStandingSettlementInstructions.class,
    STRDealType.class,
    STRTICustomerDetails.class,
    STRCalendar.class,
    STRCustomer.class
})
public class GatewayStatic
    extends GatewayMaintenance
{

    @XmlElement(name = "MaintainedInBackOffice")
    protected EnigmaBoolean maintainedInBackOffice;

    /**
     * Gets the value of the maintainedInBackOffice property.
     * 
     * @return
     *     possible object is
     *     {@link EnigmaBoolean }
     *     
     */
    public EnigmaBoolean getMaintainedInBackOffice() {
        return maintainedInBackOffice;
    }

    /**
     * Sets the value of the maintainedInBackOffice property.
     * 
     * @param value
     *     allowed object is
     *     {@link EnigmaBoolean }
     *     
     */
    public void setMaintainedInBackOffice(EnigmaBoolean value) {
        this.maintainedInBackOffice = value;
    }

}
