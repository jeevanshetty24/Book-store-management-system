package com.bookstore.BookstoreProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstore.BookstoreProject.entity.Book;
@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{

}
