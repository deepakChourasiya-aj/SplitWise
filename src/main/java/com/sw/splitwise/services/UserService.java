package com.sw.splitwise.services;

import com.sw.splitwise.models.User;
import com.sw.splitwise.repositories.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createNewUser(String name, String email, String password) throws RuntimeException {
        // check if already user exist

        Optional<User> isUserExist = userRepository.findByEmail(email);
        if(isUserExist.isPresent()) {
            throw new RuntimeException("User already exists with email " + email);
        }

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(bCryptPasswordEncoder.encode(password));

        return userRepository.save(user);
    }

}
