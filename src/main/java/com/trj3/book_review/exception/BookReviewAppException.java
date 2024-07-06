package com.trj3.book_review.exception;

import java.util.List;

public class BookReviewAppException extends RuntimeException{
    private List<ErrorModel> errors;

    public BookReviewAppException() {
        super();
    }

    public BookReviewAppException(List<ErrorModel> theErrors) {
        this();
        this.errors = theErrors;
    }

    public List<ErrorModel> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorModel> errors) {
        this.errors = errors;
    }
}
