package com.oms.serverapi.book;

import com.oms.bean.Book;

import java.util.ArrayList;
import java.util.Map;

public interface IBookAPI {
    ArrayList<Book> getBooks(Map<String, String> queryParams);
    Book updateBook(Book book);
}
