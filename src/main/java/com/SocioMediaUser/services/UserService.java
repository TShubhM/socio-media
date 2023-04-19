package com.SocioMediaUser.services;

import com.SocioMediaUser.model.User;
import com.SocioMediaUser.Dto.UserRequest;

import java.util.List;

public interface UserService {
    //    Create a new User
    User createUser(UserRequest user);

    //    Update an existing User
    User updateUser(String userName, String password, UserRequest user);


    //    Delete a user By Username and password
    String deleteUser(String userName, String password);

//.

}
