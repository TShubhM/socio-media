package com.SocioMediaUser.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="followers")
public class Followers {
//    Followers and following creating column with same name and they also have relationship
//    between them so we can user 'CascadeType.ALL' to add it into one table.
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

}
