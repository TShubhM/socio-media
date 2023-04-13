package com.SocioMediaUser.repositories;

import com.SocioMediaUser.model.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProfileRepo extends JpaRepository<Profile,Integer> {
//    @Query("SELECT p FROM Profile p JOIN p.user1 u WHERE u.userName = :userId")
//    Profile findByUser1Id(@Param("userId") String userId);;
}
