package com.SocioMediaUser.services;

import com.SocioMediaUser.model.User;
import com.SocioMediaUser.repositories.UserRepository;

import java.util.List;

public interface UserService {
    //    Create a new User
    User createUser(User user);

    //    Update an existing User
    User updateUser(String userName, String password, User user);

    //    Find user By UserName and Password
    User findUser(String userName, String password);

    //    Delete a user By Username and password
    String deleteUser(String userName, String password);

    //    List all Users
    List<User> allUsersByFirstNameAndLastName(String firstName, String lastName);


}
