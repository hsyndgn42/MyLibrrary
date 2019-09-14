package com.hd.mylibrary.model.converter;

import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.request.CreateBookRequest;
import com.hd.mylibrary.service.AuthorService;
import com.hd.mylibrary.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateBookRequestConverter {

    @Autowired
    AuthorService authorService;
    @Autowired
    CustomerService customerService;

    public Book convert(CreateBookRequest createBookRequest) {
        Book book = new Book();
        book.setAuthor(authorService.getAuthor(createBookRequest.getAuthor()));
        book.setBookLanguage(createBookRequest.getBookLanguage());
        book.setBookType(createBookRequest.getBookType());
        book.setName(createBookRequest.getName());
        book.setTotalPage(createBookRequest.getPage());
        book.setYear(createBookRequest.getYear());

        return book;

    }
}

