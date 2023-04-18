package com.SocioMediaUser.services.impl;

import com.SocioMediaUser.Dto.ProfileRequest;
import com.SocioMediaUser.model.Followers;
import com.SocioMediaUser.model.Following;
import com.SocioMediaUser.model.Profile;
import com.SocioMediaUser.model.User;
import com.SocioMediaUser.repositories.FollowersRepo;
import com.SocioMediaUser.repositories.FollowingRepo;
import com.SocioMediaUser.repositories.ProfileRepo;
import com.SocioMediaUser.repositories.UserRepository;
import com.SocioMediaUser.services.FollowersService;
import com.SocioMediaUser.services.FollowingService;
import com.SocioMediaUser.services.Profileservice;
import com.SocioMediaUser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProfileServiceImpl implements Profileservice {
    @Autowired
    ProfileRepo repo;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepo;
    @Autowired
    FollowersRepo followersRepo;
    @Autowired
    FollowingRepo followingRepo;
    @Autowired
    FollowersService followersService;
    @Autowired
    FollowingService followingService;



    @Override

    public String editProfile(String id, ProfileRequest p) {
       Profile profile= repo.findByUserName(id);
       if(profile!=null){
             profile = profileMapToProfileRequest(p,id);
             profile.setFollowersCount(followersService.getFollowersCount(id));
             profile.setFollowingcount(followingService.getFollowingCount(id));
            repo.save(profile);
            return "Profile updated successfully!!";
        } else
            return "No user found by this user_id";
    }

    @Override
    public String deleteProfile(String userid) {
        Profile profile = repo.findByUserName(userid);
        if(profile!=null){
            repo.deleteById(profile.getId());
         userRepo.deleteById(userid);
         return "Profile Delete successfully!!!";}
        else
            return "Profile not created yet!!";
    }


    @Override
    public Profile getProfile(String userName) {
        User user = userRepo.findById(userName).orElseThrow(() -> new RuntimeException("User not found !!"));
        List<Followers> followers = followersRepo.findByFollowingUser(user);
        List<Following> following = followingRepo.findByFollowedUser(user);
        Profile profile = repo.findByUserName(user.getUserName());
        profile.setFollowingcount(followers.size());
        profile.setFollowingcount(following.size());
        return profile;
    }


    public Profile profileMapToProfileRequest(ProfileRequest p,String id) {
        Profile profile = repo.findByUserName(id);
        profile.setBio(p.getBio());
        profile.setProfilepic(p.getProfilepic());
        profile.setCoverPhoto(p.getCoverPhoto());

        return profile;
    }
}
