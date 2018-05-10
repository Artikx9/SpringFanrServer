package com.fanr.server.soap;


import com.fanr.server.model.Recipe;
import com.fanr.server.repository.RecipeRepository;
import com.fanr.server.repository.UserRepository;
import com.fanr.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class LoginEndpoint {
    private static final String NAMESPACE_URI = "http://artik.com/soap";


    private UserService userService;


    private UserRepository userRepository;



    @Autowired
    public LoginEndpoint(UserRepository usersRepository, UserService userService){
        this.userRepository = usersRepository;
        this.userService = userService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getLoginRequest")
    @ResponsePayload
    public GetLoginResponse getUser(@RequestPayload GetLoginRequest request){

        GetLoginResponse response = new GetLoginResponse();
        response.setToken(userService.signin(request.username, request.password));
         return response;
    }
}
