package com.learnings.portfolio.repository;

import com.learnings.portfolio.entity.AcademicExperience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AcademicExperienceRepository extends CrudRepository<AcademicExperience, Integer> {

}
