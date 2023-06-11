package com.moviebookingAuth.authorizationService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.moviebookingAuth.authorizationService.model.JwtRequest;
import com.moviebookingAuth.authorizationService.model.JwtResponse;
import com.moviebookingAuth.authorizationService.model.User;
import com.moviebookingAuth.authorizationService.service.JwtService;

@org.springframework.web.bind.annotation.RestController
@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("api/v1.0")
public class JwtController {
	@Autowired
    private JwtService jwtService;

    @PostMapping({"/authenticate"})
    public JwtResponse createJwtToken(@RequestBody JwtRequest jwtRequest) throws Exception {
    	System.out.println("JWT Auth is called");
    	System.out.println(jwtRequest.getUserName());
    	User reqUser = new User();
    	reqUser.setUserName(jwtRequest.getUserName());
    	reqUser.setUserPassword(jwtRequest.getUserPassword());
    	
//    	jwtRequest = reqUser;
    	
    	JwtResponse res = jwtService.createJwtToken(jwtRequest);
    	
    	System.out.println("Logging my response");
    	System.out.println("Token -> " + res.getJwtToken());
    	System.out.println("User " + res.getUser().getUserName());
    	
    	System.out.println("Result : jwt ");
    	System.out.println(res);
    	
        return res;
    }
}