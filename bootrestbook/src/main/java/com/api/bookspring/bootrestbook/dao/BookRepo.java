package com.api.bookspring.bootrestbook.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.api.bookspring.bootrestbook.entity.Book;


@Component
public interface BookRepo extends CrudRepository<Book ,Integer >{
   public Book findById(int bookId); 
}
