//package com.bookstore.BookstoreProject.service;
//
//import java.util.List;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
//import org.springframework.stereotype.Service;
//
//import com.bookstore.BookstoreProject.entity.Book;
//import com.bookstore.BookstoreProject.repository.BookRepository;
//
//
//
//@Service
//public class BookService 
//{
//	@Autowired
//	private BookRepository bRepo;
//	
//	public void save(Book b)
//	{
//		bRepo.save(b);
//		
//	}
//	public List<Book>getAllBook()
//	{
//		return bRepo.findAll(Sort.by(Sort.Direction.ASC, "id"));		
//	}
//	public Book getBookById(int id)
//	{
//		
//		return bRepo.findById(id).get();
//	}
//	public void deleteById(int id)
//	{
//		bRepo.deleteById(id);
//	}
//
//}

package com.bookstore.BookstoreProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.bookstore.BookstoreProject.entity.Book;
import com.bookstore.BookstoreProject.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository bRepo;

    public void save(Book b) {
        bRepo.save(b);
    }

    public List<Book> getAllBook() {
        return bRepo.findAll();
    }

    public Book getBookById(int id) {
        return bRepo.findById(id).get();
    }

    public void deleteById(int id) {
        bRepo.deleteById(id);
    }
}

