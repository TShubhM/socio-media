package com.SocioMediaUser.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name="following")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Following {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "following_user")
    @JsonManagedReference
    private User followingUser;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "followed_user")
    @JsonManagedReference
    private User followedUser;

    @Override
    public String toString() {
        return "Following{" +
                "id=" + id +
                ", followingUsername=" + followingUser.getUserName() +
                ", followedUsername=" + followedUser.getUserName() +
                '}';
    }
}
