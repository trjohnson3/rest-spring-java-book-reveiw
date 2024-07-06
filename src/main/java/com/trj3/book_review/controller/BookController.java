package com.trj3.book_review.controller;

import com.trj3.book_review.dto.BookDTO;
import com.trj3.book_review.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BookController {

    @Autowired
    public BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<BookDTO>> getAllBooks() {
        List<BookDTO> bookDTOList = bookService.getAllBooks();
        return new ResponseEntity<List<BookDTO>>(bookDTOList, HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<BookDTO> getAllBooks(@PathVariable("id") Long theId) {
        BookDTO bookDTO = bookService.getBookById(theId);
        return new ResponseEntity<BookDTO>(bookDTO, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<BookDTO> createBook(@RequestBody BookDTO theBookDTO) {
        BookDTO bookDTO = bookService.createBook(theBookDTO);
        return new ResponseEntity<BookDTO>(bookDTO, HttpStatus.CREATED);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity<BookDTO> updateBookById(
            @RequestBody BookDTO theBookDTO, @PathVariable("id") Long theId) {
        BookDTO bookDTO = bookService.updateBook(theBookDTO, theId);
        return new ResponseEntity<BookDTO>(bookDTO, HttpStatus.OK);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> updateBookById(@PathVariable("id") Long theId) {
        bookService.deleteBook(theId);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
