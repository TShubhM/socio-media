package com.SocioMediaUser.controllers;

import com.SocioMediaUser.model.Profile;
import com.SocioMediaUser.model.User;
import com.SocioMediaUser.Dto.UserRequest;
import com.SocioMediaUser.services.UserService;
import com.SocioMediaUser.services.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    public ResponseEntity<User> createNewUser(@RequestBody UserRequest user) {
       // return ResponseEntity.status(HttpStatus.OK).body(service.createUser(user));
        User user1 = service.createUser(user);
//        System.out.println(user1);
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    @PutMapping("/{userName}/{password}")
    public ResponseEntity<User> updateExistingUser(@PathVariable String userName, @PathVariable String password, @RequestBody UserRequest user,@PathVariable Integer test) {
        User user1 = service.updateUser(userName, password, user);
        return ResponseEntity.status(HttpStatus.OK).body(user1);
    }

//not working properly 500 Internal Server Error
    @DeleteMapping("/{userName}/{password}")
    public ResponseEntity<String> deleteUser(@PathVariable String userName, @PathVariable String password) {

        return ResponseEntity.status(HttpStatus.OK).body(service.deleteUser(userName, password));
    }

    @GetMapping("/validity/{userName}")
    public ResponseEntity<Boolean> userValidityCheck(@PathVariable String userName){
        return ResponseEntity.status(HttpStatus.OK).body(service.userValidityChecking(userName));
    }




}
