package com.learnings.portfolio.repository;

import com.learnings.portfolio.entity.PersonalDetails;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PersonalDetailsRepository extends CrudRepository<PersonalDetails, Integer> {

}
