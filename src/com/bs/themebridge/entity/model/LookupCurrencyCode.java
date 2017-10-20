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
// @Table(name = "LOOKUP_CURRENCY_CODE", catalog = "", schema = "THEMEBRIDGE")
@Table(name = "LOOKUP_CURRENCY_CODE")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LookupCurrencyCode.findAll", query = "SELECT l FROM LookupCurrencyCode l"),
		@NamedQuery(name = "LookupCurrencyCode.findById", query = "SELECT l FROM LookupCurrencyCode l WHERE l.id = :id"),
		@NamedQuery(name = "LookupCurrencyCode.findByZone", query = "SELECT l FROM LookupCurrencyCode l WHERE l.zone = :zone"),
		@NamedQuery(name = "LookupCurrencyCode.findByCurrencyCode", query = "SELECT l FROM LookupCurrencyCode l WHERE l.currencyCode = :currencyCode"),
		@NamedQuery(name = "LookupCurrencyCode.findByCurrencyName", query = "SELECT l FROM LookupCurrencyCode l WHERE l.currencyName = :currencyName"),
		@NamedQuery(name = "LookupCurrencyCode.findByDcmlDesc", query = "SELECT l FROM LookupCurrencyCode l WHERE l.dcmlDesc = :dcmlDesc"),
		@NamedQuery(name = "LookupCurrencyCode.findByCountryCode", query = "SELECT l FROM LookupCurrencyCode l WHERE l.countryCode = :countryCode"),
		@NamedQuery(name = "LookupCurrencyCode.findByCurrencyMnemonicCode", query = "SELECT l FROM LookupCurrencyCode l WHERE l.currencyMnemonicCode = :currencyMnemonicCode") })
public class LookupCurrencyCode implements Serializable {

	private static final long serialVersionUID = 1L;
	@Basic(optional = false)
	@Column(name = "ID")
	// @GeneratedValue(strategy = GenerationType.SEQUENCE, generator =
	// "CCYCODESEQ")
	// @SequenceGenerator(name = "CCYCODESEQ", sequenceName =
	// "LOOKUPCURRENCYCODE_SEQ", allocationSize = 1)
	private String id;
	@Basic(optional = false)
	@Column(name = "ZONE")
	private String zone;
	@Id
	@Basic(optional = false)
	@Column(name = "CURRENCY_CODE")
	private String currencyCode;
	@Column(name = "CURRENCY_NAME")
	private String currencyName;
	@Column(name = "DCML_DESC")
	private String dcmlDesc;
	@Column(name = "COUNTRY_CODE")
	private String countryCode;
	@Column(name = "CURRENCY_MNEMONIC_CODE")
	private String currencyMnemonicCode;

	public LookupCurrencyCode() {
	}

	public LookupCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public LookupCurrencyCode(String currencyCode, String id, String zone) {
		this.currencyCode = currencyCode;
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

	public String getCurrencyCode() {
		return currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}

	public String getCurrencyName() {
		return currencyName;
	}

	public void setCurrencyName(String currencyName) {
		this.currencyName = currencyName;
	}

	public String getDcmlDesc() {
		return dcmlDesc;
	}

	public void setDcmlDesc(String dcmlDesc) {
		this.dcmlDesc = dcmlDesc;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCurrencyMnemonicCode() {
		return currencyMnemonicCode;
	}

	public void setCurrencyMnemonicCode(String currencyMnemonicCode) {
		this.currencyMnemonicCode = currencyMnemonicCode;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (currencyCode != null ? currencyCode.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof LookupCurrencyCode)) {
			return false;
		}
		LookupCurrencyCode other = (LookupCurrencyCode) object;
		if ((this.currencyCode == null && other.currencyCode != null)
				|| (this.currencyCode != null && !this.currencyCode.equals(other.currencyCode))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication1.LookupCurrencyCode[ currencyCode=" + currencyCode + " ]";
	}

}
