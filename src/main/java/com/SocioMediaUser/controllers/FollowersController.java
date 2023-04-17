package com.SocioMediaUser.controllers;

import com.SocioMediaUser.Dto.FollowersRequest;
import com.SocioMediaUser.model.Followers;
import com.SocioMediaUser.repositories.FollowersRepo;
import com.SocioMediaUser.services.FollowersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/followers")
public class FollowersController {
    @Autowired
    FollowersService service;

    @PostMapping("/create")
    public Followers createFollower(@RequestBody FollowersRequest followersRequest){
        Followers followers=service.createFollowers(followersRequest.getFollowingUsername(), followersRequest.getFollowedUsername());
        return followers;
    }
    @DeleteMapping("/delete")
    public String deleteFollower(@RequestBody FollowersRequest followersRequest){
        return service.deleteFollowers(followersRequest.getFollowingUsername(),followersRequest.getFollowedUsername());
    }
    @GetMapping("/getFollowersByUser")
    public List<Followers>  getFollowersByUser(@RequestParam (value="userName")String userName){
        List<Followers>list=service.getFollowersByUser(userName);
        return list;
    }
    @GetMapping("/count")
    public int followersCount(@RequestParam (value = "userName") String userName){
        return service.getFollowersCount(userName);
    }
    @PostMapping("/isFollower")
    public boolean isfollower(@RequestBody FollowersRequest followersRequest){
        return service.isFollower(followersRequest.getFollowingUsername(),followersRequest.getFollowedUsername());
    }
}
