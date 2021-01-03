package com.oms.serverapi;

import com.oms.bean.Book;
import com.oms.bean.CompactDisc;

import java.util.ArrayList;
import java.util.Map;

public interface IMediaApi {
     ArrayList<Book> getBooks(Map<String, String> queryParams);
     Book updateBook(Book book);
     ArrayList<CompactDisc> getCds(Map<String, String> queryParams);
     CompactDisc updateCD(CompactDisc cd);
}
