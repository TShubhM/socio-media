package com.SocioMediaUser.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.format.annotation.DateTimeFormat;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users_tbl")
@DynamicUpdate

public class User {

    @Id
    @Column(name = "user_name")
    private String userName;
    private String firstName;

    private String lastName;
    private String email;
    private String location;
    private String password;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    @CreationTimestamp
    private Timestamp createdOn;
    @UpdateTimestamp
    private Timestamp lastUpdatedOn;
    @OneToMany(mappedBy = "followingUser", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonBackReference
    private List<Following> following;

    @OneToMany(mappedBy = "followedUser", cascade = CascadeType.ALL,orphanRemoval = true)
    @JsonBackReference
    private List<Followers> followers;
//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private Profile profile;
    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", dob=" + dob +
                '}';
    }
}
