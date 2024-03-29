package com.hd.mylibrary.model.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.hd.mylibrary.model.enumerated.BookLanguage;
import com.hd.mylibrary.model.enumerated.BookType;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    @ManyToOne
    @JoinColumn(name = "AUTHOR_ID", nullable = false, referencedColumnName = "AUTHOR_ID")
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonBackReference
    private Author author;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @JsonBackReference
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

}
