package com.firstcrudspring.firstCrudStoreSpring.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.firstcrudspring.firstCrudStoreSpring.models.Todo;

public interface TodoRepository extends MongoRepository<Todo, String> {
    List<Todo> findByStatus(Boolean status);
}
