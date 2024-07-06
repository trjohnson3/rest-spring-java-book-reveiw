package com.trj3.book_review.exception;

import java.util.List;

public class GeneralBookReviewAppException extends BookReviewAppException{

    public GeneralBookReviewAppException() {
        super();
    }

    public GeneralBookReviewAppException(List<ErrorModel> theErrors) {
        this();
        this.setErrors(theErrors);
    }
}
