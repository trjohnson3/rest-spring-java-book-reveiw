package com.trj3.book_review.service;

import com.trj3.book_review.converter.BookConverter;
import com.trj3.book_review.dto.BookDTO;
import com.trj3.book_review.entity.BookEntity;
import com.trj3.book_review.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private BookConverter bookConverter;

    @Override
    public List<BookDTO> getAllBooks() {
        Iterable<BookEntity> bookEntityIterable = bookRepository.findAll();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for(BookEntity entity : bookEntityIterable) {
            bookDTOList.add(bookConverter.convertToDTO(entity));
        }
        return bookDTOList;
    }

    @Override
    public BookDTO getBookById(Long theId) {
        Optional<BookEntity> optionalBookEntity = bookRepository.findById(theId);
        BookDTO bookDTO = null;
        if(optionalBookEntity.isPresent()) {
            bookDTO = bookConverter.convertToDTO(optionalBookEntity.get());
        }

        return bookDTO;
    }

    @Override
    public BookDTO createBook(BookDTO theBookDTO) {
        BookEntity bookEntity = bookConverter.convertToEntity(theBookDTO);
        bookEntity = bookRepository.save(bookEntity);
        theBookDTO = bookConverter.convertToDTO(bookEntity);

        return theBookDTO;
    }

    @Override
    public void deleteBook(Long theId) {
        bookRepository.deleteById(theId);
    }

    @Override
    public BookDTO updateBook(BookDTO theBookDTO, Long theId) {
        BookEntity bookEntity = bookConverter.convertToEntity(theBookDTO);
        bookEntity.setId(theId);
        bookEntity = bookRepository.save(bookEntity);
        theBookDTO = bookConverter.convertToDTO(bookEntity);

        return theBookDTO;
    }


}
