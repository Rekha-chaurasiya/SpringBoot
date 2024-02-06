package com.api.bookspring.bootrestbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.api.bookspring.bootrestbook.entity.Book;
import com.api.bookspring.bootrestbook.services.BookService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class BookController {


// public Book geBooks(){
//      Book book =new Book();
//      book.setBookId("1");
//      book.setBookName("java");
//      book.setBookTitle("api java");
//      book.setBookAuthor("ditech");
//     return book;
@Autowired
BookService bookService;

@GetMapping("/books")
public  ResponseEntity <List<Book>> getBook()
{
    List<Book> list=this.bookService.getAllBook();
    if(list.size()<=0)
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.of(Optional.of(list));
}
 

@GetMapping("/books/{bookId}")
public ResponseEntity <Book> getById(@PathVariable("bookId") int bookId)
{
    

        Book book=bookService.getId(bookId);
        if(book==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
         
    return ResponseEntity.of(Optional.of(book));
    
}
 @PostMapping("/books")
  public ResponseEntity< Book> addBook(@RequestBody Book book)
{
    try{
    Book book1=this.bookService.add(book);
    return  ResponseEntity.of(Optional.of(book1));
    }
    catch(Exception e)
    {
     e.printStackTrace();
     return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}



@DeleteMapping("books/{bookid}")
public ResponseEntity<?> deletebook(@PathVariable("bookid") int bookid)
{
    try{
    bookService.delete(bookid);
    return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    catch(Exception e)
    {
     e.printStackTrace();
     return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }
}

@PutMapping("books/{bookid}")
public ResponseEntity<Book> update(@RequestBody Book book, @PathVariable("bookid") int bookid)
{
    try{
     bookService.update(bookid,book);
     return ResponseEntity.ok().body(book);
    }
    catch(Exception e)
    {
        e.printStackTrace();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();   
    }
  
}

    

}
