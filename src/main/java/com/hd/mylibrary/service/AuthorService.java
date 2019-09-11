package com.hd.mylibrary.service;

import com.hd.mylibrary.model.entity.Author;
import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.response.CreateAuthorResponse;

import java.util.List;

public interface AuthorService {

    public List<Author> retrieveAuthors();

    public Author getAuthor(Long authorId);

    public CreateAuthorResponse saveAuthor(Author author);

    public void deleteAuthor(Long authorId);

    public void updateAuthor(Author author);

    public List<Book> getBooks(Long authorId);
}
