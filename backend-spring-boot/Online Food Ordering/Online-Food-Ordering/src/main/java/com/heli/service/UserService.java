package com.heli.service;

import com.heli.model.User;

public interface UserService {

    public User findUserByJwtToken(String jwt) throws Exception;

    public User findUserByEmail(String emil) throws Exception;

}


