package com.heli.service;

import com.heli.config.JwtProvider;
import com.heli.model.User;
import com.heli.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserByJwtToken(String jwt) throws Exception {

        String email = jwtProvider.getEmailFromJwtToken(jwt);
        User user = findUserByEmail(email);
        return user;
    }

    @Override
    public User findUserByEmail(String emil) throws Exception {

        User user = userRepository.findByEmail(emil);

        if(user == null){
            throw new Exception("User not found");
        }

        return user;

    }
}
