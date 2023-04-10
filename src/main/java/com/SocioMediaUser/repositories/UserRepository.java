package com.SocioMediaUser.repositories;

import com.SocioMediaUser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserNameAndPassword(String username, String password);

    List<User> findByFirstNameAndLastName(String firstName, String lastName);



}
