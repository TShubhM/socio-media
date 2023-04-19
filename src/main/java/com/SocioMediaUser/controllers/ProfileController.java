package com.SocioMediaUser.controllers;

import com.SocioMediaUser.Dto.ProfileRequest;
import com.SocioMediaUser.model.Profile;
import com.SocioMediaUser.services.Profileservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Profile")
public class ProfileController {
    @Autowired
    Profileservice service;


    @GetMapping("/getDetails")
    public Profile getdetails(@RequestParam (value="userName") String userName){
       return service.getProfile(userName);
    }
//    There should be reset instead of deleting profile
//    profile should be deleted only when user gets deleted
    @DeleteMapping("/deleteProfile")
    public String deleteProfile(@RequestParam (value="userName") String userName){
        return service.deleteProfile(userName);
    }

    @PutMapping("/update")
    public String updateProfile(@RequestParam(value="userName") String id,@RequestBody ProfileRequest p){
       return service.editProfile(id,p);

    }

}
