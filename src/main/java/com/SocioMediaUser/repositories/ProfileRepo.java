package com.SocioMediaUser.repositories;

import com.SocioMediaUser.Dto.ProfileRequest;
import com.SocioMediaUser.model.Profile;
import com.SocioMediaUser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ProfileRepo extends JpaRepository<Profile,Long> {




    Profile findByUserName(String id);
}
