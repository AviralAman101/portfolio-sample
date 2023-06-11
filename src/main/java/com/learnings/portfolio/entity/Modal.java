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
public class Modal {

    @Id
    private Integer id;

    @Column
    private String description;

    @Column
    private String extraDetails;

    @Column
    private String tags;

    @Column
    private String imageName;

    @Column
    private String contentId;

    @Column
    private String link;

    @Column
    private Integer pId;

    @Column
    private Integer contentType;

}
