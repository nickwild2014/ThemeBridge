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
@Table(name = "LOOKUP_CUSTOMER_TYPE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LookupCustomerType.findAll", query = "SELECT l FROM LookupCustomerType l"),
		@NamedQuery(name = "LookupCustomerType.findById", query = "SELECT l FROM LookupCustomerType l WHERE l.id = :id"),
		@NamedQuery(name = "LookupCustomerType.findByZone", query = "SELECT l FROM LookupCustomerType l WHERE l.zone = :zone"),
		@NamedQuery(name = "LookupCustomerType.findByFicustomertype", query = "SELECT l FROM LookupCustomerType l WHERE l.ficustomertype = :ficustomertype"),
		@NamedQuery(name = "LookupCustomerType.findByTicustomertype", query = "SELECT l FROM LookupCustomerType l WHERE l.ticustomertype = :ticustomertype"),
		@NamedQuery(name = "LookupCustomerType.findByDescription", query = "SELECT l FROM LookupCustomerType l WHERE l.description = :description") })

public class LookupCustomerType implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	private String id;
	@Column(name = "ZONE")
	private String zone;
	@Column(name = "FICUSTOMERTYPE")
	private String ficustomertype;
	@Column(name = "TICUSTOMERTYPE")
	private String ticustomertype;
	@Column(name = "DESCRIPTION")
	private String description;

	public LookupCustomerType() {
	}

	public LookupCustomerType(String id) {
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

	public String getFicustomertype() {
		return ficustomertype;
	}

	public void setFicustomertype(String ficustomertype) {
		this.ficustomertype = ficustomertype;
	}

	public String getTicustomertype() {
		return ticustomertype;
	}

	public void setTicustomertype(String ticustomertype) {
		this.ticustomertype = ticustomertype;
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
		if (!(object instanceof LookupCustomerType)) {
			return false;
		}
		LookupCustomerType other = (LookupCustomerType) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bs.themebridge.entity.model.LookupCustomerType[ id=" + id + " ]";
	}

}
