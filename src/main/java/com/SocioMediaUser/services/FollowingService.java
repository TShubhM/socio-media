package com.SocioMediaUser.services;

import com.SocioMediaUser.model.Following;
import com.SocioMediaUser.model.User;

import java.util.List;

public interface FollowingService {
    //Create following
    public Following createFollowing(String followingUsername, String followedUsername);
    //delete following
    public String deleteFollowing(String followingusername,String followedusername);
    //get following users
    public List<Following> getFollowingByUser(String username);
    //is following
    public boolean isFollowing(String followingUsername,String followedUsername);
    //get following count
    public int getFollowingCount(String userName);
//get Following By Followed User
   // public List<Following> getFollowingByFollowedUser(User followedUser);
}
