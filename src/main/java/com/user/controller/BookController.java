package com.user.controller;

import com.user.entity.Book;
import com.user.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable Integer bookId) {
        return bookService.getBookById(bookId);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @PutMapping("/{bookId}")
    public Book updateBook(@PathVariable Integer bookId, @RequestBody Book updatedBook) {
        Book book = bookService.getBookById(bookId);
        if (book != null) {
            book.setTitle(updatedBook.getTitle());
            // Update other fields as needed
            return bookService.saveBook(book);
        }
        return null;
    }

    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Integer bookId) {
        bookService.deleteBook(bookId);
    }
}
