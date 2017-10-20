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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BSIT012
 */
@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Spotratehistory.findAll", query = "SELECT s FROM Spotratehistory s"),
		@NamedQuery(name = "Spotratehistory.findById", query = "SELECT s FROM Spotratehistory s WHERE s.id = :id"),
		@NamedQuery(name = "Spotratehistory.findByQuoteDate", query = "SELECT s FROM Spotratehistory s WHERE s.quoteDate = :quoteDate"),
		@NamedQuery(name = "Spotratehistory.findByCcy", query = "SELECT s FROM Spotratehistory s WHERE s.ccy = :ccy"),
		@NamedQuery(name = "Spotratehistory.findByRate", query = "SELECT s FROM Spotratehistory s WHERE s.rate = :rate"),
		@NamedQuery(name = "Spotratehistory.findByProcessTime", query = "SELECT s FROM Spotratehistory s WHERE s.processTime = :processTime") })
public class Spotratehistory implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	private BigDecimal id;
	@Column(name = "QUOTE_DATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date quoteDate;
	private String ccy;
	private BigDecimal rate;
	@Column(name = "PROCESS_TIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date processTime;

	public Spotratehistory() {
	}

	public Spotratehistory(BigDecimal id) {
		this.id = id;
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
		if (!(object instanceof Spotratehistory)) {
			return false;
		}
		Spotratehistory other = (Spotratehistory) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bs.themebridge.entity.model.Spotratehistory[ id=" + id + " ]";
	}

}
