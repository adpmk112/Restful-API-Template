package com.spring.rest.service;

import org.springframework.http.ResponseEntity;

public interface CommonCRUDConfigurable<E,T> {
	
	ResponseEntity<Object> save(T dto);
	ResponseEntity<Object> findById (long id);
	E getById(long id);
	ResponseEntity<Object> findAll();
	ResponseEntity<Object> update(T dto);
	ResponseEntity<Object> delete(long id);
}
