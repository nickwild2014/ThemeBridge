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
// @Table(name = "NOTIFICATIONSLOG", catalog = "", schema = "THEMEBRIDGE")
@Table(name = "NOTIFICATIONSLOG")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Notificationslog.findAll", query = "SELECT n FROM Notificationslog n"),
		@NamedQuery(name = "Notificationslog.findById", query = "SELECT n FROM Notificationslog n WHERE n.id = :id"),
		@NamedQuery(name = "Notificationslog.findByService", query = "SELECT n FROM Notificationslog n WHERE n.service = :service"),
		@NamedQuery(name = "Notificationslog.findByOperation", query = "SELECT n FROM Notificationslog n WHERE n.operation = :operation"),
		@NamedQuery(name = "Notificationslog.findByZone", query = "SELECT n FROM Notificationslog n WHERE n.zone = :zone"),
		@NamedQuery(name = "Notificationslog.findByBranch", query = "SELECT n FROM Notificationslog n WHERE n.branch = :branch"),
		@NamedQuery(name = "Notificationslog.findBySourcesystem", query = "SELECT n FROM Notificationslog n WHERE n.sourcesystem = :sourcesystem"),
		@NamedQuery(name = "Notificationslog.findByTargetsystem", query = "SELECT n FROM Notificationslog n WHERE n.targetsystem = :targetsystem"),
		@NamedQuery(name = "Notificationslog.findByMasterreference", query = "SELECT n FROM Notificationslog n WHERE n.masterreference = :masterreference"),
		@NamedQuery(name = "Notificationslog.findByEventreference", query = "SELECT n FROM Notificationslog n WHERE n.eventreference = :eventreference"),
		@NamedQuery(name = "Notificationslog.findByStatus", query = "SELECT n FROM Notificationslog n WHERE n.status = :status"),
		@NamedQuery(name = "Notificationslog.findByProcesstime", query = "SELECT n FROM Notificationslog n WHERE n.processtime = :processtime"),
		@NamedQuery(name = "Notificationslog.findByTireqtime", query = "SELECT n FROM Notificationslog n WHERE n.tireqtime = :tireqtime"),
		@NamedQuery(name = "Notificationslog.findByBankreqtime", query = "SELECT n FROM Notificationslog n WHERE n.bankreqtime = :bankreqtime"),
		@NamedQuery(name = "Notificationslog.findByBankrestime", query = "SELECT n FROM Notificationslog n WHERE n.bankrestime = :bankrestime"),
		@NamedQuery(name = "Notificationslog.findByTirestime", query = "SELECT n FROM Notificationslog n WHERE n.tirestime = :tirestime"),
		@NamedQuery(name = "Notificationslog.findByServicekey1", query = "SELECT n FROM Notificationslog n WHERE n.servicekey1 = :servicekey1"),
		@NamedQuery(name = "Notificationslog.findByTransactionkey1", query = "SELECT n FROM Notificationslog n WHERE n.transactionkey1 = :transactionkey1"),
		@NamedQuery(name = "Notificationslog.findByStatickey1", query = "SELECT n FROM Notificationslog n WHERE n.statickey1 = :statickey1"),
		@NamedQuery(name = "Notificationslog.findByNarrative1", query = "SELECT n FROM Notificationslog n WHERE n.narrative1 = :narrative1"),
		@NamedQuery(name = "Notificationslog.findByNarrative2", query = "SELECT n FROM Notificationslog n WHERE n.narrative2 = :narrative2"),
		@NamedQuery(name = "Notificationslog.findByNarrative3", query = "SELECT n FROM Notificationslog n WHERE n.narrative3 = :narrative3"),
		@NamedQuery(name = "Notificationslog.findByNarrative4", query = "SELECT n FROM Notificationslog n WHERE n.narrative4 = :narrative4"),
		@NamedQuery(name = "Notificationslog.findByIsresubmitted", query = "SELECT n FROM Notificationslog n WHERE n.isresubmitted = :isresubmitted"),
		@NamedQuery(name = "Notificationslog.findByResubmittedcount", query = "SELECT n FROM Notificationslog n WHERE n.resubmittedcount = :resubmittedcount"),
		@NamedQuery(name = "Notificationslog.findByResubmittedtime", query = "SELECT n FROM Notificationslog n WHERE n.resubmittedtime = :resubmittedtime"),
		@NamedQuery(name = "Notificationslog.findByTypeflag", query = "SELECT n FROM Notificationslog n WHERE n.typeflag = :typeflag") })
public class Notificationslog implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "NOTSEQ")
	@SequenceGenerator(name = "NOTSEQ", sequenceName = "NOTIFICATIONSLOG_SEQ", allocationSize = 1)
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
	@Column(name = "SERVICEKEY1")
	private String servicekey1;
	@Column(name = "TRANSACTIONKEY1")
	private String transactionkey1;
	@Column(name = "STATICKEY1")
	private String statickey1;
	@Column(name = "NARRATIVE1")
	private String narrative1;
	@Column(name = "NARRATIVE2")
	private String narrative2;
	@Column(name = "NARRATIVE3")
	private String narrative3;
	@Column(name = "NARRATIVE4")
	private String narrative4;
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

	public Notificationslog() {
	}

	public Notificationslog(BigDecimal id) {
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

	public String getServicekey1() {
		return servicekey1;
	}

	public void setServicekey1(String servicekey1) {
		this.servicekey1 = servicekey1;
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

	public String getNarrative3() {
		return narrative3;
	}

	public void setNarrative3(String narrative3) {
		this.narrative3 = narrative3;
	}

	public String getNarrative4() {
		return narrative4;
	}

	public void setNarrative4(String narrative4) {
		this.narrative4 = narrative4;
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
		if (!(object instanceof Notificationslog)) {
			return false;
		}
		Notificationslog other = (Notificationslog) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication1.Notificationslog[ id=" + id + " ]";
	}

}
