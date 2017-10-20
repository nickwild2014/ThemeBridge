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
 * @author Prasath Ravichandran
 */
@Entity
// @Table(name = "LOOKUP_ACCOUNT_TYPE", catalog = "", schema = "THEMEBRIDGE")
@Table(name = "LOOKUP_ACCOUNT_TYPE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LookupAccountType.findAll", query = "SELECT l FROM LookupAccountType l"),
		@NamedQuery(name = "LookupAccountType.findById", query = "SELECT l FROM LookupAccountType l WHERE l.id = :id"),
		@NamedQuery(name = "LookupAccountType.findByZone", query = "SELECT l FROM LookupAccountType l WHERE l.zone = :zone"),
		@NamedQuery(name = "LookupAccountType.findByTiaccountype", query = "SELECT l FROM LookupAccountType l WHERE l.tiaccountype = :tiaccountype"),
		@NamedQuery(name = "LookupAccountType.findByFiaccounttype", query = "SELECT l FROM LookupAccountType l WHERE l.fiaccounttype = :fiaccounttype"),
		@NamedQuery(name = "LookupAccountType.findByDescription", query = "SELECT l FROM LookupAccountType l WHERE l.description = :description") })
public class LookupAccountType implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACTSEQ")
	// @SequenceGenerator(name = "ACTSEQ", sequenceName =
	// "LOOKUPACCOUNTTYPE_SEQ", allocationSize = 1)
	private String id;
	@Basic(optional = false)
	@Column(name = "ZONE")
	private String zone;
	@Column(name = "TIACCOUNTYPE")
	private String tiaccountype;
	@Column(name = "FIACCOUNTTYPE")
	private String fiaccounttype;
	@Column(name = "DESCRIPTION")
	private String description;

	public LookupAccountType() {
	}

	public LookupAccountType(String id) {
		this.id = id;
	}

	public LookupAccountType(String id, String zone) {
		this.id = id;
		this.zone = zone;
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

	public String getTiaccountype() {
		return tiaccountype;
	}

	public void setTiaccountype(String tiaccountype) {
		this.tiaccountype = tiaccountype;
	}

	public String getFiaccounttype() {
		return fiaccounttype;
	}

	public void setFiaccounttype(String fiaccounttype) {
		this.fiaccounttype = fiaccounttype;
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
		if (!(object instanceof LookupAccountType)) {
			return false;
		}
		LookupAccountType other = (LookupAccountType) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication1.LookupAccountType[ id=" + id + " ]";
	}

}
