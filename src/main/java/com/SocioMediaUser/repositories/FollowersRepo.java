package com.SocioMediaUser.repositories;

import com.SocioMediaUser.model.Followers;
import com.SocioMediaUser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowersRepo extends JpaRepository<Followers,Long>{
    List<Followers> findByFollowingUser(User followingUser);

    Followers findByFollowedUser(User followedUser);

    Optional<Followers> findByFollowingUserAndFollowedUser(User followingUser, User followedUser);

    void deleteByFollowingUser(String userName);
}
