package com.trj3.book_review.service;

import com.trj3.book_review.dto.BookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getAllBooks();
    BookDTO getBookById(Long theId);
    BookDTO createBook(BookDTO theBookDTO);
    void deleteBook(Long theId);
    BookDTO updateBook(BookDTO theBookDTO, Long theId);
}
