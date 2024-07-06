package com.trj3.book_review.exception;

import java.util.List;

public class NotFoundException extends BookReviewAppException {

    public NotFoundException() {
        super();
    }

    public NotFoundException(List<ErrorModel> theErrors) {
        this();
        this.setErrors(theErrors);
    }
}
