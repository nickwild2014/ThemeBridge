//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.22 at 03:37:05 PM IST 
//


package com.misys.tiplus2.apps.ti.service.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GWRMasterStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GWRMasterStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BKF"/>
 *     &lt;enumeration value="CAN"/>
 *     &lt;enumeration value="EXP"/>
 *     &lt;enumeration value="LIV"/>
 *     &lt;enumeration value="NEW"/>
 *     &lt;enumeration value="PRV"/>
 *     &lt;minLength value="1"/>
 *     &lt;maxLength value="4"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GWRMasterStatus")
@XmlEnum
public enum GWRMasterStatus {

    BKF,
    CAN,
    EXP,
    LIV,
    NEW,
    PRV;

    public String value() {
        return name();
    }

    public static GWRMasterStatus fromValue(String v) {
        return valueOf(v);
    }

}
