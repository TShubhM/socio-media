package com.SocioMediaUser.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.sql.Blob;


@Entity
@Table(name = "profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue
    private Long id;

    private String bio;
    private String profilepic;
    private String coverPhoto;

    private String userName;
    private int followingcount;
    private int followersCount;

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", profilepic=" + profilepic +
                ", coverPhoto=" + coverPhoto +
                ", userName=" + userName +
                ", followingcount=" + followingcount +
                ", followersCount=" + followersCount +
                '}';
    }
}

