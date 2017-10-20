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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BSIT012
 */
@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Postingstaging.findAll", query = "SELECT p FROM Postingstaging p"),
		@NamedQuery(name = "Postingstaging.findById", query = "SELECT p FROM Postingstaging p WHERE p.id = :id"),
		@NamedQuery(name = "Postingstaging.findByService", query = "SELECT p FROM Postingstaging p WHERE p.service = :service"),
		@NamedQuery(name = "Postingstaging.findByOperation", query = "SELECT p FROM Postingstaging p WHERE p.operation = :operation"),
		@NamedQuery(name = "Postingstaging.findByZone", query = "SELECT p FROM Postingstaging p WHERE p.zone = :zone"),
		@NamedQuery(name = "Postingstaging.findByBranch", query = "SELECT p FROM Postingstaging p WHERE p.branch = :branch"),
		@NamedQuery(name = "Postingstaging.findBySourcesystem", query = "SELECT p FROM Postingstaging p WHERE p.sourcesystem = :sourcesystem"),
		@NamedQuery(name = "Postingstaging.findByTargetsystem", query = "SELECT p FROM Postingstaging p WHERE p.targetsystem = :targetsystem"),
		@NamedQuery(name = "Postingstaging.findByMasterreference", query = "SELECT p FROM Postingstaging p WHERE p.masterreference = :masterreference"),
		@NamedQuery(name = "Postingstaging.findByEventreference", query = "SELECT p FROM Postingstaging p WHERE p.eventreference = :eventreference"),
		@NamedQuery(name = "Postingstaging.findByStatus", query = "SELECT p FROM Postingstaging p WHERE p.status = :status"),
		@NamedQuery(name = "Postingstaging.findByProcesstime", query = "SELECT p FROM Postingstaging p WHERE p.processtime = :processtime"),
		@NamedQuery(name = "Postingstaging.findByTireqtime", query = "SELECT p FROM Postingstaging p WHERE p.tireqtime = :tireqtime"),
		@NamedQuery(name = "Postingstaging.findByTirestime", query = "SELECT p FROM Postingstaging p WHERE p.tirestime = :tirestime"),
		@NamedQuery(name = "Postingstaging.findByNarrative1", query = "SELECT p FROM Postingstaging p WHERE p.narrative1 = :narrative1") })
public class Postingstaging implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@NotNull
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "POSTINGSTAGING")
	@SequenceGenerator(name = "POSTINGSTAGING", sequenceName = "POSTINGSTAGING_SEQ", allocationSize = 1)
	private BigDecimal id;
	private String service;
	private String operation;
	private String zone;
	private String branch;
	private String sourcesystem;
	private String targetsystem;
	private String masterreference;
	private String eventreference;
	private String status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date processtime;
	@Lob
	private String tirequest;
	@Lob
	private String tiresponse;
	@Temporal(TemporalType.TIMESTAMP)
	private Date tireqtime;
	@Temporal(TemporalType.TIMESTAMP)
	private Date tirestime;
	private String narrative1;

	public Postingstaging() {
	}

	public Postingstaging(BigDecimal id) {
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

	public Date getTireqtime() {
		return tireqtime;
	}

	public void setTireqtime(Date tireqtime) {
		this.tireqtime = tireqtime;
	}

	public Date getTirestime() {
		return tirestime;
	}

	public void setTirestime(Date tirestime) {
		this.tirestime = tirestime;
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
		if (!(object instanceof Postingstaging)) {
			return false;
		}
		Postingstaging other = (Postingstaging) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bs.themebridge.entity.model.Postingstaging[ id=" + id + " ]";
	}

}
