package com.hd.mylibrary.model.request;

import com.hd.mylibrary.model.enumerated.BookLanguage;
import com.hd.mylibrary.model.enumerated.BookType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Objects;

public class CreateBookRequest implements Serializable {

    private static final long serialVersionUID = 3373506455900076809L;

    @Valid
    @NotNull(message = "Name can not be null")
    private String name;

    @Valid
    @NotNull(message = "Book Type can not be null")
    private BookType bookType;

    @Valid
    @NotNull(message = "Book Language can not be null")
    private BookLanguage bookLanguage;

    @Valid
    @NotNull(message = "Page can not be null")
    private int page;

    @Valid
    @NotNull(message = "Year can not be null")
    private String year;

    @Valid
    @NotNull(message = "Author can not be null")
    private Long authorId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public BookLanguage getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(BookLanguage bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Long getAuthor() {
        return authorId;
    }

    public void setAuthor(Long authorId) {
        this.authorId = authorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateBookRequest that = (CreateBookRequest) o;
        return page == that.page &&
                name.equals(that.name) &&
                bookType == that.bookType &&
                bookLanguage == that.bookLanguage &&
                year.equals(that.year) &&
                authorId.equals(that.authorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, bookType, bookLanguage, page, year, authorId);
    }

    @Override
    public String toString() {
        return "CreateBookRequest{" +
                "name='" + name + '\'' +
                ", bookType=" + bookType +
                ", bookLanguage=" + bookLanguage +
                ", page=" + page +
                ", year='" + year + '\'' +
                ", author=" + authorId +
                '}';
    }
}
