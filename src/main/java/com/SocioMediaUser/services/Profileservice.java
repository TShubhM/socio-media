package com.SocioMediaUser.services;

import com.SocioMediaUser.Dto.ProfileRequest;
import com.SocioMediaUser.model.Profile;

public interface Profileservice {


    //update
    String editProfile(String id, ProfileRequest p);
    //delete profile
   String deleteProfile(String user_id);

     Profile getProfile(String userName);

}
