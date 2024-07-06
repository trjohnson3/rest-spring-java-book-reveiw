package com.trj3.book_review.exception;

import java.util.List;

public class InvalidInputException extends BookReviewAppException{

    public InvalidInputException() {
        super();
    }

    public InvalidInputException(List<ErrorModel> theErrors) {
        this();
        this.setErrors(theErrors);
    }
}
