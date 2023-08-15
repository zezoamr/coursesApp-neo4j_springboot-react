package com.example.coursesAppneo4jspringboot.services;

import com.example.coursesAppneo4jspringboot.models.User;
import com.example.coursesAppneo4jspringboot.repositories.UserRepository;
import com.example.coursesAppneo4jspringboot.requests.CreateUserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User CreateUser(CreateUserRequest createUserRequest) throws ResponseStatusException {
        Optional<User> userIfExists = this.userRepository.findUserByUsername(createUserRequest.getUsername());
        if (userIfExists.isPresent()) throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        User user = new User();
        user.setName(createUserRequest.getName());
        user.setRoles(createUserRequest.getRoles());
        user.setUsername(createUserRequest.getUsername());
        user.setPassword(this.passwordEncoder.encode( createUserRequest.getPassword() ));

        this.userRepository.save(user);

        return user;
    }
}
