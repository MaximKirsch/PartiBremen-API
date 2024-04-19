package com.hsb.partibremen.entities.service;

import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.repo.UserRepo;
import com.hsb.partibremen.entities.util.BaseService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService extends BaseService {
    public UserRepo userRepo;

    public void createUser(User user){
        userRepo.save(user);
    }
    public List<User> findAll(){
        return userRepo.findAll();
    }

    public Optional<User> findOne(String id){
        return userRepo.findById(UUID.fromString(id));
    }

    public void delete(String id) {
        userRepo.deleteById(UUID.fromString(id));
    }

    public User login(String emailAdress, String password){
        return null;
    }
    

}
