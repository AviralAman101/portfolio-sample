package com.learnings.portfolio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import java.sql.Date;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class WorkExperience {

    @Id
    private Integer id;

    @Column
    private String companyName;

    @Column
    private String designation;

    @Column
    private String primarySkill;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    @Column
    private String tags;

    @Column
    private Integer pId;

}
