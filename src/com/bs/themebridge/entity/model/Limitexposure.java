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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BSIT012
 */
@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Limitexposure.findAll", query = "SELECT l FROM Limitexposure l"),
		@NamedQuery(name = "Limitexposure.findById", query = "SELECT l FROM Limitexposure l WHERE l.id = :id"),
		@NamedQuery(name = "Limitexposure.findByMasterreference", query = "SELECT l FROM Limitexposure l WHERE l.masterreference = :masterreference"),
		@NamedQuery(name = "Limitexposure.findByEventreference", query = "SELECT l FROM Limitexposure l WHERE l.eventreference = :eventreference"),
		@NamedQuery(name = "Limitexposure.findByLimitprefix", query = "SELECT l FROM Limitexposure l WHERE l.limitprefix = :limitprefix"),
		@NamedQuery(name = "Limitexposure.findByLimitsuffix", query = "SELECT l FROM Limitexposure l WHERE l.limitsuffix = :limitsuffix"),
		@NamedQuery(name = "Limitexposure.findByReservationid", query = "SELECT l FROM Limitexposure l WHERE l.reservationid = :reservationid"),
		@NamedQuery(name = "Limitexposure.findByTrxnamount", query = "SELECT l FROM Limitexposure l WHERE l.trxnamount = :trxnamount"),
		@NamedQuery(name = "Limitexposure.findByTrxncurrency", query = "SELECT l FROM Limitexposure l WHERE l.trxncurrency = :trxncurrency"),
		@NamedQuery(name = "Limitexposure.findByRate", query = "SELECT l FROM Limitexposure l WHERE l.rate = :rate"),
		@NamedQuery(name = "Limitexposure.findByExposureamount", query = "SELECT l FROM Limitexposure l WHERE l.exposureamount = :exposureamount"),
		@NamedQuery(name = "Limitexposure.findByExposurecurrency", query = "SELECT l FROM Limitexposure l WHERE l.exposurecurrency = :exposurecurrency"),
		@NamedQuery(name = "Limitexposure.findByExposureflag", query = "SELECT l FROM Limitexposure l WHERE l.exposureflag = :exposureflag"),
		@NamedQuery(name = "Limitexposure.findByValuedate", query = "SELECT l FROM Limitexposure l WHERE l.valuedate = :valuedate"),
		@NamedQuery(name = "Limitexposure.findByProcesstime", query = "SELECT l FROM Limitexposure l WHERE l.processtime = :processtime"),
		@NamedQuery(name = "Limitexposure.findByLiabtype", query = "SELECT l FROM Limitexposure l WHERE l.liabtype = :liabtype"),
		@NamedQuery(name = "Limitexposure.findByNarrative1", query = "SELECT l FROM Limitexposure l WHERE l.narrative1 = :narrative1") })
public class Limitexposure implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIMITSEQ")
	@SequenceGenerator(name = "LIMITSEQ", sequenceName = "LIMITEXPOSURE_SEQ", allocationSize = 1)
	private BigDecimal id;
	private String masterreference;
	private String eventreference;
	private String limitprefix;
	private String limitsuffix;
	private String reservationid;
	private BigDecimal trxnamount;
	private String trxncurrency;
	private String rate;
	private BigDecimal exposureamount;
	private String exposurecurrency;
	private String exposureflag;
	@Temporal(TemporalType.TIMESTAMP)
	private Date valuedate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date processtime;
	private String liabtype;
	private String narrative1;

	public Limitexposure() {
	}

	public Limitexposure(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getMasterreference() {
		return masterreference;
	}

	public void setMasterreference(String masterreference) {
		this.masterreference = masterreference;
	}

	public String getEventreference() {
		return eventreference;
	}

	public void setEventreference(String eventreference) {
		this.eventreference = eventreference;
	}

	public String getLimitprefix() {
		return limitprefix;
	}

	public void setLimitprefix(String limitprefix) {
		this.limitprefix = limitprefix;
	}

	public String getLimitsuffix() {
		return limitsuffix;
	}

	public void setLimitsuffix(String limitsuffix) {
		this.limitsuffix = limitsuffix;
	}

	public String getReservationid() {
		return reservationid;
	}

	public void setReservationid(String reservationid) {
		this.reservationid = reservationid;
	}

	public BigDecimal getTrxnamount() {
		return trxnamount;
	}

	public void setTrxnamount(BigDecimal trxnamount) {
		this.trxnamount = trxnamount;
	}

	public String getTrxncurrency() {
		return trxncurrency;
	}

	public void setTrxncurrency(String trxncurrency) {
		this.trxncurrency = trxncurrency;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public BigDecimal getExposureamount() {
		return exposureamount;
	}

	public void setExposureamount(BigDecimal exposureamount) {
		this.exposureamount = exposureamount;
	}

	public String getExposurecurrency() {
		return exposurecurrency;
	}

	public void setExposurecurrency(String exposurecurrency) {
		this.exposurecurrency = exposurecurrency;
	}

	public String getExposureflag() {
		return exposureflag;
	}

	public void setExposureflag(String exposureflag) {
		this.exposureflag = exposureflag;
	}

	public Date getValuedate() {
		return valuedate;
	}

	public void setValuedate(Date valuedate) {
		this.valuedate = valuedate;
	}

	public Date getProcesstime() {
		return processtime;
	}

	public void setProcesstime(Date processtime) {
		this.processtime = processtime;
	}

	public String getLiabtype() {
		return liabtype;
	}

	public void setLiabtype(String liabtype) {
		this.liabtype = liabtype;
	}

	public String getNarrative1() {
		return narrative1;
	}

	public void setNarrative1(String narrative1) {
		this.narrative1 = narrative1;
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
		if (!(object instanceof Limitexposure)) {
			return false;
		}
		Limitexposure other = (Limitexposure) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bs.themebridge.entity.model.Limitexposure[ id=" + id + " ]";
	}

}
