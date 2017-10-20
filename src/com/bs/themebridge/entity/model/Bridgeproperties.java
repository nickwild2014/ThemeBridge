/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.themebridge.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Prasath Ravichandran
 */
@Entity
// @Table(name = "BRIDGEPROPERTIES", catalog = "", schema = "THEMEBRIDGE")
@Table(name = "BRIDGEPROPERTIES")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Bridgeproperties.findAll", query = "SELECT b FROM Bridgeproperties b"),
		@NamedQuery(name = "Bridgeproperties.findById", query = "SELECT b FROM Bridgeproperties b WHERE b.id = :id"),
		@NamedQuery(name = "Bridgeproperties.findByZone", query = "SELECT b FROM Bridgeproperties b WHERE b.zone = :zone"),
		@NamedQuery(name = "Bridgeproperties.findByKey", query = "SELECT b FROM Bridgeproperties b WHERE b.key = :key"),
		@NamedQuery(name = "Bridgeproperties.findByValue", query = "SELECT b FROM Bridgeproperties b WHERE b.value = :value"),
		@NamedQuery(name = "Bridgeproperties.findByCategory", query = "SELECT b FROM Bridgeproperties b WHERE b.category = :category"),
		@NamedQuery(name = "Bridgeproperties.findByBranch", query = "SELECT b FROM Bridgeproperties b WHERE b.branch = :branch"),
		@NamedQuery(name = "Bridgeproperties.findByZoneAndKey", query = "SELECT b FROM Bridgeproperties b WHERE b.zone = :zone AND b.key = :key"),
		@NamedQuery(name = "Bridgeproperties.findByBranchAndKey", query = "SELECT b FROM Bridgeproperties b WHERE b.branch = :branch AND b.key = :key"),
		@NamedQuery(name = "Bridgeproperties.findByZoneBranchAndKey", query = "SELECT b FROM Bridgeproperties b WHERE b.zone = :zone AND b.branch = :branch AND b.key = :key") })
public class Bridgeproperties implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "BPSEQ")
	@SequenceGenerator(name = "BPSEQ", sequenceName = "BRIDGEPROPERTY_SEQ", allocationSize = 1)
	private BigDecimal id;
	@Basic(optional = false)
	@Column(name = "ZONE")
	private String zone;
	@Basic(optional = false)
	@Column(name = "KEY")
	private String key;
	@Basic(optional = false)
	@Column(name = "VALUE")
	private String value;
	@Column(name = "CATEGORY")
	private String category;
	@Column(name = "BRANCH")
	private String branch;

	public Bridgeproperties() {
	}

	public Bridgeproperties(BigDecimal id) {
		this.id = id;
	}

	public Bridgeproperties(BigDecimal id, String zone, String key, String value) {
		this.id = id;
		this.zone = zone;
		this.key = key;
		this.value = value;
	}

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
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
		if (!(object instanceof Bridgeproperties)) {
			return false;
		}
		Bridgeproperties other = (Bridgeproperties) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Bridgeproperties : {id : " + id + ", zone : " + zone + ", key : " + key + ", value : " + value
				+ ", category : " + category + ", branch : " + branch + "}";
	}

}
