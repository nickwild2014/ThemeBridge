//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vJAXB 2.1.10 in JDK 6 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2014.07.22 at 03:37:05 PM IST 
//


package com.misys.tiplus2.apps.ti.service.common;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for GWRAttachmentNarrative.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="GWRAttachmentNarrative">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="a"/>
 *     &lt;enumeration value="x"/>
 *     &lt;enumeration value="h"/>
 *     &lt;enumeration value="l"/>
 *     &lt;enumeration value="c"/>
 *     &lt;enumeration value="y"/>
 *     &lt;enumeration value="d"/>
 *     &lt;enumeration value="e"/>
 *     &lt;enumeration value="f"/>
 *     &lt;enumeration value="p"/>
 *     &lt;enumeration value="q"/>
 *     &lt;enumeration value="r"/>
 *     &lt;minLength value="1"/>
 *     &lt;maxLength value="1"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "GWRAttachmentNarrative")
@XmlEnum
public enum GWRAttachmentNarrative {

    @XmlEnumValue("a")
    A("a"),
    @XmlEnumValue("x")
    X("x"),
    @XmlEnumValue("h")
    H("h"),
    @XmlEnumValue("l")
    L("l"),
    @XmlEnumValue("c")
    C("c"),
    @XmlEnumValue("y")
    Y("y"),
    @XmlEnumValue("d")
    D("d"),
    @XmlEnumValue("e")
    E("e"),
    @XmlEnumValue("f")
    F("f"),
    @XmlEnumValue("p")
    P("p"),
    @XmlEnumValue("q")
    Q("q"),
    @XmlEnumValue("r")
    R("r");
    private final String value;

    GWRAttachmentNarrative(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static GWRAttachmentNarrative fromValue(String v) {
        for (GWRAttachmentNarrative c: GWRAttachmentNarrative.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
