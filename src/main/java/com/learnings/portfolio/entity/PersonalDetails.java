package com.learnings.portfolio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class PersonalDetails {

    @Id
    private Integer id;
    @Column
    private String name;

    @Column
    private String emailId;
    @Column
    private String designation;

    @Column
    private String role;

    @Column
    private String phoneNumber;

    @Column
    private String xFactor;
    @Column
    private String resumeName;

    @Column
    private String profilePictureName;

    @Column
    private String facebookLink;

    @Column
    private String twitterLink;

    @Column
    private String linkedInLink;

    @Column
    private String githubLink;

}
