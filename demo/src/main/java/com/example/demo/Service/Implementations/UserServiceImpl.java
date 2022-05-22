package com.example.demo.Service.Implementations;

import com.example.demo.Model.User;
import java.lang.Iterable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.Service.UserService;
import com.example.demo.Repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUser(String id){
        User response = null;
        if(userRepository.existsById(id)){
            Iterable<User> users = userRepository.getUser(id);
            for(User user : users){
                response = user;
            }
            return response;
        }
        return response;
    }

    @Override
    public User addUser(User user){
        return userRepository.save(user); //con javascript ya hacemos la comprobación de que
    }                                       //ni user ni password sean nulos

    @Override
    public User updateUser(User user){
        if(userRepository.existsById(String.valueOf(user.getId()))){
            return userRepository.save(user);
        } else {
            return null;
        }
    }

    @Override
    public void deleteUser(String id){
        userRepository.deleteById(id);
    }


    @Override
    public UserDetails loadUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        List<GrantedAuthority> authorities = new ArrayList<>();
        UserDetails newUser = new User(user.getEmail(), user.getPassword(), authorities);
        return newUser;
    }
}
