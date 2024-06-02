package com.example.qlbh_mypham.services;

import com.example.qlbh_mypham.models.User;
import com.example.qlbh_mypham.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> authenticate(String username, String password) {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            return user;
        }
        return Optional.empty();
    }

    public boolean register(String username, String password) {
        if (userRepository.findByUsername(username).isPresent()) {
            return false;
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return true;
    }
}
