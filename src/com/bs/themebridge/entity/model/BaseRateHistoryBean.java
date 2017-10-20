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
// @Table(name = "BASERATEHISTORY", catalog = "", schema = "THEMEBRIDGE")
@Table(name = "BASERATEHISTORY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "BaseRateHistory.findAll", query = "SELECT b FROM BaseRateHistory b"),
		@NamedQuery(name = "BaseRateHistory.findById", query = "SELECT b FROM BaseRateHistory b WHERE b.id = :id"),
		@NamedQuery(name = "BaseRateHistory.findByQuoteDate", query = "SELECT b FROM BaseRateHistory b WHERE b.quoteDate = :quoteDate"),
		@NamedQuery(name = "BaseRateHistory.findByRateType", query = "SELECT b FROM BaseRateHistory b WHERE b.rateType = :rateType"),
		@NamedQuery(name = "BaseRateHistory.findByRate", query = "SELECT b FROM BaseRateHistory b WHERE b.rate = :rate"),
		@NamedQuery(name = "BaseRateHistory.findByProcessedFlag", query = "SELECT b FROM BaseRateHistory b WHERE b.processedFlag = :processedFlag"),
		@NamedQuery(name = "BaseRateHistory.findByProcessedDate", query = "SELECT b FROM BaseRateHistory b WHERE b.processedDate = :processedDate"),
		@NamedQuery(name = "BaseRateHistory.findByProcRemarks", query = "SELECT b FROM BaseRateHistory b WHERE b.procRemarks = :procRemarks"),
		@NamedQuery(name = "BaseRateHistory.findByCreatedBy", query = "SELECT b FROM BaseRateHistory b WHERE b.createdBy = :createdBy"),
		@NamedQuery(name = "BaseRateHistory.findByCreatedDate", query = "SELECT b FROM BaseRateHistory b WHERE b.createdDate = :createdDate"),
		@NamedQuery(name = "BaseRateHistory.findByModifiedBy", query = "SELECT b FROM BaseRateHistory b WHERE b.modifiedBy = :modifiedBy"),
		@NamedQuery(name = "BaseRateHistory.findByModifiedDate", query = "SELECT b FROM BaseRateHistory b WHERE b.modifiedDate = :modifiedDate"),
		@NamedQuery(name = "BaseRateHistory.findByProcessTime", query = "SELECT b FROM BaseRateHistory b WHERE b.processTime = :processTime") })
public class BaseRateHistoryBean implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BRSEQ")
	@SequenceGenerator(name = "BRSEQ", sequenceName = "BASERATEHISTORY_SEQ", allocationSize = 1)
	private BigDecimal id;
	@Basic(optional = false)
	@Column(name = "QUOTE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date quoteDate;
	@Basic(optional = false)
	@Column(name = "RATE_TYPE")
	private String rateType;
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

	public BaseRateHistoryBean() {
	}

	public BaseRateHistoryBean(BigDecimal id) {
		this.id = id;
	}

	public BaseRateHistoryBean(BigDecimal id, Date quoteDate, String rateType, BigDecimal rate) {
		this.id = id;
		this.quoteDate = quoteDate;
		this.rateType = rateType;
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
		if (!(object instanceof BaseRateHistoryBean)) {
			return false;
		}
		BaseRateHistoryBean other = (BaseRateHistoryBean) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication1.BaseRateHistory[ id=" + id + " ]";
	}

}
