package com.learnings.portfolio.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModalDTO {
    private String name;
    private String description;
    private String extraDetails;
    private String tags;
    private String imageName;
    private String link;
    private String startDate;
    private String endDate;


}
