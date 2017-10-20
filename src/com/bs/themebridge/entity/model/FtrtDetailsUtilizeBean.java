/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.themebridge.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * ClassName and NamedQuery should be same 'FtrtDetailsUtilizeBean'
 * 
 * @author BSIT012
 */
@Entity
@Table(name = "FTRT_DETAILS_UTILIZE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "FtrtDetailsUtilizeBean.findAll", query = "SELECT f FROM FtrtDetailsUtilizeBean f"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByApplicationId", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.applicationId = :applicationId"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByApRefNo", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.apRefNo = :apRefNo"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByApplReqDate", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.applReqDate = :applReqDate"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByRequestDate", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.requestDate = :requestDate"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByFromCrncyCode", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.fromCrncyCode = :fromCrncyCode"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByToCrncyCode", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.toCrncyCode = :toCrncyCode"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByRefAmt", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.refAmt = :refAmt"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByFundsDeliveryDate", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.fundsDeliveryDate = :fundsDeliveryDate"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByBuyOrSell", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.buyOrSell = :buyOrSell"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByCifId", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.cifId = :cifId"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByEventId", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.eventId = :eventId"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByRatecode", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.ratecode = :ratecode"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByTreasuryRate", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.treasuryRate = :treasuryRate"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByCustRate", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.custRate = :custRate"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findBySwapRate", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.swapRate = :swapRate"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findBySwapChargeRate", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.swapChargeRate = :swapChargeRate"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByTrRefNum", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.trRefNum = :trRefNum"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByRelatedTrRefNum", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.relatedTrRefNum = :relatedTrRefNum"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByStatus", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.status = :status"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByRemarks", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.remarks = :remarks"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByFreeCode1", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.freeCode1 = :freeCode1"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByFreeCode2", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.freeCode2 = :freeCode2"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByFreeCode3", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.freeCode3 = :freeCode3"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByProcessFlg", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.processFlg = :processFlg"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByErrorReason", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.errorReason = :errorReason"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByFwcType", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.fwcType = :fwcType"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByAccountId", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.accountId = :accountId"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByLobCode", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.lobCode = :lobCode"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findBySolId", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.solId = :solId"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByFwContractNo", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.fwContractNo = :fwContractNo"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByFunctionCode", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.functionCode = :functionCode"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByCreatedBy", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.createdBy = :createdBy"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByCreatedDate", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.createdDate = :createdDate"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByModifiedBy", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.modifiedBy = :modifiedBy"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByModifiedDate", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.modifiedDate = :modifiedDate"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByFundsStartDate", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.fundsStartDate = :fundsStartDate"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByProcessDate", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.processDate = :processDate"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByRevProcRemarks", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.revProcRemarks = :revProcRemarks"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByRevProcessedDate", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.revProcessedDate = :revProcessedDate"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByRevProcessedFlag", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.revProcessedFlag = :revProcessedFlag"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByTradeRefNo", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.tradeRefNo = :tradeRefNo"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByUtilizedAmount", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.utilizedAmount = :utilizedAmount"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByTiContctStatus", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.tiContctStatus = :tiContctStatus"),
		@NamedQuery(name = "FtrtDetailsUtilizeBean.findByTiMstEvtRef", query = "SELECT f FROM FtrtDetailsUtilizeBean f WHERE f.tiMstEvtRef = :tiMstEvtRef") })
public class FtrtDetailsUtilizeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "APPLICATION_ID", nullable = false, length = 20)
	private String applicationId;
	@Basic(optional = false)
	@Column(name = "AP_REF_NO", nullable = false, length = 20)
	private String apRefNo;
	@Basic(optional = false)
	@Column(name = "APPL_REQ_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date applReqDate;
	@Basic(optional = false)
	@Column(name = "REQUEST_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestDate;
	@Basic(optional = false)
	@Column(name = "FROM_CRNCY_CODE", nullable = false, length = 3)
	private String fromCrncyCode;
	@Basic(optional = false)
	@Column(name = "TO_CRNCY_CODE", nullable = false, length = 3)
	private String toCrncyCode;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Basic(optional = false)
	@Column(name = "REF_AMT", nullable = false, precision = 20, scale = 4)
	private BigDecimal refAmt;
	@Basic(optional = false)
	@Column(name = "FUNDS_DELIVERY_DATE", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date fundsDeliveryDate;
	@Basic(optional = false)
	@Column(name = "BUY_OR_SELL", nullable = false, length = 1)
	private String buyOrSell;
	@Basic(optional = false)
	@Column(name = "CIF_ID", nullable = false, length = 50)
	private String cifId;
	@Basic(optional = false)
	@Column(name = "EVENT_ID", nullable = false, length = 5)
	private String eventId;
	@Basic(optional = false)
	@Column(nullable = false, length = 5)
	private String ratecode;
	@Basic(optional = false)
	@Column(name = "TREASURY_RATE", nullable = false)
	private BigDecimal treasuryRate;
	@Basic(optional = false)
	@Column(name = "CUST_RATE", nullable = false)
	private BigDecimal custRate;
	@Column(name = "SWAP_RATE")
	private BigDecimal swapRate;
	@Column(name = "SWAP_CHARGE_RATE")
	private BigDecimal swapChargeRate;
	@Id
	@Basic(optional = false)
	@Column(name = "TR_REF_NUM", nullable = false, length = 16)
	private String trRefNum;
	@Column(name = "RELATED_TR_REF_NUM", length = 16)
	private String relatedTrRefNum;
	@Column(length = 1)
	private String status;
	@Column(length = 80)
	private String remarks;
	@Column(name = "FREE_CODE_1", length = 10)
	private String freeCode1;
	@Column(name = "FREE_CODE_2", length = 10)
	private String freeCode2;
	@Column(name = "FREE_CODE_3", length = 10)
	private String freeCode3;
	@Basic(optional = false)
	@Column(name = "PROCESS_FLG", nullable = false, length = 1)
	private String processFlg;
	@Column(name = "ERROR_REASON", length = 200)
	private String errorReason;
	@Column(name = "FWC_TYPE", length = 5)
	private String fwcType;
	@Column(name = "ACCOUNT_ID", length = 16)
	private String accountId;
	@Column(name = "LOB_CODE", length = 5)
	private String lobCode;
	@Column(name = "SOL_ID", length = 9)
	private String solId;
	@Column(name = "FW_CONTRACT_NO", length = 16)
	private String fwContractNo;
	@Column(name = "FUNCTION_CODE")
	private Character functionCode;
	@Column(name = "CREATED_BY", length = 10)
	private String createdBy;
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "MODIFIED_BY", length = 10)
	private String modifiedBy;
	@Column(name = "MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "FUNDS_START_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fundsStartDate;
	@Column(name = "PROCESS_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date processDate;
	@Column(name = "REV_PROC_REMARKS", length = 4000)
	private String revProcRemarks;
	@Column(name = "REV_PROCESSED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date revProcessedDate;
	@Column(name = "REV_PROCESSED_FLAG")
	private Character revProcessedFlag;
	@Column(name = "TRADE_REF_NO", length = 20)
	private String tradeRefNo;
	@Column(name = "UTILIZED_AMOUNT", precision = 20, scale = 4)
	private BigDecimal utilizedAmount;
	@Column(name = "TI_CONTCT_STATUS", length = 1)
	private String tiContctStatus;
	@Column(name = "TI_MST_EVT_REF", length = 30)
	private String tiMstEvtRef;

	public FtrtDetailsUtilizeBean() {
	}

	public FtrtDetailsUtilizeBean(String trRefNum) {
		this.trRefNum = trRefNum;
	}

	public FtrtDetailsUtilizeBean(String trRefNum, String applicationId, String apRefNo, Date applReqDate,
			Date requestDate, String fromCrncyCode, String toCrncyCode, BigDecimal refAmt, Date fundsDeliveryDate,
			String buyOrSell, String cifId, String eventId, String ratecode, BigDecimal treasuryRate,
			BigDecimal custRate, String processFlg) {
		this.trRefNum = trRefNum;
		this.applicationId = applicationId;
		this.apRefNo = apRefNo;
		this.applReqDate = applReqDate;
		this.requestDate = requestDate;
		this.fromCrncyCode = fromCrncyCode;
		this.toCrncyCode = toCrncyCode;
		this.refAmt = refAmt;
		this.fundsDeliveryDate = fundsDeliveryDate;
		this.buyOrSell = buyOrSell;
		this.cifId = cifId;
		this.eventId = eventId;
		this.ratecode = ratecode;
		this.treasuryRate = treasuryRate;
		this.custRate = custRate;
		this.processFlg = processFlg;
	}

	public String getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}

	public String getApRefNo() {
		return apRefNo;
	}

	public void setApRefNo(String apRefNo) {
		this.apRefNo = apRefNo;
	}

	public Date getApplReqDate() {
		return applReqDate;
	}

	public void setApplReqDate(Date applReqDate) {
		this.applReqDate = applReqDate;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getFromCrncyCode() {
		return fromCrncyCode;
	}

	public void setFromCrncyCode(String fromCrncyCode) {
		this.fromCrncyCode = fromCrncyCode;
	}

	public String getToCrncyCode() {
		return toCrncyCode;
	}

	public void setToCrncyCode(String toCrncyCode) {
		this.toCrncyCode = toCrncyCode;
	}

	public BigDecimal getRefAmt() {
		return refAmt;
	}

	public void setRefAmt(BigDecimal refAmt) {
		this.refAmt = refAmt;
	}

	public Date getFundsDeliveryDate() {
		return fundsDeliveryDate;
	}

	public void setFundsDeliveryDate(Date fundsDeliveryDate) {
		this.fundsDeliveryDate = fundsDeliveryDate;
	}

	public String getBuyOrSell() {
		return buyOrSell;
	}

	public void setBuyOrSell(String buyOrSell) {
		this.buyOrSell = buyOrSell;
	}

	public String getCifId() {
		return cifId;
	}

	public void setCifId(String cifId) {
		this.cifId = cifId;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getRatecode() {
		return ratecode;
	}

	public void setRatecode(String ratecode) {
		this.ratecode = ratecode;
	}

	public BigDecimal getTreasuryRate() {
		return treasuryRate;
	}

	public void setTreasuryRate(BigDecimal treasuryRate) {
		this.treasuryRate = treasuryRate;
	}

	public BigDecimal getCustRate() {
		return custRate;
	}

	public void setCustRate(BigDecimal custRate) {
		this.custRate = custRate;
	}

	public BigDecimal getSwapRate() {
		return swapRate;
	}

	public void setSwapRate(BigDecimal swapRate) {
		this.swapRate = swapRate;
	}

	public BigDecimal getSwapChargeRate() {
		return swapChargeRate;
	}

	public void setSwapChargeRate(BigDecimal swapChargeRate) {
		this.swapChargeRate = swapChargeRate;
	}

	public String getTrRefNum() {
		return trRefNum;
	}

	public void setTrRefNum(String trRefNum) {
		this.trRefNum = trRefNum;
	}

	public String getRelatedTrRefNum() {
		return relatedTrRefNum;
	}

	public void setRelatedTrRefNum(String relatedTrRefNum) {
		this.relatedTrRefNum = relatedTrRefNum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getFreeCode1() {
		return freeCode1;
	}

	public void setFreeCode1(String freeCode1) {
		this.freeCode1 = freeCode1;
	}

	public String getFreeCode2() {
		return freeCode2;
	}

	public void setFreeCode2(String freeCode2) {
		this.freeCode2 = freeCode2;
	}

	public String getFreeCode3() {
		return freeCode3;
	}

	public void setFreeCode3(String freeCode3) {
		this.freeCode3 = freeCode3;
	}

	public String getProcessFlg() {
		return processFlg;
	}

	public void setProcessFlg(String processFlg) {
		this.processFlg = processFlg;
	}

	public String getErrorReason() {
		return errorReason;
	}

	public void setErrorReason(String errorReason) {
		this.errorReason = errorReason;
	}

	public String getFwcType() {
		return fwcType;
	}

	public void setFwcType(String fwcType) {
		this.fwcType = fwcType;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getLobCode() {
		return lobCode;
	}

	public void setLobCode(String lobCode) {
		this.lobCode = lobCode;
	}

	public String getSolId() {
		return solId;
	}

	public void setSolId(String solId) {
		this.solId = solId;
	}

	public String getFwContractNo() {
		return fwContractNo;
	}

	public void setFwContractNo(String fwContractNo) {
		this.fwContractNo = fwContractNo;
	}

	public Character getFunctionCode() {
		return functionCode;
	}

	public void setFunctionCode(Character functionCode) {
		this.functionCode = functionCode;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public Date getFundsStartDate() {
		return fundsStartDate;
	}

	public void setFundsStartDate(Date fundsStartDate) {
		this.fundsStartDate = fundsStartDate;
	}

	public Date getProcessDate() {
		return processDate;
	}

	public void setProcessDate(Date processDate) {
		this.processDate = processDate;
	}

	public String getRevProcRemarks() {
		return revProcRemarks;
	}

	public void setRevProcRemarks(String revProcRemarks) {
		this.revProcRemarks = revProcRemarks;
	}

	public Date getRevProcessedDate() {
		return revProcessedDate;
	}

	public void setRevProcessedDate(Date revProcessedDate) {
		this.revProcessedDate = revProcessedDate;
	}

	public Character getRevProcessedFlag() {
		return revProcessedFlag;
	}

	public void setRevProcessedFlag(Character revProcessedFlag) {
		this.revProcessedFlag = revProcessedFlag;
	}

	public String getTradeRefNo() {
		return tradeRefNo;
	}

	public void setTradeRefNo(String tradeRefNo) {
		this.tradeRefNo = tradeRefNo;
	}

	public BigDecimal getUtilizedAmount() {
		return utilizedAmount;
	}

	public void setUtilizedAmount(BigDecimal utilizedAmount) {
		this.utilizedAmount = utilizedAmount;
	}

	public String getTiContctStatus() {
		return tiContctStatus;
	}

	public void setTiContctStatus(String tiContctStatus) {
		this.tiContctStatus = tiContctStatus;
	}

	public String getTiMstEvtRef() {
		return tiMstEvtRef;
	}

	public void setTiMstEvtRef(String tiMstEvtRef) {
		this.tiMstEvtRef = tiMstEvtRef;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (trRefNum != null ? trRefNum.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof FtrtDetailsUtilizeBean)) {
			return false;
		}
		FtrtDetailsUtilizeBean other = (FtrtDetailsUtilizeBean) object;
		if ((this.trRefNum == null && other.trRefNum != null)
				|| (this.trRefNum != null && !this.trRefNum.equals(other.trRefNum))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "FtrtDetailsUtilizeBean[ trRefNum=" + trRefNum + " ]";
	}

}
