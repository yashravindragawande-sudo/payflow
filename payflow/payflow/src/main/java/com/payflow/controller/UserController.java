package com.payflow.controller;

import com.payflow.entity.User;
import com.payflow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User saved = userService.registerUser(user);
        return ResponseEntity.ok(saved);
    }


    @PostMapping("/no-body-demo")
    public ResponseEntity<String> registerUserWithoutRequestBody(User user) {
        return ResponseEntity.ok(
            "name=" + user.getName() +
            ", upiId=" + user.getUpiId() +
            ", phoneNumber=" + user.getPhoneNumber() +
            ", balance=" + user.getBalance()
        );
    }


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }


    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/upi/{upiId}")
    public ResponseEntity<User> getUserByUpiId(@PathVariable String upiId) {
        return userService.findByUpiId(upiId)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/above/{minBalance}")
    public ResponseEntity<List<User>> getUsersWithBalanceAbove(@PathVariable Double minBalance) {
        return ResponseEntity.ok(userService.findUsersWithBalanceAbove(minBalance));
    }
}
