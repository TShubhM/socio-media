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


//    This method is not understandable what it is returning and input given to it.
//    If you have already followed that user then it should not add it to repository and should return message
    @PostMapping("/create")
    public Followers createFollower(@RequestBody FollowersRequest followersRequest){
        Followers followers=service.createFollowers(followersRequest.getFollowingUsername(), followersRequest.getFollowedUsername());
        return followers;
    }

//   This method is not working
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

//    This should be GetMapping, it is only returning boolean value
    @PostMapping("/isFollower")
    public boolean isfollower(@RequestBody FollowersRequest followersRequest){
        return service.isFollower(followersRequest.getFollowingUsername(),followersRequest.getFollowedUsername());
    }
}
