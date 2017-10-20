/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bs.themebridge.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BSIT012
 */
@Entity
@Table(name = "EOD_FINCE_PST_STAGING")
@XmlRootElement
@NamedQueries({ @NamedQuery(name = "EodFincePstStaging.findAll", query = "SELECT e FROM EodFincePstStaging e"),
		@NamedQuery(name = "EodFincePstStaging.findByKey29", query = "SELECT e FROM EodFincePstStaging e WHERE e.key29 = :key29"),
		@NamedQuery(name = "EodFincePstStaging.findByBankEnt", query = "SELECT e FROM EodFincePstStaging e WHERE e.bankEnt = :bankEnt"),
		@NamedQuery(name = "EodFincePstStaging.findByFinpstAcc", query = "SELECT e FROM EodFincePstStaging e WHERE e.finpstAcc = :finpstAcc"),
		@NamedQuery(name = "EodFincePstStaging.findByFinpstBrn", query = "SELECT e FROM EodFincePstStaging e WHERE e.finpstBrn = :finpstBrn"),
		@NamedQuery(name = "EodFincePstStaging.findByPostingtyp", query = "SELECT e FROM EodFincePstStaging e WHERE e.postingtyp = :postingtyp"),
		@NamedQuery(name = "EodFincePstStaging.findByFinpstDte", query = "SELECT e FROM EodFincePstStaging e WHERE e.finpstDte = :finpstDte"),
		@NamedQuery(name = "EodFincePstStaging.findByFinpstDlp", query = "SELECT e FROM EodFincePstStaging e WHERE e.finpstDlp = :finpstDlp"),
		@NamedQuery(name = "EodFincePstStaging.findBySettle01", query = "SELECT e FROM EodFincePstStaging e WHERE e.settle01 = :settle01"),
		@NamedQuery(name = "EodFincePstStaging.findByFinpstDlr", query = "SELECT e FROM EodFincePstStaging e WHERE e.finpstDlr = :finpstDlr"),
		@NamedQuery(name = "EodFincePstStaging.findByFinpstAma", query = "SELECT e FROM EodFincePstStaging e WHERE e.finpstAma = :finpstAma"),
		@NamedQuery(name = "EodFincePstStaging.findByDrCrFlg", query = "SELECT e FROM EodFincePstStaging e WHERE e.drCrFlg = :drCrFlg"),
		@NamedQuery(name = "EodFincePstStaging.findByFinpstTcd", query = "SELECT e FROM EodFincePstStaging e WHERE e.finpstTcd = :finpstTcd"),
		@NamedQuery(name = "EodFincePstStaging.findByUnposted", query = "SELECT e FROM EodFincePstStaging e WHERE e.unposted = :unposted"),
		@NamedQuery(name = "EodFincePstStaging.findByFinpstCcy", query = "SELECT e FROM EodFincePstStaging e WHERE e.finpstCcy = :finpstCcy"),
		@NamedQuery(name = "EodFincePstStaging.findByFinpstAnm", query = "SELECT e FROM EodFincePstStaging e WHERE e.finpstAnm = :finpstAnm"),
		@NamedQuery(name = "EodFincePstStaging.findByFinpstBin", query = "SELECT e FROM EodFincePstStaging e WHERE e.finpstBin = :finpstBin"),
		@NamedQuery(name = "EodFincePstStaging.findByRelCustsb", query = "SELECT e FROM EodFincePstStaging e WHERE e.relCustsb = :relCustsb"),
		@NamedQuery(name = "EodFincePstStaging.findByRelCust", query = "SELECT e FROM EodFincePstStaging e WHERE e.relCust = :relCust"),
		@NamedQuery(name = "EodFincePstStaging.findByRelCustyp", query = "SELECT e FROM EodFincePstStaging e WHERE e.relCustyp = :relCustyp"),
		@NamedQuery(name = "EodFincePstStaging.findByRelACode", query = "SELECT e FROM EodFincePstStaging e WHERE e.relACode = :relACode"),
		@NamedQuery(name = "EodFincePstStaging.findByRelPCnty", query = "SELECT e FROM EodFincePstStaging e WHERE e.relPCnty = :relPCnty"),
		@NamedQuery(name = "EodFincePstStaging.findByRelPc", query = "SELECT e FROM EodFincePstStaging e WHERE e.relPc = :relPc"),
		@NamedQuery(name = "EodFincePstStaging.findByFinmstKey", query = "SELECT e FROM EodFincePstStaging e WHERE e.finmstKey = :finmstKey"),
		@NamedQuery(name = "EodFincePstStaging.findByExtfield", query = "SELECT e FROM EodFincePstStaging e WHERE e.extfield = :extfield"),
		@NamedQuery(name = "EodFincePstStaging.findByAccType", query = "SELECT e FROM EodFincePstStaging e WHERE e.accType = :accType"),
		@NamedQuery(name = "EodFincePstStaging.findByCusSbb", query = "SELECT e FROM EodFincePstStaging e WHERE e.cusSbb = :cusSbb"),
		@NamedQuery(name = "EodFincePstStaging.findByCusMnm", query = "SELECT e FROM EodFincePstStaging e WHERE e.cusMnm = :cusMnm"),
		@NamedQuery(name = "EodFincePstStaging.findByParty", query = "SELECT e FROM EodFincePstStaging e WHERE e.party = :party"),
		@NamedQuery(name = "EodFincePstStaging.findByNarrP1", query = "SELECT e FROM EodFincePstStaging e WHERE e.narrP1 = :narrP1"),
		@NamedQuery(name = "EodFincePstStaging.findByNarrP2", query = "SELECT e FROM EodFincePstStaging e WHERE e.narrP2 = :narrP2"),
		@NamedQuery(name = "EodFincePstStaging.findByNarrP3", query = "SELECT e FROM EodFincePstStaging e WHERE e.narrP3 = :narrP3"),
		@NamedQuery(name = "EodFincePstStaging.findByNarrP4", query = "SELECT e FROM EodFincePstStaging e WHERE e.narrP4 = :narrP4"),
		@NamedQuery(name = "EodFincePstStaging.findByTenorend", query = "SELECT e FROM EodFincePstStaging e WHERE e.tenorend = :tenorend"),
		@NamedQuery(name = "EodFincePstStaging.findByTenorstart", query = "SELECT e FROM EodFincePstStaging e WHERE e.tenorstart = :tenorstart"),
		@NamedQuery(name = "EodFincePstStaging.findByUsercode1", query = "SELECT e FROM EodFincePstStaging e WHERE e.usercode1 = :usercode1"),
		@NamedQuery(name = "EodFincePstStaging.findByUsercode2", query = "SELECT e FROM EodFincePstStaging e WHERE e.usercode2 = :usercode2"),
		@NamedQuery(name = "EodFincePstStaging.findByUsercode3", query = "SELECT e FROM EodFincePstStaging e WHERE e.usercode3 = :usercode3"),
		@NamedQuery(name = "EodFincePstStaging.findByWorkgroup", query = "SELECT e FROM EodFincePstStaging e WHERE e.workgroup = :workgroup"),
		@NamedQuery(name = "EodFincePstStaging.findByAgainstccy", query = "SELECT e FROM EodFincePstStaging e WHERE e.againstccy = :againstccy"),
		@NamedQuery(name = "EodFincePstStaging.findByExchRate", query = "SELECT e FROM EodFincePstStaging e WHERE e.exchRate = :exchRate"),
		@NamedQuery(name = "EodFincePstStaging.findByProdtype", query = "SELECT e FROM EodFincePstStaging e WHERE e.prodtype = :prodtype"),
		@NamedQuery(name = "EodFincePstStaging.findByCofPsting", query = "SELECT e FROM EodFincePstStaging e WHERE e.cofPsting = :cofPsting"),
		@NamedQuery(name = "EodFincePstStaging.findByPosteddate", query = "SELECT e FROM EodFincePstStaging e WHERE e.posteddate = :posteddate"),
		@NamedQuery(name = "EodFincePstStaging.findByTypeflag", query = "SELECT e FROM EodFincePstStaging e WHERE e.typeflag = :typeflag"),
		@NamedQuery(name = "EodFincePstStaging.findByTstamp", query = "SELECT e FROM EodFincePstStaging e WHERE e.tstamp = :tstamp") })
