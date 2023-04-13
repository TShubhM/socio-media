package com.SocioMediaUser.services.impl;

import com.SocioMediaUser.Dto.ProfileRequest;
import com.SocioMediaUser.model.Profile;
import com.SocioMediaUser.repositories.ProfileRepo;
import com.SocioMediaUser.repositories.UserRepository;
import com.SocioMediaUser.services.Profileservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfileServiceImpl implements Profileservice {
    @Autowired
    ProfileRepo repo;
    @Autowired
    UserRepository userRepo;
    @Override
    public String createprofile(String id,ProfileRequest p) {
        if(userRepo.existsById(id)) {
            Profile profile = profileMapToProfileRequest(p);
            repo.save(profile);
            return "Profile created successfully!!";}
        else
            return "No user found by this user_id";

    }

    @Override
    public String editProfile(String id, ProfileRequest p) {
        if(userRepo.existsById(id)){
        Profile profile=profileMapToProfileRequest(p);
        repo.save(profile);
        return "Profile updated successfully!!";}
        else
            return "No user found by this user_id";
    }

    @Override
    public String deleteProfile(String userid,int id) {
        if(userRepo.existsById(userid)){
    Profile profile =  repo.findById(id).orElseThrow();
    repo.deleteById(id);
        return "Profile Delete successfully!!!";}
        else return "No user found by this user_id";
    }

//    @Override
//    public Profile getProfiledetails(String id) {
//      return repo.findByUser1Id(id);
//    }


    public Profile profileMapToProfileRequest(ProfileRequest p){
        Profile profile=new Profile();
        profile.setBio(p.getBio());
        profile.setProfilepic(p.getProfilepic());
        profile.setCoverPhoto(p.getCoverPhoto());

        return profile;
    }
}
