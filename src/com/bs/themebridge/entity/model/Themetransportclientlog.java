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
// @Table(name = "THEMETRANSPORTCLIENTLOG", catalog = "", schema =
// "THEMEBRIDGE")
@Table(name = "THEMETRANSPORTCLIENTLOG")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Themetransportclientlog.findAll", query = "SELECT t FROM Themetransportclientlog t"),
		@NamedQuery(name = "Themetransportclientlog.findById", query = "SELECT t FROM Themetransportclientlog t WHERE t.id = :id"),
		@NamedQuery(name = "Themetransportclientlog.findByService", query = "SELECT t FROM Themetransportclientlog t WHERE t.service = :service"),
		@NamedQuery(name = "Themetransportclientlog.findByOperation", query = "SELECT t FROM Themetransportclientlog t WHERE t.operation = :operation"),
		@NamedQuery(name = "Themetransportclientlog.findByStatus", query = "SELECT t FROM Themetransportclientlog t WHERE t.status = :status"),
		@NamedQuery(name = "Themetransportclientlog.findByReceivedtime", query = "SELECT t FROM Themetransportclientlog t WHERE t.receivedtime = :receivedtime"),
		@NamedQuery(name = "Themetransportclientlog.findByProcesstime", query = "SELECT t FROM Themetransportclientlog t WHERE t.processtime = :processtime") })
public class Themetransportclientlog implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TTCSEQ")
	@SequenceGenerator(name = "TTCSEQ", sequenceName = "THEMETRANSPORTCLIENTLOG_SEQ", allocationSize = 1)
	private BigDecimal id;
	@Column(name = "SERVICE")
	private String service;
	@Column(name = "OPERATION")
	private String operation;
	@Column(name = "STATUS")
	private String status;
	@Column(name = "RECEIVEDTIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date receivedtime;
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
	@Column(name = "DESCRIPTION")
	private String description;

	public Themetransportclientlog() {
	}

	public Themetransportclientlog(BigDecimal id) {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
		if (!(object instanceof Themetransportclientlog)) {
			return false;
		}
		Themetransportclientlog other = (Themetransportclientlog) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication1.Themetransportclientlog[ id=" + id + " ]";
	}

}
