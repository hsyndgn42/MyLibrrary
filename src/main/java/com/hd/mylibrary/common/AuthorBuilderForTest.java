package com.hd.mylibrary.common;

import com.hd.mylibrary.model.entity.Author;

public class AuthorBuilderForTest {

    public Author buildAuthor() {

        Author author = new Author();
        author = new Author();
        author.setAge(30);
        author.setEmail("test@test.com");
        author.setFirstName("TEST");
        author.setSurname("TEST");
        return author;
    }


}
