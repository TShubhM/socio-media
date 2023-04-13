package com.SocioMediaUser.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Blob;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileRequest {


        private String bio;
        private Blob profilepic;
        private Blob coverPhoto;

        @Override
        public String toString() {
            return "ProfileRequest{" +
                    "bio='" + bio + '\'' +
                    ", profilepic=" + profilepic +
                    ", coverPhoto=" + coverPhoto +
                    '}';
        }
    }

