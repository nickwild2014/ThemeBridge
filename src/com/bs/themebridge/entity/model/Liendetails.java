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
@NamedQueries({ @NamedQuery(name = "Liendetails.findAll", query = "SELECT l FROM Liendetails l"),
		@NamedQuery(name = "Liendetails.findById", query = "SELECT l FROM Liendetails l WHERE l.id = :id"),
		@NamedQuery(name = "Liendetails.findByMasterreference", query = "SELECT l FROM Liendetails l WHERE l.masterreference = :masterreference"),
		@NamedQuery(name = "Liendetails.findByEventreference", query = "SELECT l FROM Liendetails l WHERE l.eventreference = :eventreference"),
		@NamedQuery(name = "Liendetails.findByAccountid", query = "SELECT l FROM Liendetails l WHERE l.accountid = :accountid"),
		@NamedQuery(name = "Liendetails.findByTranamount", query = "SELECT l FROM Liendetails l WHERE l.tranamount = :tranamount"),
		@NamedQuery(name = "Liendetails.findByRate", query = "SELECT l FROM Liendetails l WHERE l.rate = :rate"),
		@NamedQuery(name = "Liendetails.findByLienamount", query = "SELECT l FROM Liendetails l WHERE l.lienamount = :lienamount"),
		@NamedQuery(name = "Liendetails.findByRemarks", query = "SELECT l FROM Liendetails l WHERE l.remarks = :remarks"),
		@NamedQuery(name = "Liendetails.findByLien", query = "SELECT l FROM Liendetails l WHERE l.lien = :lien"),
		@NamedQuery(name = "Liendetails.findByLienid", query = "SELECT l FROM Liendetails l WHERE l.lienid = :lienid"),
		@NamedQuery(name = "Liendetails.findByProcesstime", query = "SELECT l FROM Liendetails l WHERE l.processtime = :processtime") })
public class Liendetails implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(nullable = false, precision = 20, scale = 0)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LSEQ")
	@SequenceGenerator(name = "LSEQ", sequenceName = "LIENDETAILS_SEQ", allocationSize = 1)
	private BigDecimal id;
	@Column(length = 20)
	private String masterreference;
	@Column(length = 10)
	private String eventreference;
	@Column(length = 20)
	private String accountid;
	@Column(length = 40)
	private String tranamount;
	@Column(length = 8)
	private String rate;
	@Column(length = 40)
	private String lienamount;
	@Column(length = 20)
	private String remarks;
	@Column(length = 1)
	private String lien;
	@Column(length = 15)
	private String lienid;
	@Temporal(TemporalType.TIMESTAMP)
	private Date processtime;

	public Liendetails() {
	}

	public Liendetails(BigDecimal id) {
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

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public String getTranamount() {
		return tranamount;
	}

	public void setTranamount(String tranamount) {
		this.tranamount = tranamount;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getLienamount() {
		return lienamount;
	}

	public void setLienamount(String lienamount) {
		this.lienamount = lienamount;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getLien() {
		return lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}

	public String getLienid() {
		return lienid;
	}

	public void setLienid(String lienid) {
		this.lienid = lienid;
	}

	public Date getProcesstime() {
		return processtime;
	}

	public void setProcesstime(Date processtime) {
		this.processtime = processtime;
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
		if (!(object instanceof Liendetails)) {
			return false;
		}
		Liendetails other = (Liendetails) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication2.Liendetails[ id=" + id + " ]";
	}

}
