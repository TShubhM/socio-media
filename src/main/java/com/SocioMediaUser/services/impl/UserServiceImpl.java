package com.SocioMediaUser.services.impl;

import com.SocioMediaUser.Dto.UserRequest;
import com.SocioMediaUser.exceptions.UserNameModificationException;
import com.SocioMediaUser.exceptions.UserNameNotPresentException;
import com.SocioMediaUser.model.Profile;
import com.SocioMediaUser.model.User;
import com.SocioMediaUser.repositories.FollowersRepo;
import com.SocioMediaUser.repositories.FollowingRepo;
import com.SocioMediaUser.repositories.ProfileRepo;
import com.SocioMediaUser.repositories.UserRepository;
import com.SocioMediaUser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ProfileRepo profileRepo;
    @Autowired
    private FollowingRepo followingRepo;
    @Autowired
    private FollowersRepo followersRepo;

    @Override
    public User createUser(UserRequest user) {
        User new_user = userRequestMapTouser(user);
        List<User> users = repository.findAll();
        if (users.stream().anyMatch(user1 -> user1.getUserName().equals(user.getUserName()))) {
            throw new UserNameNotPresentException("Username " + user.getUserName() + " is already taken.");
        } else {
            Profile profile = new Profile();
            profile.setUserName(new_user.getUserName());
            profileRepo.save(profile);
            return repository.save(new_user);
        }
    }

    @Override
    public User updateUser(String userName, String password, UserRequest user) {
        User foundUser = repository.findByUserNameAndPassword(userName, password);
        if (!foundUser.getUserName().equals(user.getUserName())) {
            throw new UserNameModificationException("UserName cannot be modified once created");
        } else {
            foundUser.setDob(user.getDob());
            foundUser.setEmail(user.getEmail());
            foundUser.setFirstName(user.getFirstName());
            foundUser.setLastName(user.getLastName());
            repository.save(foundUser);
        }
        return foundUser;
    }

    public User userRequestMapTouser(UserRequest userR) {
        User user = new User();
        user.setUserName(userR.getUserName());
        user.setFirstName(userR.getFirstName());

        user.setLocation(userR.getLocation());
        user.setPassword(userR.getPassword());

        user.setDob(userR.getDob());
        user.setEmail(userR.getEmail());
        user.setLastName(userR.getLastName());

        System.out.println(user);
        return user;
    }


    @Override
    public String deleteUser(String userName, String password) {
        followingRepo.deleteByFollowedUser(userName);
        followersRepo.deleteByFollowingUser(userName);
        profileRepo.delete(profileRepo.findByUserName(userName));
        repository.delete(repository.findByUserNameAndPassword(userName, password));
        return "User with Username " + userName + " has been Deleted Successfully.";
    }

    @Override
    public boolean userValidityChecking(String userName) {
        return repository.existsById(userName);
    }


}
