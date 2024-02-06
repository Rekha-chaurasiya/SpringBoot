package com.api.bookspring.bootrestbook.entity;



import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
 public class Book {
  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int bookId;
    private String bookName;
    private String bookTitle;
    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author bookAuthor;
    



    
   
    public Book(int bookId, String bookName, String bookTitle, Author bookAuthor) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
    }

  

    public Book() {
    }



    public int getBookId() {
        return bookId;
    }



    public void setBookId(int bookId) {
        this.bookId = bookId;
    }



    public String getBookName() {
        return bookName;
    }



    public void setBookName(String bookName) {
        this.bookName = bookName;
    }



    public String getBookTitle() {
        return bookTitle;
    }



    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }



    public Author getBookAuthor() {
        return bookAuthor;
    }



    public void setBookAuthor(Author bookAuthor) {
        this.bookAuthor = bookAuthor;
    }



    @Override
    public String toString() {
        return "Book [bookId=" + bookId + ", bookName=" + bookName + ", bookTitle=" + bookTitle + ", bookAuthor="
                + bookAuthor + "]";
    }

    
 }


   
