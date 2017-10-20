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
 * @author BSIT012
 */
@Entity
@Table(name = "SFMS_FRIENDLY_FORMATE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "SfmsFriendlyFormate.findAll", query = "SELECT s FROM SfmsFriendlyFormate s"),
		@NamedQuery(name = "SfmsFriendlyFormate.findById", query = "SELECT s FROM SfmsFriendlyFormate s WHERE s.id = :id"),
		@NamedQuery(name = "SfmsFriendlyFormate.findByService", query = "SELECT s FROM SfmsFriendlyFormate s WHERE s.service = :service"),
		@NamedQuery(name = "SfmsFriendlyFormate.findByOperation", query = "SELECT s FROM SfmsFriendlyFormate s WHERE s.operation = :operation"),
		@NamedQuery(name = "SfmsFriendlyFormate.findByMessagetype", query = "SELECT s FROM SfmsFriendlyFormate s WHERE s.messagetype = :messagetype"),
		@NamedQuery(name = "SfmsFriendlyFormate.findBySfmsissuedate", query = "SELECT s FROM SfmsFriendlyFormate s WHERE s.sfmsissuedate = :sfmsissuedate"),
		@NamedQuery(name = "SfmsFriendlyFormate.findByMasterRef", query = "SELECT s FROM SfmsFriendlyFormate s WHERE s.masterRef = :masterRef"),
		@NamedQuery(name = "SfmsFriendlyFormate.findByDateDescription", query = "SELECT s FROM SfmsFriendlyFormate s WHERE s.dateDescription = :dateDescription"),
		@NamedQuery(name = "SfmsFriendlyFormate.findByStatus", query = "SELECT s FROM SfmsFriendlyFormate s WHERE s.status = :status") })
public class SfmsFriendlyFormate implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SFMSINSEQ")
	@SequenceGenerator(name = "SFMSINSEQ", sequenceName = "SFMSINCOMINGLOG_SEQ", allocationSize = 1)
	private BigDecimal id;
	private String service;
	private String operation;
	private String messagetype;
	@Temporal(TemporalType.TIMESTAMP)
	private Date sfmsissuedate;
	// @Lob
	@Column(name = "SFMSIN_FRND_FORMATE")
	private String sfmsinFrndFormate;
	// @Lob
	@Column(name = "SFMSIN_FRND_FORMATE_TO_TI")
	private String sfmsinFrndFormateToTi;
	@Column(name = "MASTER_REF")
	private String masterRef;
	@Column(name = "DATE_DESCRIPTION")
	private String dateDescription;
	private String status;

	public SfmsFriendlyFormate() {
	}

	public SfmsFriendlyFormate(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getService() {
		return service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getMessagetype() {
		return messagetype;
	}

	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}

	public Date getSfmsissuedate() {
		return sfmsissuedate;
	}

	public void setSfmsissuedate(Date sfmsissuedate) {
		this.sfmsissuedate = sfmsissuedate;
	}

	public String getSfmsinFrndFormate() {
		return sfmsinFrndFormate;
	}

	public void setSfmsinFrndFormate(String sfmsinFrndFormate) {
		this.sfmsinFrndFormate = sfmsinFrndFormate;
	}

	public String getSfmsinFrndFormateToTi() {
		return sfmsinFrndFormateToTi;
	}

	public void setSfmsinFrndFormateToTi(String sfmsinFrndFormateToTi) {
		this.sfmsinFrndFormateToTi = sfmsinFrndFormateToTi;
	}

	public String getMasterRef() {
		return masterRef;
	}

	public void setMasterRef(String masterRef) {
		this.masterRef = masterRef;
	}

	public String getDateDescription() {
		return dateDescription;
	}

	public void setDateDescription(String dateDescription) {
		this.dateDescription = dateDescription;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
		if (!(object instanceof SfmsFriendlyFormate)) {
			return false;
		}
		SfmsFriendlyFormate other = (SfmsFriendlyFormate) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bs.themebridge.entity.model.SfmsFriendlyFormate[ id=" + id + " ]";
	}

}
