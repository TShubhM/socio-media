package com.SocioMediaUser.repositories;

import com.SocioMediaUser.model.Following;
import com.SocioMediaUser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FollowingRepo extends JpaRepository<Following,Long> {
    List<Following> findAllByFollowingUser(User followingUser);
    List<Following> findAllByFollowedUser(User followedUser);


}
