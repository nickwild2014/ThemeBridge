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
import javax.persistence.Lob;
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
// @Table(name = "STATICDATALOG", catalog = "", schema = "THEMEBRIDGE")
@Table(name = "STATICDATALOG")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Staticdatalog.findAll", query = "SELECT s FROM Staticdatalog s"),
		@NamedQuery(name = "Staticdatalog.findById", query = "SELECT s FROM Staticdatalog s WHERE s.id = :id"),
		@NamedQuery(name = "Staticdatalog.findByService", query = "SELECT s FROM Staticdatalog s WHERE s.service = :service"),
		@NamedQuery(name = "Staticdatalog.findByEntitytype", query = "SELECT s FROM Staticdatalog s WHERE s.entitytype = :entitytype"),
		@NamedQuery(name = "Staticdatalog.findByZone", query = "SELECT s FROM Staticdatalog s WHERE s.zone = :zone"),
		@NamedQuery(name = "Staticdatalog.findByBranch", query = "SELECT s FROM Staticdatalog s WHERE s.branch = :branch"),
		@NamedQuery(name = "Staticdatalog.findBySourcesystem", query = "SELECT s FROM Staticdatalog s WHERE s.sourcesystem = :sourcesystem"),
		@NamedQuery(name = "Staticdatalog.findByTargetsystem", query = "SELECT s FROM Staticdatalog s WHERE s.targetsystem = :targetsystem"),
		// @NamedQuery(name = "Staticdatalog.findByMasterreference", query =
		// "SELECT s FROM Staticdatalog s WHERE s.masterreference =
		// :masterreference"),
		// @NamedQuery(name = "Staticdatalog.findByEventreference", query =
		// "SELECT s FROM Staticdatalog s WHERE s.eventreference =
		// :eventreference"),
		@NamedQuery(name = "Staticdatalog.findByStatus", query = "SELECT s FROM Staticdatalog s WHERE s.status = :status"),
		@NamedQuery(name = "Staticdatalog.findByReceivedtime", query = "SELECT s FROM Staticdatalog s WHERE s.receivedtime = :receivedtime"),
		@NamedQuery(name = "Staticdatalog.findByProcesstime", query = "SELECT s FROM Staticdatalog s WHERE s.processtime = :processtime"),
		@NamedQuery(name = "Staticdatalog.findByNarrative1", query = "SELECT s FROM Staticdatalog s WHERE s.narrative1 = :narrative1"),
		@NamedQuery(name = "Staticdatalog.findByNarrative2", query = "SELECT s FROM Staticdatalog s WHERE s.narrative2 = :narrative2"),
		@NamedQuery(name = "Staticdatalog.findByNarrative3", query = "SELECT s FROM Staticdatalog s WHERE s.narrative3 = :narrative3"),
		@NamedQuery(name = "Staticdatalog.findByIsresubmitted", query = "SELECT s FROM Staticdatalog s WHERE s.isresubmitted = :isresubmitted"),
		@NamedQuery(name = "Staticdatalog.findByResubmittedcount", query = "SELECT s FROM Staticdatalog s WHERE s.resubmittedcount = :resubmittedcount"),
		@NamedQuery(name = "Staticdatalog.findByResubmittedtime", query = "SELECT s FROM Staticdatalog s WHERE s.resubmittedtime = :resubmittedtime"),
		@NamedQuery(name = "Staticdatalog.findByTypeflag", query = "SELECT s FROM Staticdatalog s WHERE s.typeflag = :typeflag") })
