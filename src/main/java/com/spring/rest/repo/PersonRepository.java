package com.spring.rest.repo;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.rest.datamodel.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	
	Optional<Person> findByIdAndIsDeleteFalse(Long id);
	
	List<Person> findAllByIsDeleteFalse();
	
	@Query("SELECT p FROM Person p WHERE " +
	           "(:name IS NULL OR p.name LIKE %:name%) AND " +
	           "(:age = 0 OR p.age = :age)")
	List<Person> findByNameContainingAndAge(String name, int age);
}
