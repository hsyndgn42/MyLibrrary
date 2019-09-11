package com.hd.mylibrary.model.converter;

import com.hd.mylibrary.model.entity.Author;
import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.request.CreateBookRequest;
import com.hd.mylibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class CreateBookRequestConverter {

    @Autowired
    AuthorService authorService;

    public Book convert(CreateBookRequest createBookRequest) {
        Set<Author> authors = new HashSet<>();
        authors.add(authorService.getAuthor(createBookRequest.getAuthor()));
        Book book = new Book();

        book.setBookLanguage(createBookRequest.getBookLanguage());
        book.setBookType(createBookRequest.getBookType());
        book.setName(createBookRequest.getName());
        book.setTotalPage(createBookRequest.getPage());
        book.setYear(createBookRequest.getYear());

        return book;

    }
}

