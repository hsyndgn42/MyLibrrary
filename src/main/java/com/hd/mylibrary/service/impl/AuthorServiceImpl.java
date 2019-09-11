package com.hd.mylibrary.service.impl;

import com.hd.mylibrary.model.dao.AuthorDAO;
import com.hd.mylibrary.model.entity.Author;
import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.response.CreateAuthorResponse;
import com.hd.mylibrary.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDAO authorDAO;
    @Autowired
    private BookServiceImpl bookService;

    @Override
    public List<Author> retrieveAuthors() {

        return authorDAO.findAll();
    }

    @Override
    public Author getAuthor(Long authorId) {
        Optional<Author> author = authorDAO.findById(authorId);
        return author.get();
    }

    @Override
    public CreateAuthorResponse saveAuthor(Author author) {
        try{
            authorDAO.save(author);
        }catch (Exception e){
            return new CreateAuthorResponse ("Fail" ,"Error : "+e.toString());
        }
        return new CreateAuthorResponse ("Success" ,"Author created successfully.");
    }

    @Override
    public void deleteAuthor(Long authorId) {
        authorDAO.deleteById(authorId);
    }

    @Override
    public void updateAuthor(Author author) {
        authorDAO.save(author);
    }

    @Override
    public List<Book> getBooks(Long authorId) {

        return bookService.retrieveBooksByAuthorId(authorId);
    }
}
