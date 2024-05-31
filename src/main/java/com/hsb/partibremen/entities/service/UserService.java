package com.hsb.partibremen.entities.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.hsb.partibremen.entities.enums.BlockStatus;
import com.hsb.partibremen.entities.exceptions.InvalidLoginException;
import com.hsb.partibremen.entities.exceptions.UserBlockedException;
import com.hsb.partibremen.entities.exceptions.UserNotFoundException;
import com.hsb.partibremen.entities.model.user.User;
import com.hsb.partibremen.entities.model.user.UserDto;
import com.hsb.partibremen.entities.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public User createUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        if (userRepo.findByEmail(userDto.getEmail()) != null) {
            throw new RuntimeException();
        }
        user.setEmail(userDto.getEmail());
        String hashedPassword = BCrypt.withDefaults().hashToString(12, userDto.getPassword().toCharArray());
        user.setPassword(hashedPassword);
        user.setDob(userDto.getDob());
        user.setVerified(userDto.isVerified());
        user.setRole(userDto.getRole());
        user.setActive(false);
        user.setBlockStatus(BlockStatus.UNBLOCKED);
        user.setBlockUntilDatum(null);
        user.setImg(userDto.getImg());
        return userRepo.save(user);
    }

    public List<User> findAll() {
        return userRepo.findByIsDeleted(false);
    }

    public Optional<User> findOne(String id) throws UserNotFoundException {
        Optional<User> optionalUser = userRepo.findById(UUID.fromString(id));
        if (optionalUser.isPresent()) {
            return optionalUser;
        }
        throw new UserNotFoundException("User not found with ID: " + id);
    }

    public Optional<User> updateUser(UserDto userDto, String id) {
        Optional<User> optionalUser = userRepo.findById(UUID.fromString(id));
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
    
            // Nur Felder aktualisieren, die im UserDto vorhanden sind
            if (userDto.getName() != null) {
                user.setName(userDto.getName());
            }
            if (userDto.getSurname() != null) {
                user.setSurname(userDto.getSurname());
            }
    
            if (userDto.getEmail() != null && !user.getEmail().equals(userDto.getEmail())) {
                if (userRepo.findByEmail(userDto.getEmail()) != null) {
                    throw new RuntimeException("E-Mail-Adresse existiert bereits.");
                }
                user.setEmail(userDto.getEmail());
            }
    
            if (userDto.getPassword() != null) {
                String hashedPassword = BCrypt.withDefaults().hashToString(12, userDto.getPassword().toCharArray());
                user.setPassword(hashedPassword);
            }
    
            if (userDto.getDob() != null) {
                user.setDob(userDto.getDob());
            }
    
            if (userDto.isVerified() != null) {
                user.setVerified(userDto.isVerified());
            }
            
            if (userDto.getRole() != null) {
                user.setRole(userDto.getRole());
            }
            
    
            if (userDto.getBlockStatus() != null) {
                user.setBlockStatus(userDto.getBlockStatus());
                if (userDto.getBlockStatus() == BlockStatus.BLOCKED_UNTIL) {
                    user.setBlockUntilDatum(userDto.getBlockUntilDatum());
                } else {
                    user.setBlockUntilDatum(null);
                }
            }
            if (userDto.getImg() != null) {
                user.setImg(userDto.getImg());
            }
            userRepo.save(user);
        }
        return optionalUser;
    }
    

    public void delete(String id) throws UserNotFoundException{
        Optional<User> optionalUser = findOne(id);
        if(optionalUser != null) {
            User user = optionalUser.get();
            user.setDeleted(true);
            userRepo.save(user);
        }
        //throw new RuntimeException("User not found");
        // userRepo.deleteById(UUID.fromString(id));
    }
    

    public User login(String email, String password) {
        User optionalUser = userRepo.findByEmail(email);
        if (optionalUser == null) {
            throw new InvalidLoginException();
        }

        BCrypt.Result decryptedPassword = BCrypt.verifyer().verify(password.toCharArray(), optionalUser.getPassword());
        if (!decryptedPassword.verified) {
            throw new InvalidLoginException();
        }

        if (optionalUser.getBlockStatus() == BlockStatus.BLOCKED_UNTIL && optionalUser.getBlockUntilDatum() != null) {
            if (optionalUser.getBlockUntilDatum().isBefore(LocalDate.now())) {
                optionalUser.setBlockStatus(BlockStatus.UNBLOCKED);
                optionalUser.setBlockUntilDatum(null);
            } else {
                throw new UserBlockedException("User is blocked until " + optionalUser.getBlockUntilDatum());
            }
        } else if (optionalUser.getBlockStatus() == BlockStatus.PERMANENTLY_BLOCKED) {
            throw new UserBlockedException("User is permanently blocked");
        }

        optionalUser.setActive(true);
        return userRepo.save(optionalUser);
    }

    public User logout(String userId) throws UserNotFoundException {
        Optional<User> optionalUser = findOne(userId);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setActive(false);
            return userRepo.save(user);
        }
        throw new RuntimeException("User not found");
    }

    public User blockUser(String id, LocalDate blockUntilDatum) throws UserNotFoundException {
        Optional<User> optionalUser = findOne(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (blockUntilDatum != null) {
                user.setBlockStatus(BlockStatus.BLOCKED_UNTIL);
                user.setBlockUntilDatum(blockUntilDatum);
            } else {
                user.setBlockStatus(BlockStatus.PERMANENTLY_BLOCKED);
                user.setBlockUntilDatum(null);
            }
            return userRepo.save(user);
        }
        throw new UserNotFoundException("User not found with ID: " + id);
    }

    public User unblockUser(String id) throws UserNotFoundException {
        Optional<User> optionalUser = findOne(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setBlockStatus(BlockStatus.UNBLOCKED);
            user.setBlockUntilDatum(null);
            return userRepo.save(user);
        }
        throw new UserNotFoundException("User not found with ID: " + id);
    }
}
