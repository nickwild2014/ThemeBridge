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
@Table(name = "LOOKUP_FUNDED_LIABILITIES")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "LookupFundedLiabilities.findAll", query = "SELECT l FROM LookupFundedLiabilities l"),
		@NamedQuery(name = "LookupFundedLiabilities.findById", query = "SELECT l FROM LookupFundedLiabilities l WHERE l.id = :id"),
		@NamedQuery(name = "LookupFundedLiabilities.findByZone", query = "SELECT l FROM LookupFundedLiabilities l WHERE l.zone = :zone"),
		@NamedQuery(name = "LookupFundedLiabilities.findByProducttype", query = "SELECT l FROM LookupFundedLiabilities l WHERE l.producttype = :producttype"),
		@NamedQuery(name = "LookupFundedLiabilities.findByProductname", query = "SELECT l FROM LookupFundedLiabilities l WHERE l.productname = :productname"),
		@NamedQuery(name = "LookupFundedLiabilities.findBySubproducttype", query = "SELECT l FROM LookupFundedLiabilities l WHERE l.subproducttype = :subproducttype"),
		@NamedQuery(name = "LookupFundedLiabilities.findBySubproductname", query = "SELECT l FROM LookupFundedLiabilities l WHERE l.subproductname = :subproductname"),
		@NamedQuery(name = "LookupFundedLiabilities.findByDescription", query = "SELECT l FROM LookupFundedLiabilities l WHERE l.description = :description") })

public class LookupFundedLiabilities implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	private String id;
	@Column(name = "ZONE")
	private String zone;
	@Column(name = "PRODUCTTYPE")
	private String producttype;
	@Column(name = "PRODUCTNAME")
	private String productname;
	@Column(name = "SUBPRODUCTTYPE")
	private String subproducttype;
	@Column(name = "SUBPRODUCTNAME")
	private String subproductname;
	@Column(name = "DESCRIPTION")
	private String description;

	public LookupFundedLiabilities() {
	}

	public LookupFundedLiabilities(String id) {
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

	public String getProducttype() {
		return producttype;
	}

	public void setProducttype(String producttype) {
		this.producttype = producttype;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getSubproducttype() {
		return subproducttype;
	}

	public void setSubproducttype(String subproducttype) {
		this.subproducttype = subproducttype;
	}

	public String getSubproductname() {
		return subproductname;
	}

	public void setSubproductname(String subproductname) {
		this.subproductname = subproductname;
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
		if (!(object instanceof LookupFundedLiabilities)) {
			return false;
		}
		LookupFundedLiabilities other = (LookupFundedLiabilities) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bs.themebridge.entity.model.LookupFundedLiabilities[ id=" + id + " ]";
	}

}
