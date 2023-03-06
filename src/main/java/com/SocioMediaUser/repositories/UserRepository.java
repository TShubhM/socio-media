package com.SocioMediaUser.repositories;

import com.SocioMediaUser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    User findByUserNameAndPassword(String username, String password);

}
