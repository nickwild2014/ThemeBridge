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
@Table(name = "EOD_PERIOD_PST_STAGING")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EodPeriodPstStaging.findAll", query = "SELECT e FROM EodPeriodPstStaging e"),
    @NamedQuery(name = "EodPeriodPstStaging.findByKey29", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.key29 = :key29"),
    @NamedQuery(name = "EodPeriodPstStaging.findByBankEnt", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.bankEnt = :bankEnt"),
    @NamedQuery(name = "EodPeriodPstStaging.findByPostingtyp", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.postingtyp = :postingtyp"),
    @NamedQuery(name = "EodPeriodPstStaging.findByChgpstAcc", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.chgpstAcc = :chgpstAcc"),
    @NamedQuery(name = "EodPeriodPstStaging.findByChgpstBob", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.chgpstBob = :chgpstBob"),
    @NamedQuery(name = "EodPeriodPstStaging.findByChgpstDte", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.chgpstDte = :chgpstDte"),
    @NamedQuery(name = "EodPeriodPstStaging.findByChgpstPbr", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.chgpstPbr = :chgpstPbr"),
    @NamedQuery(name = "EodPeriodPstStaging.findByChgpstDlr", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.chgpstDlr = :chgpstDlr"),
    @NamedQuery(name = "EodPeriodPstStaging.findByChgpstAma", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.chgpstAma = :chgpstAma"),
    @NamedQuery(name = "EodPeriodPstStaging.findByDrCrFlg", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.drCrFlg = :drCrFlg"),
    @NamedQuery(name = "EodPeriodPstStaging.findByChgpstTcd", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.chgpstTcd = :chgpstTcd"),
    @NamedQuery(name = "EodPeriodPstStaging.findByChgpstCcy", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.chgpstCcy = :chgpstCcy"),
    @NamedQuery(name = "EodPeriodPstStaging.findByChgpstNr1", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.chgpstNr1 = :chgpstNr1"),
    @NamedQuery(name = "EodPeriodPstStaging.findByChgpstNr2", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.chgpstNr2 = :chgpstNr2"),
    @NamedQuery(name = "EodPeriodPstStaging.findByChgpstNr3", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.chgpstNr3 = :chgpstNr3"),
    @NamedQuery(name = "EodPeriodPstStaging.findByChgpstNr4", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.chgpstNr4 = :chgpstNr4"),
    @NamedQuery(name = "EodPeriodPstStaging.findByChgpstAnm", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.chgpstAnm = :chgpstAnm"),
    @NamedQuery(name = "EodPeriodPstStaging.findByChgpstBin", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.chgpstBin = :chgpstBin"),
    @NamedQuery(name = "EodPeriodPstStaging.findByRelCustsb", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.relCustsb = :relCustsb"),
    @NamedQuery(name = "EodPeriodPstStaging.findByRelCust", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.relCust = :relCust"),
    @NamedQuery(name = "EodPeriodPstStaging.findByRelCustyp", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.relCustyp = :relCustyp"),
    @NamedQuery(name = "EodPeriodPstStaging.findByRelACode", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.relACode = :relACode"),
    @NamedQuery(name = "EodPeriodPstStaging.findByRelPCnty", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.relPCnty = :relPCnty"),
    @NamedQuery(name = "EodPeriodPstStaging.findByRelPc", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.relPc = :relPc"),
    @NamedQuery(name = "EodPeriodPstStaging.findByExtfield", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.extfield = :extfield"),
    @NamedQuery(name = "EodPeriodPstStaging.findByUnposted", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.unposted = :unposted"),
    @NamedQuery(name = "EodPeriodPstStaging.findByAccType", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.accType = :accType"),
    @NamedQuery(name = "EodPeriodPstStaging.findByCusSbb", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.cusSbb = :cusSbb"),
    @NamedQuery(name = "EodPeriodPstStaging.findByCusMnm", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.cusMnm = :cusMnm"),
    @NamedQuery(name = "EodPeriodPstStaging.findByParty", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.party = :party"),
    @NamedQuery(name = "EodPeriodPstStaging.findByTenorend", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.tenorend = :tenorend"),
    @NamedQuery(name = "EodPeriodPstStaging.findByTenorstart", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.tenorstart = :tenorstart"),
    @NamedQuery(name = "EodPeriodPstStaging.findByUsercode1", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.usercode1 = :usercode1"),
    @NamedQuery(name = "EodPeriodPstStaging.findByUsercode2", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.usercode2 = :usercode2"),
    @NamedQuery(name = "EodPeriodPstStaging.findByUsercode3", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.usercode3 = :usercode3"),
    @NamedQuery(name = "EodPeriodPstStaging.findByWorkgroup", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.workgroup = :workgroup"),
    @NamedQuery(name = "EodPeriodPstStaging.findByPeriodChg", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.periodChg = :periodChg"),
    @NamedQuery(name = "EodPeriodPstStaging.findByPosteddate", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.posteddate = :posteddate"),
    @NamedQuery(name = "EodPeriodPstStaging.findByTypeflag", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.typeflag = :typeflag"),
    @NamedQuery(name = "EodPeriodPstStaging.findByTstamp", query = "SELECT e FROM EodPeriodPstStaging e WHERE e.tstamp = :tstamp")})
public class EodPeriodPstStaging implements Serializable {
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    private BigDecimal key29;
    @Column(name = "BANK_ENT")
    private String bankEnt;
    private String postingtyp;
    @Column(name = "CHGPST_ACC")
    private String chgpstAcc;
    @Column(name = "CHGPST_BOB")
    private String chgpstBob;
    @Column(name = "CHGPST_DTE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date chgpstDte;
    @Column(name = "CHGPST_PBR")
    private String chgpstPbr;
    @Column(name = "CHGPST_DLR")
    private String chgpstDlr;
    @Column(name = "CHGPST_AMA")
    private Long chgpstAma;
    @Column(name = "DR_CR_FLG")
    private Character drCrFlg;
    @Column(name = "CHGPST_TCD")
    private String chgpstTcd;
    @Column(name = "CHGPST_CCY")
    private String chgpstCcy;
    @Column(name = "CHGPST_NR1")
    private String chgpstNr1;
    @Column(name = "CHGPST_NR2")
    private String chgpstNr2;
    @Column(name = "CHGPST_NR3")
    private String chgpstNr3;
    @Column(name = "CHGPST_NR4")
    private String chgpstNr4;
    @Column(name = "CHGPST_ANM")
    private String chgpstAnm;
    @Column(name = "CHGPST_BIN")
    private String chgpstBin;
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
    private BigInteger extfield;
    private Character unposted;
    @Column(name = "ACC_TYPE")
    private String accType;
    @Column(name = "CUS_SBB")
    private String cusSbb;
    @Column(name = "CUS_MNM")
    private String cusMnm;
    private BigInteger party;
    @Temporal(TemporalType.TIMESTAMP)
    private Date tenorend;
    @Temporal(TemporalType.TIMESTAMP)
    private Date tenorstart;
    private String usercode1;
    private String usercode2;
    private String usercode3;
    private String workgroup;
    @Column(name = "PERIOD_CHG")
    private BigInteger periodChg;
    @Temporal(TemporalType.TIMESTAMP)
    private Date posteddate;
    private BigInteger typeflag;
    private BigInteger tstamp;

    public EodPeriodPstStaging() {
    }

    public EodPeriodPstStaging(BigDecimal key29) {
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

    public String getPostingtyp() {
        return postingtyp;
    }

    public void setPostingtyp(String postingtyp) {
        this.postingtyp = postingtyp;
    }

    public String getChgpstAcc() {
        return chgpstAcc;
    }

    public void setChgpstAcc(String chgpstAcc) {
        this.chgpstAcc = chgpstAcc;
    }

    public String getChgpstBob() {
        return chgpstBob;
    }

    public void setChgpstBob(String chgpstBob) {
        this.chgpstBob = chgpstBob;
    }

    public Date getChgpstDte() {
        return chgpstDte;
    }

    public void setChgpstDte(Date chgpstDte) {
        this.chgpstDte = chgpstDte;
    }

    public String getChgpstPbr() {
        return chgpstPbr;
    }

    public void setChgpstPbr(String chgpstPbr) {
        this.chgpstPbr = chgpstPbr;
    }

    public String getChgpstDlr() {
        return chgpstDlr;
    }

    public void setChgpstDlr(String chgpstDlr) {
        this.chgpstDlr = chgpstDlr;
    }

    public Long getChgpstAma() {
        return chgpstAma;
    }

    public void setChgpstAma(Long chgpstAma) {
        this.chgpstAma = chgpstAma;
    }

    public Character getDrCrFlg() {
        return drCrFlg;
    }

    public void setDrCrFlg(Character drCrFlg) {
        this.drCrFlg = drCrFlg;
    }

    public String getChgpstTcd() {
        return chgpstTcd;
    }

    public void setChgpstTcd(String chgpstTcd) {
        this.chgpstTcd = chgpstTcd;
    }

    public String getChgpstCcy() {
        return chgpstCcy;
    }

    public void setChgpstCcy(String chgpstCcy) {
        this.chgpstCcy = chgpstCcy;
    }

    public String getChgpstNr1() {
        return chgpstNr1;
    }

    public void setChgpstNr1(String chgpstNr1) {
        this.chgpstNr1 = chgpstNr1;
    }

    public String getChgpstNr2() {
        return chgpstNr2;
    }

    public void setChgpstNr2(String chgpstNr2) {
        this.chgpstNr2 = chgpstNr2;
    }

    public String getChgpstNr3() {
        return chgpstNr3;
    }

    public void setChgpstNr3(String chgpstNr3) {
        this.chgpstNr3 = chgpstNr3;
    }

    public String getChgpstNr4() {
        return chgpstNr4;
    }

    public void setChgpstNr4(String chgpstNr4) {
        this.chgpstNr4 = chgpstNr4;
    }

    public String getChgpstAnm() {
        return chgpstAnm;
    }

    public void setChgpstAnm(String chgpstAnm) {
        this.chgpstAnm = chgpstAnm;
    }

    public String getChgpstBin() {
        return chgpstBin;
    }

    public void setChgpstBin(String chgpstBin) {
        this.chgpstBin = chgpstBin;
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

    public BigInteger getExtfield() {
        return extfield;
    }

    public void setExtfield(BigInteger extfield) {
        this.extfield = extfield;
    }

    public Character getUnposted() {
        return unposted;
    }

    public void setUnposted(Character unposted) {
        this.unposted = unposted;
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

    public BigInteger getPeriodChg() {
        return periodChg;
    }

    public void setPeriodChg(BigInteger periodChg) {
        this.periodChg = periodChg;
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
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EodPeriodPstStaging)) {
            return false;
        }
        EodPeriodPstStaging other = (EodPeriodPstStaging) object;
        if ((this.key29 == null && other.key29 != null) || (this.key29 != null && !this.key29.equals(other.key29))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bs.themebridge.entity.model.EodPeriodPstStaging[ key29=" + key29 + " ]";
    }
    
}
