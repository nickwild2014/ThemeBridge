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
 * <p>Java class for GWRBatchCommandGateway.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GWRBatchCommandGateway">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="BYPASS"/>
 *     &lt;enumeration value="CANCEL"/>
 *     &lt;enumeration value="PAUSE"/>
 *     &lt;enumeration value="RESUME"/>
 *     &lt;enumeration value="RETRY"/>
 *     &lt;enumeration value="START"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GWRBatchCommandGateway")
@XmlEnum
public enum GWRBatchCommandGateway {

    BYPASS,
    CANCEL,
    PAUSE,
    RESUME,
    RETRY,
    START;

    public String value() {
        return name();
    }

    public static GWRBatchCommandGateway fromValue(String v) {
        return valueOf(v);
    }

}
