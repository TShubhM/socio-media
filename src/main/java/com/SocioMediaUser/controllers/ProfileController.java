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

    @PostMapping("/create")
    public String createProfile(@RequestBody ProfileRequest p, @RequestParam String id){
         service.createprofile(id,p);
         return "Profile Created";
    }

}
