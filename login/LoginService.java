package com.ubb.login.service;

import com.ubb.login.domain.Login;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class LoginService {

    private List<Login> users=new ArrayList<>(Arrays.asList(new Login("andrada5@yahoo.com","secure")));

    public List<Login> getUsers() {
        return users;
    }
}
