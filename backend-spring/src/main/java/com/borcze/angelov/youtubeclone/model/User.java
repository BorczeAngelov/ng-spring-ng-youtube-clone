package com.borcze.angelov.youtubeclone.model;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "Users")
public class User {
    private String id;
    private String firstName;
    private String lastName;
    private String fullName;
    private String picture;
    private String emailAddress;
    private String sub;
    private Set<String> subscribedToUsers = new HashSet<>();
    private Set<String> subscribers = new HashSet<>();
    private Set<String> videoHistory = new LinkedHashSet<>();
    private Set<String> likedVideos = new HashSet<>();
    private Set<String> disLikedVideos = new HashSet<>();
}
