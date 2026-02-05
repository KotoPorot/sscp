package com.example.demo.service;

import com.example.demo.entity.MyUsersDetails;
import com.example.demo.repository.SimpleUserRep;
import com.example.demo.entity.SimpleUser;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {
private SimpleUserRep rep;

    public MyUserDetailService(SimpleUserRep rep) {
        this.rep = rep;
    }

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<SimpleUser> simpleUser = rep.findByUserName(username);
        if (simpleUser.isPresent()){
            return new MyUsersDetails(simpleUser.get());
        }else {
            throw new UsernameNotFoundException(username);
        }

    }
}
