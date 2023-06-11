package com.learnings.portfolio.repository;

import com.learnings.portfolio.entity.WorkExperience;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkExperienceRepository extends CrudRepository<WorkExperience, Integer> {

}
