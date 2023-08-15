package com.example.coursesAppneo4jspringboot.controllers;

import com.example.coursesAppneo4jspringboot.models.User;
import com.example.coursesAppneo4jspringboot.objects.UserDTO;
import com.example.coursesAppneo4jspringboot.requests.CreateUserRequest;
import com.example.coursesAppneo4jspringboot.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public String loggedInUser(Principal principal){
        return principal.getName();
    }

    @PostMapping("/register")
    public ResponseEntity<UserDTO> signUp(@RequestBody CreateUserRequest createUserRequest){
        User user = this.userService.CreateUser(createUserRequest);
        UserDTO responseUserDTO = new UserDTO(user.getUsername(), user.getName(), user.getRoles());
        return new ResponseEntity<>( responseUserDTO, HttpStatus.CREATED);
    }
}
