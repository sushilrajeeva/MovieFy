package com.moviebookingAuth.authorizationService.repository;



import org.springframework.data.repository.CrudRepository;

import com.moviebookingAuth.authorizationService.model.User;



public interface UserDao extends CrudRepository<User, String>{

}