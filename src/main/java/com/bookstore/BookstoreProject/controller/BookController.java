package com.bookstore.BookstoreProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bookstore.BookstoreProject.entity.Book;
import com.bookstore.BookstoreProject.entity.MyBookList;
import com.bookstore.BookstoreProject.service.BookService;
import com.bookstore.BookstoreProject.service.MyBookListService;



@Controller
public class BookController 
{
	@Autowired
	private MyBookListService myBookService;
	
	@Autowired
	private BookService bService;
	
	@GetMapping("/")
	public String home()
	{
		return "home";
	}
	@GetMapping("/book_register")
	public String bookRegister()
	{
		return "bookRegister";
	}
	@GetMapping("/available_books")
	public ModelAndView getAllBook()
	{
		List<Book>list=bService.getAllBook();
//		ModelAndView m=new ModelAndView();
//		m.setViewName("booklist");
//		m.addObject("book",list);
		return new ModelAndView("bookList", "book",list);
	}

	
	@PostMapping("/save")
	public String addBook(@ModelAttribute Book b) {
	    bService.save(b);
	    return "redirect:/available_books";
	}
	@GetMapping("/my_books")
	public String getMyBooks(Model model)
	{
		List<MyBookList>list=myBookService.getAllMyBooks();
		model.addAttribute("book", list);
		return "myBooks";	
	}
	
	@RequestMapping("/mylist/{id}")
	public String getMylist(@PathVariable("id")int id)
	{
		Book b=bService.getBookById(id);
		MyBookList mb=new MyBookList(b.getId(), b.getName(),b.getAuthor(), b.getPrice());
		myBookService.saveMyBooks(mb);
		return "redirect:/my_books";
	}
	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id")int id,Model model)
	{
	  Book b=bService.getBookById(id);
	  model.addAttribute("book",b);
	  return "bookEdit";
	}
	@RequestMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable("id")int id)
	{
		bService.deleteById(id);
		return "redirect:/available_books";
	}


}
