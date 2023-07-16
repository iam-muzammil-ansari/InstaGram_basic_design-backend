package com.geekster.InstaGram_basic_design.controller;

import com.geekster.InstaGram_basic_design.model.DataToObject.SignInInput;
import com.geekster.InstaGram_basic_design.model.DataToObject.SignUpOutput;
import com.geekster.InstaGram_basic_design.model.User;
import com.geekster.InstaGram_basic_design.service.AuthenticationService;
import com.geekster.InstaGram_basic_design.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping("/signup")
    public SignUpOutput signUp(@RequestBody User user) {
        return  userService.signUp(user);
    }

    @PostMapping("/signin")
    public String signIn(@RequestBody @Valid SignInInput signInInput) {
        return userService.signIn(signInInput);
    }

    @PutMapping("/update")
    public String updateUserDetails(@RequestBody User user ,@RequestParam String email, @RequestParam String token) {
        if(authenticationService.authenticate(email,token)) {
            return userService.updateUserDetails(user);
        }else {
            return "Access Denied!!";
        }
    }

    @GetMapping("/{email}")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @DeleteMapping("/signout")
    public String signOutUser(@RequestParam String email, @RequestParam String token) {
        if (authenticationService.authenticate(email, token)) {
            return userService.signOutUser(email);
        } else {
            return "Sign out not allowed for non-authenticated user.";
        }
    }



}
