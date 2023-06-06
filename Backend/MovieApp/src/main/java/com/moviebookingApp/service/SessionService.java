package com.moviebookingApp.service;

import org.springframework.http.HttpStatus;

import com.moviebookingApp.exceptions.DuplicateMovieIdExceptions;
import com.moviebookingApp.exceptions.DuplicateMovieNameException;
import com.moviebookingApp.model.Movie;
import com.moviebookingApp.model.SessionDTO;

public interface SessionService {

	
	public HttpStatus addSession(SessionDTO sessionDTO) throws Exception;
	
	public String checkSessionUserType() throws Exception;
	
}
