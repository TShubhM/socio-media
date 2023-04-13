package com.SocioMediaUser.services;

import com.SocioMediaUser.Dto.ProfileRequest;
import com.SocioMediaUser.model.Profile;

public interface Profileservice {
    //create profile
String createprofile(String id,ProfileRequest p);
    //update
    String editProfile(String id, ProfileRequest p);
    //delete profile
   String deleteProfile(String user_id,int id);



}
