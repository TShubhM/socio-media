package com.SocioMediaUser.controllers;

import com.SocioMediaUser.Dto.Followingrequest;
import com.SocioMediaUser.model.Following;
import com.SocioMediaUser.services.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/following")
public class Followingcontroller {
    @Autowired
    FollowingService service;

    @PostMapping("/create")
    public ResponseEntity<Following> createFollowing(@RequestBody Followingrequest followingrequest) {
        Following following = service.createFollowing(followingrequest.getFollowingUsername(), followingrequest.getFollowedUsername());
        return ResponseEntity.status(HttpStatus.CREATED).body(following);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteFollowing(@RequestBody Followingrequest followingrequest) {
        String s = service.deleteFollowing(followingrequest.getFollowingUsername(),followingrequest.getFollowedUsername());
        return ResponseEntity.status(HttpStatus.OK).body(s);
    }


    @GetMapping("/getFollowingByUser")
    public ResponseEntity<List<Following>> getFollowingByUser(@RequestParam(value="userName") String username) {
        List<Following> list = service.getFollowingByUser(username);
        if(!list.isEmpty()){

        return ResponseEntity.status(HttpStatus.OK).body(list);}
        else throw new RuntimeException("List is empty!!");

    }

    @PostMapping("/isFollowing")
    public boolean isFollowing(@RequestBody Followingrequest followingrequest) {

        return service.isFollowing(followingrequest.getFollowingUsername(),followingrequest.getFollowedUsername());
    }

    @GetMapping("/count")
    public int getFollowingCount(@RequestParam(value="userName") String userName) {
        return service.getFollowingCount(userName);
    }
}
