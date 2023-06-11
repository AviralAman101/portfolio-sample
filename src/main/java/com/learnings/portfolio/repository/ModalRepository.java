package com.learnings.portfolio.repository;

import com.learnings.portfolio.entity.Modal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModalRepository extends CrudRepository<Modal, Integer> {

}
