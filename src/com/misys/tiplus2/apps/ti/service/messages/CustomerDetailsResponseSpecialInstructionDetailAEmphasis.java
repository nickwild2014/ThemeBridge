//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.01.29 at 06:14:37 PM IST 
//


package com.misys.tiplus2.apps.ti.service.messages;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerDetailsResponse_SpecialInstructionDetailA_Emphasis.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CustomerDetailsResponse_SpecialInstructionDetailA_Emphasis">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="N"/>
 *     &lt;enumeration value="Y"/>
 *     &lt;minLength value="1"/>
 *     &lt;maxLength value="1"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CustomerDetailsResponse_SpecialInstructionDetailA_Emphasis")
@XmlEnum
public enum CustomerDetailsResponseSpecialInstructionDetailAEmphasis {

    N,
    Y;

    public String value() {
        return name();
    }

    public static CustomerDetailsResponseSpecialInstructionDetailAEmphasis fromValue(String v) {
        return valueOf(v);
    }

}