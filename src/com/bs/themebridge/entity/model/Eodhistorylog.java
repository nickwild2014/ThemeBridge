/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.themebridge.entity.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BSIT012
 */
@Entity
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Eodhistorylog.findAll", query = "SELECT e FROM Eodhistorylog e"),
		@NamedQuery(name = "Eodhistorylog.findById", query = "SELECT e FROM Eodhistorylog e WHERE e.id = :id"),
		@NamedQuery(name = "Eodhistorylog.findByEoddate", query = "SELECT e FROM Eodhistorylog e WHERE e.eoddate = :eoddate"),
		@NamedQuery(name = "Eodhistorylog.findBySoddate", query = "SELECT e FROM Eodhistorylog e WHERE e.soddate = :soddate"),
		@NamedQuery(name = "Eodhistorylog.findByProcesstime", query = "SELECT e FROM Eodhistorylog e WHERE e.processtime = :processtime") })
public class Eodhistorylog implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	private String id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date eoddate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date soddate;
	@Temporal(TemporalType.TIMESTAMP)
	private Date processtime;

	public Eodhistorylog() {
	}

	public Eodhistorylog(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getEoddate() {
		return eoddate;
	}

	public void setEoddate(Date eoddate) {
		this.eoddate = eoddate;
	}

	public Date getSoddate() {
		return soddate;
	}

	public void setSoddate(Date soddate) {
		this.soddate = soddate;
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
		if (!(object instanceof Eodhistorylog)) {
			return false;
		}
		Eodhistorylog other = (Eodhistorylog) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bs.themebridge.entity.model.Eodhistorylog[ id=" + id + " ]";
	}

}
