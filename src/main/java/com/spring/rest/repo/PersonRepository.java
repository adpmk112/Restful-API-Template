package com.spring.rest.repo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.rest.datamodel.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	Optional<Person> findByIdAndIsDeleteFalse(Long id);
	
	List<Person> findAllByIsDeleteFalse();
}
