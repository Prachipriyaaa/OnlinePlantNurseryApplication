package com.cg.opna.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.cg.opna.entity.Role;
import com.cg.opna.entity.User;
import com.cg.opna.exceptions.UserNotFoundException;


@Service
public interface IUserService {
	
	
	    User register(User user);
	    User login(User user);
	    User updateUser(Integer id,User customer) throws UserNotFoundException;	
	    User resetPasswordById(Integer id, Map<Object, Object> fields) throws UserNotFoundException;
	    List<User> userByRole(Role role);
	    User removeUser(Integer id);

}