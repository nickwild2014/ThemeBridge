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
 * @author Prasath Ravichandran, Not required
 */
@Entity
// @Table(name = "EODPOSTING", catalog = "", schema = "THEMEBRIDGE")
@Table(name = "EODPOSTING")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "Eodposting.findAll", query = "SELECT e FROM Eodposting e"),
		@NamedQuery(name = "Eodposting.findById", query = "SELECT e FROM Eodposting e WHERE e.id = :id"),
		@NamedQuery(name = "Eodposting.findByService", query = "SELECT e FROM Eodposting e WHERE e.service = :service"),
		@NamedQuery(name = "Eodposting.findByOperation", query = "SELECT e FROM Eodposting e WHERE e.operation = :operation"),
		@NamedQuery(name = "Eodposting.findByZone", query = "SELECT e FROM Eodposting e WHERE e.zone = :zone"),
		@NamedQuery(name = "Eodposting.findByBranch", query = "SELECT e FROM Eodposting e WHERE e.branch = :branch"),
		@NamedQuery(name = "Eodposting.findBySourcesystem", query = "SELECT e FROM Eodposting e WHERE e.sourcesystem = :sourcesystem"),
		@NamedQuery(name = "Eodposting.findByTargetsystem", query = "SELECT e FROM Eodposting e WHERE e.targetsystem = :targetsystem"),
		@NamedQuery(name = "Eodposting.findByMasterreference", query = "SELECT e FROM Eodposting e WHERE e.masterreference = :masterreference"),
		@NamedQuery(name = "Eodposting.findByEventreference", query = "SELECT e FROM Eodposting e WHERE e.eventreference = :eventreference"),
		@NamedQuery(name = "Eodposting.findByStatus", query = "SELECT e FROM Eodposting e WHERE e.status = :status"),
		@NamedQuery(name = "Eodposting.findByReceivedtime", query = "SELECT e FROM Eodposting e WHERE e.receivedtime = :receivedtime"),
		@NamedQuery(name = "Eodposting.findByProcesstime", query = "SELECT e FROM Eodposting e WHERE e.processtime = :processtime"),
		@NamedQuery(name = "Eodposting.findByTransactionid", query = "SELECT e FROM Eodposting e WHERE e.transactionid = :transactionid"),
		@NamedQuery(name = "Eodposting.findByTransactionseqno", query = "SELECT e FROM Eodposting e WHERE e.transactionseqno = :transactionseqno"),
		@NamedQuery(name = "Eodposting.findByAccountnumber", query = "SELECT e FROM Eodposting e WHERE e.accountnumber = :accountnumber"),
		@NamedQuery(name = "Eodposting.findByPostingamount", query = "SELECT e FROM Eodposting e WHERE e.postingamount = :postingamount"),
		@NamedQuery(name = "Eodposting.findByPostingccy", query = "SELECT e FROM Eodposting e WHERE e.postingccy = :postingccy"),
		@NamedQuery(name = "Eodposting.findByValuedate", query = "SELECT e FROM Eodposting e WHERE e.valuedate = :valuedate"),
		@NamedQuery(name = "Eodposting.findByMasterkey", query = "SELECT e FROM Eodposting e WHERE e.masterkey = :masterkey"),
		@NamedQuery(name = "Eodposting.findByPostingbranch", query = "SELECT e FROM Eodposting e WHERE e.postingbranch = :postingbranch"),
		@NamedQuery(name = "Eodposting.findByInputbranch", query = "SELECT e FROM Eodposting e WHERE e.inputbranch = :inputbranch"),
		@NamedQuery(name = "Eodposting.findByProductreference", query = "SELECT e FROM Eodposting e WHERE e.productreference = :productreference"),
		@NamedQuery(name = "Eodposting.findByPostingseqno", query = "SELECT e FROM Eodposting e WHERE e.postingseqno = :postingseqno"),
		@NamedQuery(name = "Eodposting.findByBackofficeaccountno", query = "SELECT e FROM Eodposting e WHERE e.backofficeaccountno = :backofficeaccountno"),
		@NamedQuery(name = "Eodposting.findByAccounttype", query = "SELECT e FROM Eodposting e WHERE e.accounttype = :accounttype"),
		@NamedQuery(name = "Eodposting.findBySpskmnemonic", query = "SELECT e FROM Eodposting e WHERE e.spskmnemonic = :spskmnemonic"),
		@NamedQuery(name = "Eodposting.findBySpskcategorycode", query = "SELECT e FROM Eodposting e WHERE e.spskcategorycode = :spskcategorycode"),
		@NamedQuery(name = "Eodposting.findByDebitcreditflag", query = "SELECT e FROM Eodposting e WHERE e.debitcreditflag = :debitcreditflag"),
		@NamedQuery(name = "Eodposting.findByTransactioncode", query = "SELECT e FROM Eodposting e WHERE e.transactioncode = :transactioncode"),
		@NamedQuery(name = "Eodposting.findByRelatedparty", query = "SELECT e FROM Eodposting e WHERE e.relatedparty = :relatedparty"),
		@NamedQuery(name = "Eodposting.findBySettlementaccountused", query = "SELECT e FROM Eodposting e WHERE e.settlementaccountused = :settlementaccountused"),
		@NamedQuery(name = "Eodposting.findBySwiftmessagetype", query = "SELECT e FROM Eodposting e WHERE e.swiftmessagetype = :swiftmessagetype"),
		@NamedQuery(name = "Eodposting.findByServicelevel", query = "SELECT e FROM Eodposting e WHERE e.servicelevel = :servicelevel"),
		@NamedQuery(name = "Eodposting.findBySwiftchargesfor", query = "SELECT e FROM Eodposting e WHERE e.swiftchargesfor = :swiftchargesfor"),
		@NamedQuery(name = "Eodposting.findByAddmntdelflag", query = "SELECT e FROM Eodposting e WHERE e.addmntdelflag = :addmntdelflag"),
		@NamedQuery(name = "Eodposting.findByExtradata1", query = "SELECT e FROM Eodposting e WHERE e.extradata1 = :extradata1"),
		@NamedQuery(name = "Eodposting.findByExtradata2", query = "SELECT e FROM Eodposting e WHERE e.extradata2 = :extradata2"),
		@NamedQuery(name = "Eodposting.findByExtradata3", query = "SELECT e FROM Eodposting e WHERE e.extradata3 = :extradata3"),
		@NamedQuery(name = "Eodposting.findByExtradata4", query = "SELECT e FROM Eodposting e WHERE e.extradata4 = :extradata4"),
		@NamedQuery(name = "Eodposting.findByNarrative1", query = "SELECT e FROM Eodposting e WHERE e.narrative1 = :narrative1"),
		@NamedQuery(name = "Eodposting.findByNarrative2", query = "SELECT e FROM Eodposting e WHERE e.narrative2 = :narrative2"),
		@NamedQuery(name = "Eodposting.findByNarrative3", query = "SELECT e FROM Eodposting e WHERE e.narrative3 = :narrative3"),
		@NamedQuery(name = "Eodposting.findByNarrative4", query = "SELECT e FROM Eodposting e WHERE e.narrative4 = :narrative4") })
