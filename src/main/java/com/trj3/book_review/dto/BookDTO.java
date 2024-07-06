package com.trj3.book_review.dto;

import jakarta.validation.constraints.NotNull;


public class BookDTO {

    private Long id;
    @NotNull(message="Title cannot be null.")
    private String title;
    @NotNull(message="Author cannot be null.")
    private String author;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
