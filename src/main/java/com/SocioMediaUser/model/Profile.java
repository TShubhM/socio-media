package com.SocioMediaUser.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.sql.Blob;


@Entity
@Table(name = "T_profile")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Profile {
    @Id
    @GeneratedValue
    private Long id;

    private String bio;
    private Blob profilepic;
    private Blob coverPhoto;
    @OneToOne(fetch = FetchType.LAZY)
     @JoinColumn(name="user_name",referencedColumnName = "user_name",foreignKey = @ForeignKey(name = "none", value = ConstraintMode.NO_CONSTRAINT))

    private User user;

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", bio='" + bio + '\'' +
                ", profilepic=" + profilepic +
                ", coverPhoto=" + coverPhoto +

                '}';
    }
}

