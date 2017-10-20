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
// @Table(name = "LOOKUP_GL_ACCOUNT", catalog = "", schema = "THEMEBRIDGE")
@Table(name = "LOOKUP_GL_ACCOUNT")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LookupGlAccount.findAll", query = "SELECT l FROM LookupGlAccount l"),
		@NamedQuery(name = "LookupGlAccount.findById", query = "SELECT l FROM LookupGlAccount l WHERE l.id = :id"),
		@NamedQuery(name = "LookupGlAccount.findByZone", query = "SELECT l FROM LookupGlAccount l WHERE l.zone = :zone"),
		@NamedQuery(name = "LookupGlAccount.findByProductype", query = "SELECT l FROM LookupGlAccount l WHERE l.productype = :productype"),
		@NamedQuery(name = "LookupGlAccount.findByAccounttype", query = "SELECT l FROM LookupGlAccount l WHERE l.accounttype = :accounttype"),
		@NamedQuery(name = "LookupGlAccount.findByCreditDebit", query = "SELECT l FROM LookupGlAccount l WHERE l.creditDebit = :creditDebit"),
		@NamedQuery(name = "LookupGlAccount.findByGlaccount", query = "SELECT l FROM LookupGlAccount l WHERE l.glaccount = :glaccount"),
		@NamedQuery(name = "LookupGlAccount.findBySpparam", query = "SELECT l FROM LookupGlAccount l WHERE l.spparam = :spparam"),
		@NamedQuery(name = "LookupGlAccount.findByDescription", query = "SELECT l FROM LookupGlAccount l WHERE l.description = :description"),
		@NamedQuery(name = "LookupGlAccount.findByTiprodtype", query = "SELECT l FROM LookupGlAccount l WHERE l.tiprodtype = :tiprodtype") })
public class LookupGlAccount implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "GLACCSEQ")
	// @SequenceGenerator(name = "GLACCSEQ", sequenceName =
	// "LOOKUPGLACCOUNT_SEQ", allocationSize = 1)
	private String id;
	@Basic(optional = false)
	@Column(name = "ZONE")
	private String zone;
	@Column(name = "PRODUCTYPE")
	private String productype;
	@Column(name = "ACCOUNTTYPE")
	private String accounttype;
	@Column(name = "CREDIT_DEBIT")
	private String creditDebit;
	@Column(name = "GLACCOUNT")
	private String glaccount;
	@Column(name = "SPPARAM")
	private String spparam;
	@Column(name = "DESCRIPTION")
	private String description;
	@Column(name = "TIPRODTYPE")
	private String tiprodtype;

	public LookupGlAccount() {
	}

	public LookupGlAccount(String id) {
		this.id = id;
	}

	public LookupGlAccount(String id, String zone) {
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

	public String getProductype() {
		return productype;
	}

	public void setProductype(String productype) {
		this.productype = productype;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getCreditDebit() {
		return creditDebit;
	}

	public void setCreditDebit(String creditDebit) {
		this.creditDebit = creditDebit;
	}

	public String getGlaccount() {
		return glaccount;
	}

	public void setGlaccount(String glaccount) {
		this.glaccount = glaccount;
	}

	public String getSpparam() {
		return spparam;
	}

	public void setSpparam(String spparam) {
		this.spparam = spparam;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTiprodtype() {
		return tiprodtype;
	}

	public void setTiprodtype(String tiprodtype) {
		this.tiprodtype = tiprodtype;
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
		if (!(object instanceof LookupGlAccount)) {
			return false;
		}
		LookupGlAccount other = (LookupGlAccount) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication1.LookupGlAccount[ id=" + id + " ]";
	}

}
