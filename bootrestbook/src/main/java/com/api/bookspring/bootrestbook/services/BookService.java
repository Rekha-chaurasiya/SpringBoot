package com.api.bookspring.bootrestbook.services;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.bookspring.bootrestbook.dao.BookRepo;
import com.api.bookspring.bootrestbook.entity.Book;


@Service
public class BookService {

    // private static List<Book>list=new ArrayList<>();

    // static{
    //    list.add(new Book(23,"java","learing new concept","marchaven"));
    //    list.add(new Book(24,"java","learing new concept","etlejin"));
    //    list.add(new Book(25,"java","learing new concept","cracraters"));
    //  }
    @Autowired
    private BookRepo bookrepo;
    public  List<Book> getAllBook()
    {
        List<Book> book=(List<Book>)bookrepo.findAll();
        return book ;
        
    }
    public  Book getId(int bookId)
    {
        Book book=null;
        try{
        //book=list.stream().filter(e->e.getBookId()==id).findFirst().get();
         book=bookrepo.findById(bookId);
        }catch(Exception e)
        {
          e.printStackTrace();
        }
        return book;
    }
    public Book add(Book b)
{
     Book book=bookrepo.save(b);
    return book;
} 
    
public void delete(int id)
{
   // list=list.stream().filter(book->book.getBookId()!=id).collect(Collectors.toList());
   bookrepo.deleteById(id);

}
public void update(int id,Book b)
{
//    list= list.stream().map(book->{

//     if(book.getBookId()==b.getBookId())
//     {
//     book.setBookName(b.getBookName());
//     book.setBookAuthor(b.getBookAuthor());
//     }
//     return book;
//}).collect(Collectors.toList());
   b.setBookId(id);
   bookrepo.save(b);
   
}
      
}

