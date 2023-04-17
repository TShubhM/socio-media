package com.SocioMediaUser.services.impl;

import com.SocioMediaUser.model.Followers;
import com.SocioMediaUser.model.Following;
import com.SocioMediaUser.model.User;
import com.SocioMediaUser.repositories.FollowersRepo;
import com.SocioMediaUser.repositories.FollowingRepo;
import com.SocioMediaUser.repositories.UserRepository;
import com.SocioMediaUser.services.FollowersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@Service
public class FollowersServiceImpl implements FollowersService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    FollowersRepo followersRepo;
    @Autowired
    FollowingRepo followingRepo;
    //here following user means  user who is being followed here suppose user sarala and follower is sara
    @Override
    public Followers createFollowers(String followingUsername, String followedUsername) {
        User followingUser=userRepo.findById(followingUsername).orElseThrow(()->new EntityNotFoundException());
        User followedUser=userRepo.findById(followedUsername).orElseThrow(()-> new EntityNotFoundException());
      List<Followers> followersList=getFollowersByUser(followingUsername);
        if(followersList.stream().anyMatch(f->f.getFollowedUser().equals(followingUser))){
            throw new RuntimeException("User is already  your follower");
        }
        // Check if the followedUser is already being followed by the followingUser
       else{ Followers follower=new Followers();
        follower.setFollowedUser(followedUser);
        follower.setFollowingUser(followingUser);
        followersRepo.save(follower);

        Following following = new Following();
        following.setFollowedUser(followingUser);
        following.setFollowingUser(followedUser);
        followingRepo.save(following);

        return follower;}
    }

    @Override
    public String deleteFollowers(String followingusername, String followedusername) {
        User followingUser = userRepo.findById(followingusername).orElseThrow(() -> new EntityNotFoundException("User not found"));
        User followedUser = userRepo.findById(followedusername).orElseThrow(() -> new EntityNotFoundException("User not found"));
        Followers followers=followersRepo.findByFollowingUserAndFollowedUser(followedUser,followingUser ).orElseThrow(()->new RuntimeException("Not found"));
        followersRepo.delete(followers);
        Following following=followingRepo.findByFollowingUserAndFollowedUser(followingUser, followedUser).orElseThrow(()->new RuntimeException("Not found"));
        followingRepo.delete(following);

        return "Unfollow Successfully!!";
    }

    @Override
    public List<Followers> getFollowersByUser(String username) {
        User user=userRepo.findById(username).orElseThrow(()-> new RuntimeException("User not found!!"));
        List<Followers> followers=followersRepo.findByFollowingUser(user);
        if(followers.isEmpty())
            throw new RuntimeException("List is empty");
        return followers;
    }

    @Override
    public boolean isFollower(String followingUsername, String followedUsername) {
        User followingUser = userRepo.findById(followingUsername).orElseThrow(() -> new EntityNotFoundException("User not found"));
        User followedUser = userRepo.findById(followedUsername).orElseThrow(() -> new EntityNotFoundException("User not found"));
      if(followersRepo.findByFollowingUserAndFollowedUser(followingUser,followedUser).isPresent())
        return true;
      else
          return false;
    }

    @Override
    public int getFollowersCount(String userName) {
        User followingUser = userRepo.findById(userName).orElseThrow(() -> new EntityNotFoundException("User not found"));
        List<Followers> followers= followersRepo.findByFollowingUser(followingUser);
        return followers.size();

    }
}