public class Eodposting implements Serializable {

	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "EODSEQ")
	@SequenceGenerator(name = "EODSEQ", sequenceName = "EODPOSTING_SEQ", allocationSize = 1)
	private BigDecimal id;
	@Column(name = "SERVICE")
	private String service;
	@Column(name = "OPERATION")
	private String operation;
	@Column(name = "ZONE")
	private String zone;
	@Column(name = "BRANCH")
	private String branch;
	@Column(name = "SOURCESYSTEM")
	private String sourcesystem;
	@Column(name = "TARGETSYSTEM")
	private String targetsystem;
	@Column(name = "MASTERREFERENCE")
	private String masterreference;
	@Column(name = "EVENTREFERENCE")
	private String eventreference;
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
	@Column(name = "TRANSACTIONID")
	private String transactionid;
	@Column(name = "TRANSACTIONSEQNO")
	private String transactionseqno;
	@Column(name = "ACCOUNTNUMBER")
	private String accountnumber;
	@Column(name = "POSTINGAMOUNT")
	private String postingamount;
	@Column(name = "POSTINGCCY")
	private String postingccy;
	@Column(name = "VALUEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date valuedate;
	@Column(name = "MASTERKEY")
	private String masterkey;
	@Column(name = "POSTINGBRANCH")
	private String postingbranch;
	@Column(name = "INPUTBRANCH")
	private String inputbranch;
	@Column(name = "PRODUCTREFERENCE")
	private String productreference;
	@Column(name = "POSTINGSEQNO")
	private String postingseqno;
	@Column(name = "BACKOFFICEACCOUNTNO")
	private String backofficeaccountno;
	@Column(name = "ACCOUNTTYPE")
	private String accounttype;
	@Column(name = "SPSKMNEMONIC")
	private String spskmnemonic;
	@Column(name = "SPSKCATEGORYCODE")
	private String spskcategorycode;
	@Column(name = "DEBITCREDITFLAG")
	private String debitcreditflag;
	@Column(name = "TRANSACTIONCODE")
	private String transactioncode;
	@Column(name = "RELATEDPARTY")
	private String relatedparty;
	@Column(name = "SETTLEMENTACCOUNTUSED")
	private String settlementaccountused;
	@Column(name = "SWIFTMESSAGETYPE")
	private String swiftmessagetype;
	@Column(name = "SERVICELEVEL")
	private String servicelevel;
	@Column(name = "SWIFTCHARGESFOR")
	private String swiftchargesfor;
	@Column(name = "ADDMNTDELFLAG")
	private String addmntdelflag;
	@Column(name = "EXTRADATA1")
	private String extradata1;
	@Column(name = "EXTRADATA2")
	private String extradata2;
	@Column(name = "EXTRADATA3")
	private String extradata3;
	@Column(name = "EXTRADATA4")
	private String extradata4;
	@Column(name = "NARRATIVE1")
	private String narrative1;
	@Column(name = "NARRATIVE2")
	private String narrative2;
	@Column(name = "NARRATIVE3")
	private String narrative3;
	@Column(name = "NARRATIVE4")
	private String narrative4;

	public Eodposting() {
	}

	public Eodposting(BigDecimal id) {
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

	public String getZone() {
		return zone;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public String getSourcesystem() {
		return sourcesystem;
	}

	public void setSourcesystem(String sourcesystem) {
		this.sourcesystem = sourcesystem;
	}

	public String getTargetsystem() {
		return targetsystem;
	}

	public void setTargetsystem(String targetsystem) {
		this.targetsystem = targetsystem;
	}

	public String getMasterreference() {
		return masterreference;
	}

	public void setMasterreference(String masterreference) {
		this.masterreference = masterreference;
	}

	public String getEventreference() {
		return eventreference;
	}

	public void setEventreference(String eventreference) {
		this.eventreference = eventreference;
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

	public String getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(String transactionid) {
		this.transactionid = transactionid;
	}

	public String getTransactionseqno() {
		return transactionseqno;
	}

	public void setTransactionseqno(String transactionseqno) {
		this.transactionseqno = transactionseqno;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getPostingamount() {
		return postingamount;
	}

	public void setPostingamount(String postingamount) {
		this.postingamount = postingamount;
	}

	public String getPostingccy() {
		return postingccy;
	}

	public void setPostingccy(String postingccy) {
		this.postingccy = postingccy;
	}

	public Date getValuedate() {
		return valuedate;
	}

	public void setValuedate(Date valuedate) {
		this.valuedate = valuedate;
	}

	public String getMasterkey() {
		return masterkey;
	}

	public void setMasterkey(String masterkey) {
		this.masterkey = masterkey;
	}

	public String getPostingbranch() {
		return postingbranch;
	}

	public void setPostingbranch(String postingbranch) {
		this.postingbranch = postingbranch;
	}

	public String getInputbranch() {
		return inputbranch;
	}

	public void setInputbranch(String inputbranch) {
		this.inputbranch = inputbranch;
	}

	public String getProductreference() {
		return productreference;
	}

	public void setProductreference(String productreference) {
		this.productreference = productreference;
	}

	public String getPostingseqno() {
		return postingseqno;
	}

	public void setPostingseqno(String postingseqno) {
		this.postingseqno = postingseqno;
	}

	public String getBackofficeaccountno() {
		return backofficeaccountno;
	}

	public void setBackofficeaccountno(String backofficeaccountno) {
		this.backofficeaccountno = backofficeaccountno;
	}

	public String getAccounttype() {
		return accounttype;
	}

	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}

	public String getSpskmnemonic() {
		return spskmnemonic;
	}

	public void setSpskmnemonic(String spskmnemonic) {
		this.spskmnemonic = spskmnemonic;
	}

	public String getSpskcategorycode() {
		return spskcategorycode;
	}

	public void setSpskcategorycode(String spskcategorycode) {
		this.spskcategorycode = spskcategorycode;
	}

	public String getDebitcreditflag() {
		return debitcreditflag;
	}

	public void setDebitcreditflag(String debitcreditflag) {
		this.debitcreditflag = debitcreditflag;
	}

	public String getTransactioncode() {
		return transactioncode;
	}

	public void setTransactioncode(String transactioncode) {
		this.transactioncode = transactioncode;
	}

	public String getRelatedparty() {
		return relatedparty;
	}

	public void setRelatedparty(String relatedparty) {
		this.relatedparty = relatedparty;
	}

	public String getSettlementaccountused() {
		return settlementaccountused;
	}

	public void setSettlementaccountused(String settlementaccountused) {
		this.settlementaccountused = settlementaccountused;
	}

	public String getSwiftmessagetype() {
		return swiftmessagetype;
	}

	public void setSwiftmessagetype(String swiftmessagetype) {
		this.swiftmessagetype = swiftmessagetype;
	}

	public String getServicelevel() {
		return servicelevel;
	}

	public void setServicelevel(String servicelevel) {
		this.servicelevel = servicelevel;
	}

	public String getSwiftchargesfor() {
		return swiftchargesfor;
	}

	public void setSwiftchargesfor(String swiftchargesfor) {
		this.swiftchargesfor = swiftchargesfor;
	}

	public String getAddmntdelflag() {
		return addmntdelflag;
	}

	public void setAddmntdelflag(String addmntdelflag) {
		this.addmntdelflag = addmntdelflag;
	}

	public String getExtradata1() {
		return extradata1;
	}

	public void setExtradata1(String extradata1) {
		this.extradata1 = extradata1;
	}

	public String getExtradata2() {
		return extradata2;
	}

	public void setExtradata2(String extradata2) {
		this.extradata2 = extradata2;
	}

	public String getExtradata3() {
		return extradata3;
	}

	public void setExtradata3(String extradata3) {
		this.extradata3 = extradata3;
	}

	public String getExtradata4() {
		return extradata4;
	}

	public void setExtradata4(String extradata4) {
		this.extradata4 = extradata4;
	}

	public String getNarrative1() {
		return narrative1;
	}

	public void setNarrative1(String narrative1) {
		this.narrative1 = narrative1;
	}

	public String getNarrative2() {
		return narrative2;
	}

	public void setNarrative2(String narrative2) {
		this.narrative2 = narrative2;
	}

	public String getNarrative3() {
		return narrative3;
	}

	public void setNarrative3(String narrative3) {
		this.narrative3 = narrative3;
	}

	public String getNarrative4() {
		return narrative4;
	}

	public void setNarrative4(String narrative4) {
		this.narrative4 = narrative4;
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
		if (!(object instanceof Eodposting)) {
			return false;
		}
		Eodposting other = (Eodposting) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "javaapplication1.Eodposting[ id=" + id + " ]";
	}

}
