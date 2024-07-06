package com.trj3.book_review.exception;

import java.util.List;

public class UnauthorizedException extends  BookReviewAppException {

    public UnauthorizedException() {
        super();
    }

    public UnauthorizedException(List<ErrorModel> theErrors) {
        this();
        this.setErrors(theErrors);
    }
}
