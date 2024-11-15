package com.kienluu.demo.service;

import com.kienluu.demo.entity.UserEntity;
import com.kienluu.demo.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService {
    private  UserRepository userRepository;

    public UserEntity getUserByUsername(String username) {
        return userRepository.findByName(username)
                .orElseThrow(()->new RuntimeException("User not found"));
    }

    public void saveUser(UserEntity user) {
        userRepository.save(user);
    }

}
