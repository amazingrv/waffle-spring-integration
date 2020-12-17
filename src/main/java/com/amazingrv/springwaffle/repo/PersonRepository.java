package com.amazingrv.springwaffle.repo;

import com.amazingrv.springwaffle.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for CRUD operation on PersonEntity
 *
 * @author rjat3
 */
@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, String> {

}