public class Staticdatalog implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STDSEQ")
	@SequenceGenerator(name = "STDSEQ", sequenceName = "STATICDATALOG_SEQ", allocationSize = 1)
	private BigDecimal id;
	@Column(name = "SERVICE")
	private String service;
	@Column(name = "ENTITYTYPE")
	private String entitytype;
	@Column(name = "ZONE")
	private String zone;
	@Column(name = "BRANCH")
	private String branch;
	@Column(name = "SOURCESYSTEM")
	private String sourcesystem;
	@Column(name = "TARGETSYSTEM")
	private String targetsystem;
	// @Column(name = "MASTERREFERENCE")
	// private String masterreference;
	// @Column(name = "EVENTREFERENCE")
	// private String eventreference;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "RECEIVEDTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date receivedtime;
	@Column(name = "PROCESSTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date processtime;
	@Lob
	@Column(name = "INPUTMSG")
	private String inputmsg;
	@Lob
	@Column(name = "TIREQUEST")
	private String tirequest;
	@Lob
	@Column(name = "TIRESPONSE")
	private String tiresponse;
	@Column(name = "NARRATIVE1")
	private String narrative1;
	@Column(name = "NARRATIVE2")
	private String narrative2;
	@Column(name = "NARRATIVE3")
	private String narrative3;
	@Column(name = "ISRESUBMITTED")
	private Character isresubmitted;
	@Column(name = "RESUBMITTEDCOUNT")
	private Short resubmittedcount;
	@Column(name = "RESUBMITTEDTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date resubmittedtime;
	@Lob
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "TYPEFLAG")
	private Character typeflag;

	public Staticdatalog() {
	}

	public Staticdatalog(BigDecimal id) {
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

	public String getEntitytype() {
		return entitytype;
	}

	public void setEntitytype(String entitytype) {
		this.entitytype = entitytype;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSourcesystem() {
		return sourcesystem;
	}

	public void setSourcesystem(String sourcesystem) {
		this.sourcesystem = sourcesystem;
	}

	public String getTargetsystem() {
		return targetsystem;
	}

	public void setTargetsystem(String targetsystem) {
		this.targetsystem = targetsystem;
	}

	// public String getMasterreference() {
	// return masterreference;
	// }
	//
	// public void setMasterreference(String masterreference) {
	// this.masterreference = masterreference;
	// }
	//
	// public String getEventreference() {
	// return eventreference;
	// }
	//
	// public void setEventreference(String eventreference) {
	// this.eventreference = eventreference;
	// }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getReceivedtime() {
		return receivedtime;
	}

	public void setReceivedtime(Date receivedtime) {
		this.receivedtime = receivedtime;
	}

	public Date getProcesstime() {
		return processtime;
	}

	public void setProcesstime(Date processtime) {
		this.processtime = processtime;
	}

	public String getInputmsg() {
		return inputmsg;
	}

	public void setInputmsg(String inputmsg) {
		this.inputmsg = inputmsg;
	}

	public String getTirequest() {
		return tirequest;
	}

	public void setTirequest(String tirequest) {
		this.tirequest = tirequest;
	}

	public String getTiresponse() {
		return tiresponse;
	}

	public void setTiresponse(String tiresponse) {
		this.tiresponse = tiresponse;
	}

	public String getNarrative1() {
		return narrative1;
	}

	public void setNarrative1(String narrative1) {
		this.narrative1 = narrative1;
	}

	public String getNarrative2() {
		return narrative2;
	}

	public void setNarrative2(String narrative2) {
		this.narrative2 = narrative2;
	}

	public String getNarrative3() {
		return narrative3;
	}

	public void setNarrative3(String narrative3) {
		this.narrative3 = narrative3;
	}

	public Character getIsresubmitted() {
		return isresubmitted;
	}

	public void setIsresubmitted(Character isresubmitted) {
		this.isresubmitted = isresubmitted;
	}

	public Short getResubmittedcount() {
		return resubmittedcount;
	}

	public void setResubmittedcount(Short resubmittedcount) {
		this.resubmittedcount = resubmittedcount;
	}

	public Date getResubmittedtime() {
		return resubmittedtime;
	}

	public void setResubmittedtime(Date resubmittedtime) {
		this.resubmittedtime = resubmittedtime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Character getTypeflag() {
		return typeflag;
	}

	public void setTypeflag(Character typeflag) {
		this.typeflag = typeflag;
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
		if (!(object instanceof Staticdatalog)) {
			return false;
		}
		Staticdatalog other = (Staticdatalog) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bs.themebridge.entity.model.Staticdatalog[ id=" + id + " ]";
	}

}
