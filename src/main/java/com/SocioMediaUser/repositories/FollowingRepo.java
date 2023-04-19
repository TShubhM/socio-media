package com.SocioMediaUser.repositories;

import com.SocioMediaUser.model.Following;
import com.SocioMediaUser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FollowingRepo extends JpaRepository<Following,Long> {
    List<Following> findByFollowingUser(User followingUser);
    List<Following> findByFollowedUser(User followedUser);
    Optional<Following> findByFollowingUserAndFollowedUser(User followingUser, User followedUser);
    void deleteByFollowedUser(String userName);
}
