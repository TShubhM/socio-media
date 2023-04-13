package com.SocioMediaUser.repositories;

import com.SocioMediaUser.model.Followers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FollowersRepo extends JpaRepository<Followers,Long>{
}
