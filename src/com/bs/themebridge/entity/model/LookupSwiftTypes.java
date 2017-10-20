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
@Table(name = "LOOKUP_SWIFT_TYPES")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "LookupSwiftTypes.findAll", query = "SELECT l FROM LookupSwiftTypes l"),
		@NamedQuery(name = "LookupSwiftTypes.findById", query = "SELECT l FROM LookupSwiftTypes l WHERE l.id = :id"),
		@NamedQuery(name = "LookupSwiftTypes.findByMessagetype", query = "SELECT l FROM LookupSwiftTypes l WHERE l.messagetype = :messagetype"),
		@NamedQuery(name = "LookupSwiftTypes.findByTypedescription", query = "SELECT l FROM LookupSwiftTypes l WHERE l.typedescription = :typedescription") })
public class LookupSwiftTypes implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	private String id;
	@Column(name = "MESSAGETYPE")
	private String messagetype;
	@Column(name = "TYPEDESCRIPTION")
	private String typedescription;

	public LookupSwiftTypes() {
	}

	public LookupSwiftTypes(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessagetype() {
		return messagetype;
	}

	public void setMessagetype(String messagetype) {
		this.messagetype = messagetype;
	}

	public String getTypedescription() {
		return typedescription;
	}

	public void setTypedescription(String typedescription) {
		this.typedescription = typedescription;
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
		if (!(object instanceof LookupSwiftTypes)) {
			return false;
		}
		LookupSwiftTypes other = (LookupSwiftTypes) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bs.themebridge.entity.model.LookupSwiftTypes[ id=" + id + " ]";
	}

}
