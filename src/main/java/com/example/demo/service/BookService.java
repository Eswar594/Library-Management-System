package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.model.User;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.UserRepository;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookrepo;

    @Autowired
    private UserRepository userrepo;

    public List<Book> findAll() {
        return bookrepo.findAll();
    }

    public Book findById(Long id) {
        return bookrepo.findById(id).orElse(null);
    }

    public Book save(Book book) {
        return bookrepo.save(book);
    }

    public void deleteById(Long id) {
        bookrepo.deleteById(id);
    }

    public Book borrowBook(Long bookId, Long userId) {
        Book book = findById(bookId);
        User user = userrepo.findById(userId).orElse(null);

        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowedBy(user);
            book.setBorrowed(true);
            return save(book);
        }
        return null;
    }

    public Book returnBook(Long bookId) {
        Book book = findById(bookId);
        if (book != null && book.isBorrowed()) {
            book.setBorrowedBy(null);
            book.setBorrowed(false);
            return save(book);
        }
        return null;
    }
}