public class EodFincePstStaging implements Serializable {
	private static final long serialVersionUID = 1L;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Id
	@Basic(optional = false)
	private BigDecimal key29;
	@Column(name = "BANK_ENT")
	private String bankEnt;
	@Column(name = "FINPST_ACC")
	private String finpstAcc;
	@Column(name = "FINPST_BRN")
	private String finpstBrn;
	private String postingtyp;
	@Column(name = "FINPST_DTE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date finpstDte;
	@Column(name = "FINPST_DLP")
	private String finpstDlp;
	private Character settle01;
	@Column(name = "FINPST_DLR")
	private String finpstDlr;
	@Column(name = "FINPST_AMA")
	private Long finpstAma;
	@Column(name = "DR_CR_FLG")
	private Character drCrFlg;
	@Column(name = "FINPST_TCD")
	private String finpstTcd;
	private Character unposted;
	@Column(name = "FINPST_CCY")
	private String finpstCcy;
	@Column(name = "FINPST_ANM")
	private String finpstAnm;
	@Column(name = "FINPST_BIN")
	private String finpstBin;
	@Column(name = "REL_CUSTSB")
	private String relCustsb;
	@Column(name = "REL_CUST")
	private String relCust;
	@Column(name = "REL_CUSTYP")
	private String relCustyp;
	@Column(name = "REL_A_CODE")
	private String relACode;
	@Column(name = "REL_P_CNTY")
	private String relPCnty;
	@Column(name = "REL_PC")
	private String relPc;
	@Column(name = "FINMST_KEY")
	private BigInteger finmstKey;
	private BigInteger extfield;
	@Column(name = "ACC_TYPE")
	private String accType;
	@Column(name = "CUS_SBB")
	private String cusSbb;
	@Column(name = "CUS_MNM")
	private String cusMnm;
	private BigInteger party;
	@Column(name = "NARR_P1")
	private String narrP1;
	@Column(name = "NARR_P2")
	private String narrP2;
	@Column(name = "NARR_P3")
	private String narrP3;
	@Column(name = "NARR_P4")
	private String narrP4;
	@Temporal(TemporalType.TIMESTAMP)
	private Date tenorend;
	@Temporal(TemporalType.TIMESTAMP)
	private Date tenorstart;
	private String usercode1;
	private String usercode2;
	private String usercode3;
	private String workgroup;
	private String againstccy;
	@Column(name = "EXCH_RATE")
	private BigDecimal exchRate;
	private BigInteger prodtype;
	@Column(name = "COF_PSTING")
	private Character cofPsting;
	@Temporal(TemporalType.TIMESTAMP)
	private Date posteddate;
	private BigInteger typeflag;
	private BigInteger tstamp;

	public EodFincePstStaging() {
	}

	public EodFincePstStaging(BigDecimal key29) {
		this.key29 = key29;
	}

	public BigDecimal getKey29() {
		return key29;
	}

	public void setKey29(BigDecimal key29) {
		this.key29 = key29;
	}

	public String getBankEnt() {
		return bankEnt;
	}

	public void setBankEnt(String bankEnt) {
		this.bankEnt = bankEnt;
	}

	public String getFinpstAcc() {
		return finpstAcc;
	}

	public void setFinpstAcc(String finpstAcc) {
		this.finpstAcc = finpstAcc;
	}

	public String getFinpstBrn() {
		return finpstBrn;
	}

	public void setFinpstBrn(String finpstBrn) {
		this.finpstBrn = finpstBrn;
	}

	public String getPostingtyp() {
		return postingtyp;
	}

	public void setPostingtyp(String postingtyp) {
		this.postingtyp = postingtyp;
	}

	public Date getFinpstDte() {
		return finpstDte;
	}

	public void setFinpstDte(Date finpstDte) {
		this.finpstDte = finpstDte;
	}

	public String getFinpstDlp() {
		return finpstDlp;
	}

	public void setFinpstDlp(String finpstDlp) {
		this.finpstDlp = finpstDlp;
	}

	public Character getSettle01() {
		return settle01;
	}

	public void setSettle01(Character settle01) {
		this.settle01 = settle01;
	}

	public String getFinpstDlr() {
		return finpstDlr;
	}

	public void setFinpstDlr(String finpstDlr) {
		this.finpstDlr = finpstDlr;
	}

	public Long getFinpstAma() {
		return finpstAma;
	}

	public void setFinpstAma(Long finpstAma) {
		this.finpstAma = finpstAma;
	}

	public Character getDrCrFlg() {
		return drCrFlg;
	}

	public void setDrCrFlg(Character drCrFlg) {
		this.drCrFlg = drCrFlg;
	}

	public String getFinpstTcd() {
		return finpstTcd;
	}

	public void setFinpstTcd(String finpstTcd) {
		this.finpstTcd = finpstTcd;
	}

	public Character getUnposted() {
		return unposted;
	}

	public void setUnposted(Character unposted) {
		this.unposted = unposted;
	}

	public String getFinpstCcy() {
		return finpstCcy;
	}

	public void setFinpstCcy(String finpstCcy) {
		this.finpstCcy = finpstCcy;
	}

	public String getFinpstAnm() {
		return finpstAnm;
	}

	public void setFinpstAnm(String finpstAnm) {
		this.finpstAnm = finpstAnm;
	}

	public String getFinpstBin() {
		return finpstBin;
	}

	public void setFinpstBin(String finpstBin) {
		this.finpstBin = finpstBin;
	}

	public String getRelCustsb() {
		return relCustsb;
	}

	public void setRelCustsb(String relCustsb) {
		this.relCustsb = relCustsb;
	}

	public String getRelCust() {
		return relCust;
	}

	public void setRelCust(String relCust) {
		this.relCust = relCust;
	}

	public String getRelCustyp() {
		return relCustyp;
	}

	public void setRelCustyp(String relCustyp) {
		this.relCustyp = relCustyp;
	}

	public String getRelACode() {
		return relACode;
	}

	public void setRelACode(String relACode) {
		this.relACode = relACode;
	}

	public String getRelPCnty() {
		return relPCnty;
	}

	public void setRelPCnty(String relPCnty) {
		this.relPCnty = relPCnty;
	}

	public String getRelPc() {
		return relPc;
	}

	public void setRelPc(String relPc) {
		this.relPc = relPc;
	}

	public BigInteger getFinmstKey() {
		return finmstKey;
	}

	public void setFinmstKey(BigInteger finmstKey) {
		this.finmstKey = finmstKey;
	}

	public BigInteger getExtfield() {
		return extfield;
	}

	public void setExtfield(BigInteger extfield) {
		this.extfield = extfield;
	}

	public String getAccType() {
		return accType;
	}

	public void setAccType(String accType) {
		this.accType = accType;
	}

	public String getCusSbb() {
		return cusSbb;
	}

	public void setCusSbb(String cusSbb) {
		this.cusSbb = cusSbb;
	}

	public String getCusMnm() {
		return cusMnm;
	}

	public void setCusMnm(String cusMnm) {
		this.cusMnm = cusMnm;
	}

	public BigInteger getParty() {
		return party;
	}

	public void setParty(BigInteger party) {
		this.party = party;
	}

	public String getNarrP1() {
		return narrP1;
	}

	public void setNarrP1(String narrP1) {
		this.narrP1 = narrP1;
	}

	public String getNarrP2() {
		return narrP2;
	}

	public void setNarrP2(String narrP2) {
		this.narrP2 = narrP2;
	}

	public String getNarrP3() {
		return narrP3;
	}

	public void setNarrP3(String narrP3) {
		this.narrP3 = narrP3;
	}

	public String getNarrP4() {
		return narrP4;
	}

	public void setNarrP4(String narrP4) {
		this.narrP4 = narrP4;
	}

	public Date getTenorend() {
		return tenorend;
	}

	public void setTenorend(Date tenorend) {
		this.tenorend = tenorend;
	}

	public Date getTenorstart() {
		return tenorstart;
	}

	public void setTenorstart(Date tenorstart) {
		this.tenorstart = tenorstart;
	}

	public String getUsercode1() {
		return usercode1;
	}

	public void setUsercode1(String usercode1) {
		this.usercode1 = usercode1;
	}

	public String getUsercode2() {
		return usercode2;
	}

	public void setUsercode2(String usercode2) {
		this.usercode2 = usercode2;
	}

	public String getUsercode3() {
		return usercode3;
	}

	public void setUsercode3(String usercode3) {
		this.usercode3 = usercode3;
	}

	public String getWorkgroup() {
		return workgroup;
	}

	public void setWorkgroup(String workgroup) {
		this.workgroup = workgroup;
	}

	public String getAgainstccy() {
		return againstccy;
	}

	public void setAgainstccy(String againstccy) {
		this.againstccy = againstccy;
	}

	public BigDecimal getExchRate() {
		return exchRate;
	}

	public void setExchRate(BigDecimal exchRate) {
		this.exchRate = exchRate;
	}

	public BigInteger getProdtype() {
		return prodtype;
	}

	public void setProdtype(BigInteger prodtype) {
		this.prodtype = prodtype;
	}

	public Character getCofPsting() {
		return cofPsting;
	}

	public void setCofPsting(Character cofPsting) {
		this.cofPsting = cofPsting;
	}

	public Date getPosteddate() {
		return posteddate;
	}

	public void setPosteddate(Date posteddate) {
		this.posteddate = posteddate;
	}

	public BigInteger getTypeflag() {
		return typeflag;
	}

	public void setTypeflag(BigInteger typeflag) {
		this.typeflag = typeflag;
	}

	public BigInteger getTstamp() {
		return tstamp;
	}

	public void setTstamp(BigInteger tstamp) {
		this.tstamp = tstamp;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (key29 != null ? key29.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof EodFincePstStaging)) {
			return false;
		}
		EodFincePstStaging other = (EodFincePstStaging) object;
		if ((this.key29 == null && other.key29 != null) || (this.key29 != null && !this.key29.equals(other.key29))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.bs.themebridge.entity.model.EodFincePstStaging[ key29=" + key29 + " ]";
	}

}
