package com.fanr.server.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
            "username",
            "password"
    })
    @XmlRootElement(name = "getLoginRequest")
    public class GetLoginRequest {

        @XmlElement(required = true)
        protected String username;
        @XmlElement(required = true)
        protected String password;


    }

