package com.trj3.book_review.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;

@ControllerAdvice
public class BookReviewAppExceptionHandler {

    @ExceptionHandler(GeneralBookReviewAppException.class)
    public ResponseEntity<List<ErrorModel>> handleGeneralBookReviewAppException(GeneralBookReviewAppException e) {
        System.out.println("Exception thrown");
        return new ResponseEntity<List<ErrorModel>>(e.getErrors(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(InvalidInputException.class)
    public ResponseEntity<List<ErrorModel>> handleInvalidInputException(InvalidInputException e) {
        System.out.println("Exception thrown");
        return new ResponseEntity<List<ErrorModel>>(e.getErrors(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<List<ErrorModel>> handleNotFoundException(NotFoundException e) {
        System.out.println("Exception thrown");
        return new ResponseEntity<List<ErrorModel>>(e.getErrors(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<List<ErrorModel>> handleUnauthorizedException(UnauthorizedException e) {
        System.out.println("Exception thrown");
        return new ResponseEntity<List<ErrorModel>>(e.getErrors(), HttpStatus.UNAUTHORIZED);
    }
}
