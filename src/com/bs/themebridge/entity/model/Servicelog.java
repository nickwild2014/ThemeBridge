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
// @Table(name = "SERVICELOG", catalog = "", schema = "THEMEBRIDGE")
@Table(name = "SERVICELOG")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Servicelog.findAll", query = "SELECT s FROM Servicelog s"),
		@NamedQuery(name = "Servicelog.findById", query = "SELECT s FROM Servicelog s WHERE s.id = :id"),
		@NamedQuery(name = "Servicelog.findByService", query = "SELECT s FROM Servicelog s WHERE s.service = :service"),
		@NamedQuery(name = "Servicelog.findByOperation", query = "SELECT s FROM Servicelog s WHERE s.operation = :operation"),
		@NamedQuery(name = "Servicelog.findByZone", query = "SELECT s FROM Servicelog s WHERE s.zone = :zone"),
		@NamedQuery(name = "Servicelog.findByBranch", query = "SELECT s FROM Servicelog s WHERE s.branch = :branch"),
		@NamedQuery(name = "Servicelog.findBySourcesystem", query = "SELECT s FROM Servicelog s WHERE s.sourcesystem = :sourcesystem"),
		@NamedQuery(name = "Servicelog.findByTargetsystem", query = "SELECT s FROM Servicelog s WHERE s.targetsystem = :targetsystem"),
		@NamedQuery(name = "Servicelog.findByMasterreference", query = "SELECT s FROM Servicelog s WHERE s.masterreference = :masterreference"),
		@NamedQuery(name = "Servicelog.findByEventreference", query = "SELECT s FROM Servicelog s WHERE s.eventreference = :eventreference"),
		@NamedQuery(name = "Servicelog.findByStatus", query = "SELECT s FROM Servicelog s WHERE s.status = :status"),
		@NamedQuery(name = "Servicelog.findByProcesstime", query = "SELECT s FROM Servicelog s WHERE s.processtime = :processtime"),
		@NamedQuery(name = "Servicelog.findByTireqtime", query = "SELECT s FROM Servicelog s WHERE s.tireqtime = :tireqtime"),
		@NamedQuery(name = "Servicelog.findByBankreqtime", query = "SELECT s FROM Servicelog s WHERE s.bankreqtime = :bankreqtime"),
		@NamedQuery(name = "Servicelog.findByBankrestime", query = "SELECT s FROM Servicelog s WHERE s.bankrestime = :bankrestime"),
		@NamedQuery(name = "Servicelog.findByTirestime", query = "SELECT s FROM Servicelog s WHERE s.tirestime = :tirestime"),
		@NamedQuery(name = "Servicelog.findByTransactionkey1", query = "SELECT s FROM Servicelog s WHERE s.transactionkey1 = :transactionkey1"),
		@NamedQuery(name = "Servicelog.findByStatickey1", query = "SELECT s FROM Servicelog s WHERE s.statickey1 = :statickey1"),
		@NamedQuery(name = "Servicelog.findByNarrative1", query = "SELECT s FROM Servicelog s WHERE s.narrative1 = :narrative1"),
		@NamedQuery(name = "Servicelog.findByNarrative2", query = "SELECT s FROM Servicelog s WHERE s.narrative2 = :narrative2"),
		@NamedQuery(name = "Servicelog.findByIsresubmitted", query = "SELECT s FROM Servicelog s WHERE s.isresubmitted = :isresubmitted"),
		@NamedQuery(name = "Servicelog.findByResubmittedcount", query = "SELECT s FROM Servicelog s WHERE s.resubmittedcount = :resubmittedcount"),
		@NamedQuery(name = "Servicelog.findByResubmittedtime", query = "SELECT s FROM Servicelog s WHERE s.resubmittedtime = :resubmittedtime"),
		@NamedQuery(name = "Servicelog.findByTypeflag", query = "SELECT s FROM Servicelog s WHERE s.typeflag = :typeflag") })
public class Servicelog implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SERSEQ")
	@SequenceGenerator(name = "SERSEQ", sequenceName = "SERVICELOG_SEQ", allocationSize = 1)
	private BigDecimal id;
	@Column(name = "SERVICE")
	private String service;
	@Column(name = "OPERATION")
	private String operation;
	@Column(name = "ZONE")
	private String zone;
	@Column(name = "BRANCH")
	private String branch;
	@Column(name = "SOURCESYSTEM")
	private String sourcesystem;
	@Column(name = "TARGETSYSTEM")
	private String targetsystem;
	@Column(name = "MASTERREFERENCE")
	private String masterreference;
	@Column(name = "EVENTREFERENCE")
	private String eventreference;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "PROCESSTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date processtime;
	@Lob
	@Column(name = "TIREQUEST")
	private String tirequest;
	@Lob
	@Column(name = "TIRESPONSE")
	private String tiresponse;
	@Lob
	@Column(name = "BANKREQUEST")
	private String bankrequest;
	@Lob
	@Column(name = "BANKRESPONSE")
	private String bankresponse;
	@Column(name = "TIREQTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tireqtime;
	@Column(name = "BANKREQTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date bankreqtime;
	@Column(name = "BANKRESTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date bankrestime;
	@Column(name = "TIRESTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date tirestime;
	@Column(name = "TRANSACTIONKEY1")
	private String transactionkey1;
	@Column(name = "STATICKEY1")
	private String statickey1;
	@Column(name = "NARRATIVE1")
	private String narrative1;
	@Column(name = "NARRATIVE2")
	private String narrative2;
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

	public Servicelog() {
	}

	public Servicelog(BigDecimal id) {
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getProcesstime() {
		return processtime;
	}

	public void setProcesstime(Date processtime) {
		this.processtime = processtime;
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

	public String getBankrequest() {
		return bankrequest;
	}

	public void setBankrequest(String bankrequest) {
		this.bankrequest = bankrequest;
	}

	public String getBankresponse() {
		return bankresponse;
	}

	public void setBankresponse(String bankresponse) {
		this.bankresponse = bankresponse;
	}

	public Date getTireqtime() {
		return tireqtime;
	}

	public void setTireqtime(Date tireqtime) {
		this.tireqtime = tireqtime;
	}

	public Date getBankreqtime() {
		return bankreqtime;
	}

	public void setBankreqtime(Date bankreqtime) {
		this.bankreqtime = bankreqtime;
	}

	public Date getBankrestime() {
		return bankrestime;
	}

	public void setBankrestime(Date bankrestime) {
		this.bankrestime = bankrestime;
	}

	public Date getTirestime() {
		return tirestime;
	}

	public void setTirestime(Date tirestime) {
		this.tirestime = tirestime;
	}

	public String getTransactionkey1() {
		return transactionkey1;
	}

	public void setTransactionkey1(String transactionkey1) {
		this.transactionkey1 = transactionkey1;
	}

	public String getStatickey1() {
		return statickey1;
	}

	public void setStatickey1(String statickey1) {
		this.statickey1 = statickey1;
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
		if (!(object instanceof Servicelog)) {
			return false;
		}
		Servicelog other = (Servicelog) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bs.themebridge.entity.model.Servicelog[ id=" + id + " ]";
	}

}
