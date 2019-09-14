package com.hd.mylibrary.controller;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hd.mylibrary.model.converter.CreateAuthorRequestConverter;
import com.hd.mylibrary.model.converter.CreateBookRequestConverter;
import com.hd.mylibrary.model.entity.Author;
import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.request.CreateAuthorRequest;
import com.hd.mylibrary.model.request.CreateBookRequest;
import com.hd.mylibrary.model.response.CreateAuthorResponse;
import com.hd.mylibrary.model.response.CreateBookResponse;
import com.hd.mylibrary.service.AuthorService;
import com.hd.mylibrary.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MyLibraryController {

    private CreateAuthorRequestConverter createAuthorRequestConverter;
    private CreateBookRequestConverter createBookRequestConverter;
    private AuthorService authorService;
    private BookService bookService;

    @Autowired
    public MyLibraryController( CreateAuthorRequestConverter createAuthorRequestConverter,
                                 CreateBookRequestConverter createBookRequestConverter,
                               AuthorService authorService,
                                BookService bookService) {
        this.createAuthorRequestConverter = createAuthorRequestConverter;
        this.authorService = authorService;
        this.createBookRequestConverter = createBookRequestConverter;
        this.bookService = bookService;
    }

    @PostMapping(path = "/myLibrary/author")
    public String saveAuthor(@RequestBody @Valid CreateAuthorRequest createAuthorRequest){

        CreateAuthorResponse createAuthorResponse = authorService.saveAuthor(createAuthorRequestConverter.convert(createAuthorRequest));
        return createAuthorResponse.toString();
    }

    @GetMapping("/myLibrary/authors")
    public List<Author> getAuthors() {
       return authorService.retrieveAuthors();

    }

    @PostMapping(path = "/myLibrary/book")
    public String saveBook(@RequestBody @Valid CreateBookRequest createBookRequest){

        CreateBookResponse createBookResponse = bookService.saveBook(createBookRequestConverter.convert(createBookRequest));
        return createBookResponse.toString();
    }

    @GetMapping("/myLibrary/books")
    public List<Book> getBooks() {
        return bookService.retrieveBooks();
    }


}
