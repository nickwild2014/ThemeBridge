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
@NamedQueries({ @NamedQuery(name = "Limitsoftblock.findAll", query = "SELECT l FROM Limitsoftblock l"),
		@NamedQuery(name = "Limitsoftblock.findById", query = "SELECT l FROM Limitsoftblock l WHERE l.id = :id"),
		@NamedQuery(name = "Limitsoftblock.findByMasterreference", query = "SELECT l FROM Limitsoftblock l WHERE l.masterreference = :masterreference"),
		@NamedQuery(name = "Limitsoftblock.findByEventreference", query = "SELECT l FROM Limitsoftblock l WHERE l.eventreference = :eventreference"),
		@NamedQuery(name = "Limitsoftblock.findByMasterEventId", query = "SELECT l FROM Limitsoftblock l WHERE l.masterreference = :masterreference and l.eventreference = :eventreference"),
		@NamedQuery(name = "Limitsoftblock.findByMasterEventLimitFlag", query = "SELECT l FROM Limitsoftblock l WHERE l.masterreference = :masterreference and l.eventreference = :eventreference and l.limitumlflag = :limitumlflag"),
		@NamedQuery(name = "Limitsoftblock.findByFacilityid", query = "SELECT l FROM Limitsoftblock l WHERE l.facilityid = :facilityid"),
		@NamedQuery(name = "Limitsoftblock.findByReservationid", query = "SELECT l FROM Limitsoftblock l WHERE l.reservationid = :reservationid"),
		@NamedQuery(name = "Limitsoftblock.findByTranamount", query = "SELECT l FROM Limitsoftblock l WHERE l.tranamount = :tranamount"),
		@NamedQuery(name = "Limitsoftblock.findByTrxncurrency", query = "SELECT l FROM Limitsoftblock l WHERE l.trxncurrency = :trxncurrency"),
		@NamedQuery(name = "Limitsoftblock.findByRate", query = "SELECT l FROM Limitsoftblock l WHERE l.rate = :rate"),
		@NamedQuery(name = "Limitsoftblock.findByLimitumlamount", query = "SELECT l FROM Limitsoftblock l WHERE l.limitumlamount = :limitumlamount"),
		@NamedQuery(name = "Limitsoftblock.findByLimitumlcurrency", query = "SELECT l FROM Limitsoftblock l WHERE l.limitumlcurrency = :limitumlcurrency"),
		@NamedQuery(name = "Limitsoftblock.findByLimitumlflag", query = "SELECT l FROM Limitsoftblock l WHERE l.limitumlflag = :limitumlflag"),
		@NamedQuery(name = "Limitsoftblock.findByValuedate", query = "SELECT l FROM Limitsoftblock l WHERE l.valuedate = :valuedate"),
		@NamedQuery(name = "Limitsoftblock.findByLimitservice", query = "SELECT l FROM Limitsoftblock l WHERE l.limitservice = :limitservice"),
		@NamedQuery(name = "Limitsoftblock.findByProcesstime", query = "SELECT l FROM Limitsoftblock l WHERE l.processtime = :processtime"),
		@NamedQuery(name = "Limitsoftblock.findByNarrative1", query = "SELECT l FROM Limitsoftblock l WHERE l.narrative1 = :narrative1") })
public class Limitsoftblock implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LIMITSFSEQ")
	@SequenceGenerator(name = "LIMITSFSEQ", sequenceName = "LIMITSOFTBLOCK_SEQ", allocationSize = 1)
	private BigDecimal id;
	private String masterreference;
	private String eventreference;
	private String facilityid;
	private String reservationid;
	private String tranamount;
	private String trxncurrency;
	private String rate;
	private String limitumlamount;
	private String limitumlcurrency;
	private String limitumlflag;
	@Temporal(TemporalType.TIMESTAMP)
	private Date valuedate;
	private String limitservice;
	@Temporal(TemporalType.TIMESTAMP)
	private Date processtime;
	private String narrative1;

	public Limitsoftblock() {
	}

	public Limitsoftblock(BigDecimal id) {
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

	public String getFacilityid() {
		return facilityid;
	}

	public void setFacilityid(String facilityid) {
		this.facilityid = facilityid;
	}

	public String getReservationid() {
		return reservationid;
	}

	public void setReservationid(String reservationid) {
		this.reservationid = reservationid;
	}

	public String getTranamount() {
		return tranamount;
	}

	public void setTranamount(String tranamount) {
		this.tranamount = tranamount;
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

	public String getLimitumlamount() {
		return limitumlamount;
	}

	public void setLimitumlamount(String limitumlamount) {
		this.limitumlamount = limitumlamount;
	}

	public String getLimitumlcurrency() {
		return limitumlcurrency;
	}

	public void setLimitumlcurrency(String limitumlcurrency) {
		this.limitumlcurrency = limitumlcurrency;
	}

	public String getLimitumlflag() {
		return limitumlflag;
	}

	public void setLimitumlflag(String limitumlflag) {
		this.limitumlflag = limitumlflag;
	}

	public Date getValuedate() {
		return valuedate;
	}

	public void setValuedate(Date valuedate) {
		this.valuedate = valuedate;
	}

	public String getLimitservice() {
		return limitservice;
	}

	public void setLimitservice(String limitservice) {
		this.limitservice = limitservice;
	}

	public Date getProcesstime() {
		return processtime;
	}

	public void setProcesstime(Date processtime) {
		this.processtime = processtime;
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
		if (!(object instanceof Limitsoftblock)) {
			return false;
		}
		Limitsoftblock other = (Limitsoftblock) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bs.themebridge.entity.model.Limitsoftblock[ id=" + id + " ]";
	}

}
