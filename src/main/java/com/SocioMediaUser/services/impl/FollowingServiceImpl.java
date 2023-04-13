package com.SocioMediaUser.services.impl;

import com.SocioMediaUser.model.Following;
import com.SocioMediaUser.model.User;
import com.SocioMediaUser.repositories.FollowingRepo;
import com.SocioMediaUser.repositories.UserRepository;
import com.SocioMediaUser.services.FollowingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class FollowingServiceImpl implements FollowingService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    FollowingRepo followingRepo;
    @Override
    public Following createFollowing(String followingUsername, String followedUsername) {
        User followingUser=userRepository.findById(followingUsername).orElseThrow(() -> new EntityNotFoundException("User not found"));
        User followedUser=userRepository.findById(followedUsername).orElseThrow(() -> new EntityNotFoundException("User not found"));
        Following following=new Following();
        following.setFollowedUser(followedUser);
        following.setFollowingUser(followingUser);

        followingRepo.save(following);
        return following;
    }

    @Override
    public String deleteFollowing(String followingUsername,String followedUsername) {
        User followingUser=userRepository.findById(followingUsername).orElseThrow(() -> new EntityNotFoundException("User not found"));
        User followedUser=userRepository.findById(followedUsername).orElseThrow(() -> new EntityNotFoundException("User not found"));
        List<Following> followings=followingRepo.findAllByFollowedUser(followedUser);
       for(Following following:followings) {
           if (following.getFollowingUser().equals(followingUser)) {
               followingRepo.delete(following);
               return "Following Deleted Successfully!!";
           }
       }
       return "Something went wrong!!";
    }

    @Override
    public List<Following> getFollowingByUser(String username) {
        User followedUser=userRepository.findById(username).orElseThrow(() -> new EntityNotFoundException("User not found"));
      List<Following> followings=followingRepo.findAllByFollowedUser(followedUser);
        return followings;
    }

    @Override
    public boolean isFollowing(String followingUsername,String followedUsername) {
        User followingUser=userRepository.findById(followingUsername).orElseThrow(() -> new EntityNotFoundException("User not found"));
        User followedUser=userRepository.findById(followedUsername).orElseThrow(() -> new EntityNotFoundException("User not found"));
        List<Following> followings=followingRepo.findAllByFollowedUser(followedUser);
        for(Following following:followings) {
            if (following.getFollowingUser().equals(followingUser))
                return true;

            }
            return false;
    }

    @Override
    public int getFollowingCount(String userName) {
        User followedUser=userRepository.findById(userName).orElseThrow(() -> new EntityNotFoundException("User not found"));
        List<Following> followings=followingRepo.findAllByFollowedUser(followedUser);
            return followings.size();
    }


}
