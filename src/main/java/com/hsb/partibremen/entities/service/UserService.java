package com.hsb.partibremen.entities.service;

import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.model.user.UserDto;
import com.hsb.partibremen.entities.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        if(userRepo.findByEmail(userDto.getEmail()) != null) {
            throw new RuntimeException();
        }
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setDob(userDto.getDob());
        user.setVerified(userDto.isVerified());
        user.setRole(userDto.getRole());
        user.setActive(false);
        return userRepo.save(user);
    }

    public List<User> findAll() {
        return userRepo.findAll();
    }

    public Optional<User> findOne(String id) {
        return userRepo.findById(UUID.fromString(id));
    }

    public Optional<User> updateUser(UserDto userDto, String id) {
        Optional<User> optionalUser = userRepo.findById(UUID.fromString(id));
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setName(userDto.getName());
            user.setSurname(userDto.getSurname());
            if(userRepo.findByEmail(userDto.getEmail()) != null) {
                throw new RuntimeException();
            }
            user.setEmail(userDto.getEmail());
            user.setPassword(userDto.getPassword());
            user.setDob(userDto.getDob());
            user.setVerified(userDto.isVerified());
            user.setRole(userDto.getRole());
            userRepo.save(user);
        }
        return optionalUser;
    }

    public void delete(String id) {
        userRepo.deleteById(UUID.fromString(id));
    }


    public User login(String email, String password) {
        User optionalUser = userRepo.findByEmailAndPassword(email, password);
        if( optionalUser != null){
            optionalUser.setActive(true);
            userRepo.save(optionalUser);
            return userRepo.findByEmailAndPassword(email, password);
        }
        throw new RuntimeException("Invalid Login Data");
    }

    public User logout(String userId) {
        Optional<User> optionalUser = findOne(userId);
        if(optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setActive(false);
            return userRepo.save(user);
        }
        throw new RuntimeException("User not found");
    }
}