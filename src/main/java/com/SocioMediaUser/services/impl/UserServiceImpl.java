package com.SocioMediaUser.services.impl;

import com.SocioMediaUser.exceptions.UserNameModificationException;
import com.SocioMediaUser.exceptions.UserNameNotPresentException;
import com.SocioMediaUser.model.User;
import com.SocioMediaUser.repositories.UserRepository;
import com.SocioMediaUser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public User createUser(User user) {
        List<User> users = repository.findAll();
        if (users.stream().anyMatch(user1 -> user1.getUserName().equals(user.getUserName()))) {
            throw new UserNameNotPresentException("Username " + user.getUserName() + " is already taken.");
        } else {
            return repository.save(user);
        }
    }

    @Override
    public User updateUser(String userName, String password, User user) {
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

    @Override
    public User findUser(String userName, String password) {
        return repository.findByUserNameAndPassword(userName, password);
    }

    @Override
    public String deleteUser(String userName, String password) {
        repository.delete(repository.findByUserNameAndPassword(userName, password));
        return "User with Username " + userName + " has been Deleted Successfully.";
    }

    @Override
    public List<User> allUsersByFirstNameAndLastName(String firstName, String lastName) {
        return repository.findByFirstNameAndLastName(firstName, lastName);
    }


}
