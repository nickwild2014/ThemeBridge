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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Prasath Ravichandran
 */
@Entity
// @Table(name = "CARD_RATE_FX_HISTORY", catalog = "", schema = "THEMEBRIDGE")
@Table(name = "CARDRATEFXHISTORY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "CardRateFxHistory.findAll", query = "SELECT c FROM CardRateFxHistory c"),
		@NamedQuery(name = "CardRateFxHistory.findById", query = "SELECT c FROM CardRateFxHistory c WHERE c.id = :id"),
		@NamedQuery(name = "CardRateFxHistory.findByQuoteDate", query = "SELECT c FROM CardRateFxHistory c WHERE c.quoteDate = :quoteDate"),
		@NamedQuery(name = "CardRateFxHistory.findByRateType", query = "SELECT c FROM CardRateFxHistory c WHERE c.rateType = :rateType"),
		@NamedQuery(name = "CardRateFxHistory.findByCcy", query = "SELECT c FROM CardRateFxHistory c WHERE c.ccy = :ccy"),
		@NamedQuery(name = "CardRateFxHistory.findByRate", query = "SELECT c FROM CardRateFxHistory c WHERE c.rate = :rate"),
		@NamedQuery(name = "CardRateFxHistory.findByProcessedFlag", query = "SELECT c FROM CardRateFxHistory c WHERE c.processedFlag = :processedFlag"),
		@NamedQuery(name = "CardRateFxHistory.findByProcessedDate", query = "SELECT c FROM CardRateFxHistory c WHERE c.processedDate = :processedDate"),
		@NamedQuery(name = "CardRateFxHistory.findByProcRemarks", query = "SELECT c FROM CardRateFxHistory c WHERE c.procRemarks = :procRemarks"),
		@NamedQuery(name = "CardRateFxHistory.findByCreatedBy", query = "SELECT c FROM CardRateFxHistory c WHERE c.createdBy = :createdBy"),
		@NamedQuery(name = "CardRateFxHistory.findByCreatedDate", query = "SELECT c FROM CardRateFxHistory c WHERE c.createdDate = :createdDate"),
		@NamedQuery(name = "CardRateFxHistory.findByModifiedBy", query = "SELECT c FROM CardRateFxHistory c WHERE c.modifiedBy = :modifiedBy"),
		@NamedQuery(name = "CardRateFxHistory.findByModifiedDate", query = "SELECT c FROM CardRateFxHistory c WHERE c.modifiedDate = :modifiedDate"),
		@NamedQuery(name = "CardRateFxHistory.findByProcessTime", query = "SELECT c FROM CardRateFxHistory c WHERE c.processTime = :processTime") })
public class CardRateFxHistory implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CRSEQ")
	@SequenceGenerator(name = "CRSEQ", sequenceName = "CARDRATEHISTORY_SEQ", allocationSize = 1)
	private BigDecimal id;
	@Basic(optional = false)
	@Column(name = "QUOTE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date quoteDate;
	@Basic(optional = false)
	@Column(name = "RATE_TYPE")
	private String rateType;
	@Basic(optional = false)
	@Column(name = "CCY")
	private String ccy;
	@Basic(optional = false)
	@Column(name = "RATE")
	private BigDecimal rate;
	@Column(name = "PROCESSED_FLAG")
	private String processedFlag;
	@Column(name = "PROCESSED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date processedDate;
	@Column(name = "PROC_REMARKS")
	private String procRemarks;
	@Column(name = "CREATED_BY")
	private String createdBy;
	@Column(name = "CREATED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;
	@Column(name = "MODIFIED_BY")
	private String modifiedBy;
	@Column(name = "MODIFIED_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;
	@Column(name = "PROCESS_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date processTime;

	public CardRateFxHistory() {
	}

	public CardRateFxHistory(BigDecimal id) {
		this.id = id;
	}

	public CardRateFxHistory(BigDecimal id, Date quoteDate, String rateType, String ccy, BigDecimal rate) {
		this.id = id;
		this.quoteDate = quoteDate;
		this.rateType = rateType;
		this.ccy = ccy;
		this.rate = rate;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public Date getQuoteDate() {
		return quoteDate;
	}

	public void setQuoteDate(Date quoteDate) {
		this.quoteDate = quoteDate;
	}

	public String getRateType() {
		return rateType;
	}

	public void setRateType(String rateType) {
		this.rateType = rateType;
	}

	public String getCcy() {
		return ccy;
	}

	public void setCcy(String ccy) {
		this.ccy = ccy;
	}

	public BigDecimal getRate() {
		return rate;
	}

	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}

	public String getProcessedFlag() {
		return processedFlag;
	}

	public void setProcessedFlag(String processedFlag) {
		this.processedFlag = processedFlag;
	}

	public Date getProcessedDate() {
		return processedDate;
	}

	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}

	public String getProcRemarks() {
		return procRemarks;
	}

	public void setProcRemarks(String procRemarks) {
		this.procRemarks = procRemarks;
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

	public Date getProcessTime() {
		return processTime;
	}

	public void setProcessTime(Date processTime) {
		this.processTime = processTime;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof CardRateFxHistory)) {
			return false;
		}
		CardRateFxHistory other = (CardRateFxHistory) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication1.CardRateFxHistory[ id=" + id + " ]";
	}

}
