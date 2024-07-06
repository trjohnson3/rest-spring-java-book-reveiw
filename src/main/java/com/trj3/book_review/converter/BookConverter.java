package com.trj3.book_review.converter;

import com.trj3.book_review.dto.BookDTO;
import com.trj3.book_review.entity.BookEntity;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    public BookEntity convertToEntity(BookDTO theBookDTO) {
        BookEntity myBookEntity = new BookEntity();
        myBookEntity.setTitle(theBookDTO.getTitle());
        myBookEntity.setAuthor(theBookDTO.getAuthor());

        return myBookEntity;
    }

    public BookDTO convertToDTO(BookEntity theBookEntity) {
        BookDTO myBookDTO = new BookDTO();
        myBookDTO.setId(theBookEntity.getId());
        myBookDTO.setTitle(theBookEntity.getTitle());
        myBookDTO.setAuthor(theBookEntity.getAuthor());

        return myBookDTO;
    }
}
