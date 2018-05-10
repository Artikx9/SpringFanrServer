package com.fanr.server.soap;

import javax.xml.bind.annotation.XmlRegistry;

@XmlRegistry
public class ObjectFactory {


    public ObjectFactory() {
    }

    public GetLoginResponse createGetRecipeResponse() {
        return new GetLoginResponse();
    }


    public GetLoginResponse createRecipeSoap() {
        return new GetLoginResponse();
    }


    public GetLoginRequest createGetRecipeRequest() {
        return new GetLoginRequest();
    }

}
