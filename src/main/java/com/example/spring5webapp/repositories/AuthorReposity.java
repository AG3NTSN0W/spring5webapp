package com.example.spring5webapp.repositories;

import com.example.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorReposity extends CrudRepository<Author, Long> {
}
