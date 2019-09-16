package com.hd.mylibrary.common;

import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.enumerated.BookLanguage;
import com.hd.mylibrary.model.enumerated.BookType;

import java.util.HashSet;
import java.util.Set;

public class BooksBuilderForTest {

    public Set<Book> buildBooks(int count) {

        Set<Book> books = new HashSet<>();
        AuthorBuilderForTest authorBuilderForTest = new AuthorBuilderForTest();
        if (count > 0) {
            for (int i = 1; i <= count; i++) {
                Book book = new Book();
                book.setAuthor(authorBuilderForTest.buildAuthor());
                book.setYear("2000");
                book.setTotalPage(200);
                book.setName("TEST" + i);
                book.setBookType(BookType.Action);
                book.setBookLanguage(BookLanguage.English);
                books.add(book);
            }
        }

        return books;
    }


}
