/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.themebridge.entity.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BSIT012
 */
@Entity
@Table(name = "LOOKUP_FINACLE_ERROR_CODE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LookupFinacleErrorCode.findAll", query = "SELECT l FROM LookupFinacleErrorCode l"),
		@NamedQuery(name = "LookupFinacleErrorCode.findById", query = "SELECT l FROM LookupFinacleErrorCode l WHERE l.id = :id"),
		@NamedQuery(name = "LookupFinacleErrorCode.findByZone", query = "SELECT l FROM LookupFinacleErrorCode l WHERE l.zone = :zone"),
		@NamedQuery(name = "LookupFinacleErrorCode.findByErrorcode", query = "SELECT l FROM LookupFinacleErrorCode l WHERE l.errorcode = :errorcode"),
		@NamedQuery(name = "LookupFinacleErrorCode.findByDescription", query = "SELECT l FROM LookupFinacleErrorCode l WHERE l.description = :description"),
		@NamedQuery(name = "LookupFinacleErrorCode.findByDisplayflag", query = "SELECT l FROM LookupFinacleErrorCode l WHERE l.displayflag = :displayflag") })

public class LookupFinacleErrorCode implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "ID")
	private String id;
	@Column(name = "ZONE")
	private String zone;
	@Id
	@Basic(optional = false)
	@Column(name = "ERRORCODE")
	private String errorcode;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "DISPLAYFLAG")
	private String displayflag;

	public LookupFinacleErrorCode() {
	}

	public LookupFinacleErrorCode(String errorcode) {
		this.errorcode = errorcode;
	}

	public LookupFinacleErrorCode(String errorcode, String id) {
		this.errorcode = errorcode;
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDisplayflag() {
		return displayflag;
	}

	public void setDisplayflag(String displayflag) {
		this.displayflag = displayflag;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (errorcode != null ? errorcode.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LookupFinacleErrorCode)) {
			return false;
		}
		LookupFinacleErrorCode other = (LookupFinacleErrorCode) object;
		if ((this.errorcode == null && other.errorcode != null)
				|| (this.errorcode != null && !this.errorcode.equals(other.errorcode))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bs.themebridge.entity.model.LookupFinacleErrorCode[ errorcode=" + errorcode + " ]";
	}

}
