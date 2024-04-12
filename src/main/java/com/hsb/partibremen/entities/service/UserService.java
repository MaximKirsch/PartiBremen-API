package com.hsb.partibremen.entities.service;

import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.util.BaseService;

import java.util.ArrayList;
import java.util.List;

public class UserService extends BaseService {
    public ArrayList<User> userList = new ArrayList<>();

    public ArrayList<User> findAll(){
        return this.userList;
    }

    public User findOne(String id){
        for (User user : this.userList){
            if(user.id.toString().equals(id)){
                return user;
            }
        }
        return null;
    }

    public User login(String emailAdress, String password){
        for (User user : this.userList){
            if(user.getEmail().equals(emailAdress) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }
    

}
