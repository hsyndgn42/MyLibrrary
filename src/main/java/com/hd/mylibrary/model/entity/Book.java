package com.hd.mylibrary.model.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hd.mylibrary.model.enumerated.BookLanguage;
import com.hd.mylibrary.model.enumerated.BookType;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Entity
@Table(name = "BOOK")
@AttributeOverride(name = "id", column = @Column(name = "BOOK_ID"))
public class Book extends BaseEntity {
    @NotEmpty(message = "Name can not be empty.")
    @Column(name = "NAME", nullable = false)
    private String name;

    @NotNull(message = "Type can not be empty.")
    @Enumerated(EnumType.STRING)
    @Column(name = "TYPE", nullable = false)
    private BookType bookType;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUTHOR_ID", nullable = false)
    @JsonIgnore
    private Author author;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    @JsonIgnore
    private Customer customer;

    @NotEmpty(message = "Year can not be empty.")
    @Column(name = "YEAR", nullable = false)
    private String year;


    @NotNull(message = "Language can not be empty.")
    @Enumerated(EnumType.STRING)
    @Column(name = "LANGUAGE", nullable = false)
    private BookLanguage bookLanguage;

    @NotNull(message = "Page can not be empty.")
    @Column(name = "PAGE", nullable = false)
    private int totalPage;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

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

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public BookLanguage getBookLanguage() {
        return bookLanguage;
    }

    public void setBookLanguage(BookLanguage bookLanguage) {
        this.bookLanguage = bookLanguage;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return totalPage == book.totalPage &&
                name.equals(book.name) &&
                bookType == book.bookType &&
                author.equals(book.author) &&
                customer.equals(book.customer) &&
                year.equals(book.year) &&
                bookLanguage == book.bookLanguage;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), name, bookType, author, customer, year, bookLanguage, totalPage);
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", bookType=" + bookType +
                ", author=" + author +
                ", customer=" + customer +
                ", year='" + year + '\'' +
                ", bookLanguage=" + bookLanguage +
                ", totalPage=" + totalPage +
                '}';
    }
}
