package com.SocioMediaUser.services;

import com.SocioMediaUser.model.Followers;
import com.SocioMediaUser.model.User;

import java.util.List;

public interface FollowersService {
//here following user means  user who is being followed here suppose user sarala and follower is sara
    public Followers createFollowers(String followingUsername, String followedUsername);
    //delete following
    public String deleteFollowers(String followingusername,String followedusername);
    //get following users
    public List<Followers> getFollowersByUser(String username);
    //is following
    public boolean isFollower(String followingUsername,String followedUsername);
    //get following count
    public int getFollowersCount(String userName);
//get Following By Followed User
}
