package com.hd.mylibrary.common;

import com.hd.mylibrary.model.entity.Book;
import com.hd.mylibrary.model.enumerated.BookLanguage;
import com.hd.mylibrary.model.enumerated.BookType;

public class BooksBuilderForTest {

    public Book buildBooks() {

        Book book = new Book();
        book.setYear("2000");
        book.setTotalPage(200);
        book.setName("TEST");
        book.setBookType(BookType.Action);
        book.setBookLanguage(BookLanguage.English);

        return book;
    }


}
