package com.moviebookingAuth.authorizationService.model;


public class JwtResponse {
	private UserDTO user;
    private String jwtToken;
    private Boolean isValid;

    public JwtResponse(UserDTO user, String jwtToken) {
        this.user = user;
        this.jwtToken = jwtToken;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    
	public Boolean getIsValid() {
		return isValid;
	}

	public void setIsValid(Boolean isValid) {
		this.isValid = isValid;
	}

	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}