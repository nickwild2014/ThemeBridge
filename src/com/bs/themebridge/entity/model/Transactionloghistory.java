/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.themebridge.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
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
// @Table(name = "TRANSACTIONLOGHISTORY", catalog = "", schema = "THEMEBRIDGE")
@Table(name = "TRANSACTIONLOGHISTORY")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Transactionloghistory.findAll", query = "SELECT t FROM Transactionloghistory t"),
		@NamedQuery(name = "Transactionloghistory.findById", query = "SELECT t FROM Transactionloghistory t WHERE t.id = :id"),
		@NamedQuery(name = "Transactionloghistory.findByTransactionlogid", query = "SELECT t FROM Transactionloghistory t WHERE t.transactionlogid = :transactionlogid"),
		@NamedQuery(name = "Transactionloghistory.findByService", query = "SELECT t FROM Transactionloghistory t WHERE t.service = :service"),
		@NamedQuery(name = "Transactionloghistory.findByOperation", query = "SELECT t FROM Transactionloghistory t WHERE t.operation = :operation"),
		@NamedQuery(name = "Transactionloghistory.findByZone", query = "SELECT t FROM Transactionloghistory t WHERE t.zone = :zone"),
		@NamedQuery(name = "Transactionloghistory.findByBranch", query = "SELECT t FROM Transactionloghistory t WHERE t.branch = :branch"),
		@NamedQuery(name = "Transactionloghistory.findBySourcesystem", query = "SELECT t FROM Transactionloghistory t WHERE t.sourcesystem = :sourcesystem"),
		@NamedQuery(name = "Transactionloghistory.findByTargetsystem", query = "SELECT t FROM Transactionloghistory t WHERE t.targetsystem = :targetsystem"),
		@NamedQuery(name = "Transactionloghistory.findByMasterreference", query = "SELECT t FROM Transactionloghistory t WHERE t.masterreference = :masterreference"),
		@NamedQuery(name = "Transactionloghistory.findByEventreference", query = "SELECT t FROM Transactionloghistory t WHERE t.eventreference = :eventreference"),
		@NamedQuery(name = "Transactionloghistory.findByStatus", query = "SELECT t FROM Transactionloghistory t WHERE t.status = :status"),
		@NamedQuery(name = "Transactionloghistory.findByProcesstime", query = "SELECT t FROM Transactionloghistory t WHERE t.processtime = :processtime"),
		@NamedQuery(name = "Transactionloghistory.findByTireqtime", query = "SELECT t FROM Transactionloghistory t WHERE t.tireqtime = :tireqtime"),
		@NamedQuery(name = "Transactionloghistory.findByBankreqtime", query = "SELECT t FROM Transactionloghistory t WHERE t.bankreqtime = :bankreqtime"),
		@NamedQuery(name = "Transactionloghistory.findByBankrestime", query = "SELECT t FROM Transactionloghistory t WHERE t.bankrestime = :bankrestime"),
		@NamedQuery(name = "Transactionloghistory.findByTirestime", query = "SELECT t FROM Transactionloghistory t WHERE t.tirestime = :tirestime"),
		@NamedQuery(name = "Transactionloghistory.findByServicekey1", query = "SELECT t FROM Transactionloghistory t WHERE t.servicekey1 = :servicekey1"),
		@NamedQuery(name = "Transactionloghistory.findByStatickey1", query = "SELECT t FROM Transactionloghistory t WHERE t.statickey1 = :statickey1"),
		@NamedQuery(name = "Transactionloghistory.findByNarrative1", query = "SELECT t FROM Transactionloghistory t WHERE t.narrative1 = :narrative1"),
		@NamedQuery(name = "Transactionloghistory.findByNarrative2", query = "SELECT t FROM Transactionloghistory t WHERE t.narrative2 = :narrative2"),
		@NamedQuery(name = "Transactionloghistory.findByIsresubmitted", query = "SELECT t FROM Transactionloghistory t WHERE t.isresubmitted = :isresubmitted"),
		@NamedQuery(name = "Transactionloghistory.findByResubmittedcount", query = "SELECT t FROM Transactionloghistory t WHERE t.resubmittedcount = :resubmittedcount"),
		@NamedQuery(name = "Transactionloghistory.findByResubmittedtime", query = "SELECT t FROM Transactionloghistory t WHERE t.resubmittedtime = :resubmittedtime"),
		@NamedQuery(name = "Transactionloghistory.findByTypeflag", query = "SELECT t FROM Transactionloghistory t WHERE t.typeflag = :typeflag") })
public class Transactionloghistory implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRHSEQ")
	@SequenceGenerator(name = "TRHSEQ", sequenceName = "TRANSACTIONLOGHISTORY_SEQ", allocationSize = 1)
	private BigDecimal id;
	@Basic(optional = false)
	@Column(name = "TRANSACTIONLOGID")
	private BigInteger transactionlogid;
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
	@Column(name = "SERVICEKEY1")
	private String servicekey1;
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

	public Transactionloghistory() {
	}

	public Transactionloghistory(BigDecimal id) {
		this.id = id;
	}

	public Transactionloghistory(BigDecimal id, BigInteger transactionlogid) {
		this.id = id;
		this.transactionlogid = transactionlogid;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigInteger getTransactionlogid() {
		return transactionlogid;
	}

	public void setTransactionlogid(BigInteger transactionlogid) {
		this.transactionlogid = transactionlogid;
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

	public String getServicekey1() {
		return servicekey1;
	}

	public void setServicekey1(String servicekey1) {
		this.servicekey1 = servicekey1;
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
		if (!(object instanceof Transactionloghistory)) {
			return false;
		}
		Transactionloghistory other = (Transactionloghistory) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bs.themebridge.entity.model.Transactionloghistory[ id=" + id + " ]";
	}

}
