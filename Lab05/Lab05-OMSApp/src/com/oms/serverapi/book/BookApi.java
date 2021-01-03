package com.oms.serverapi.book;

import com.oms.bean.Book;

import javax.ws.rs.client.*;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Map;

public class BookApi implements IBookAPI {
    public static final String PATH = "http://localhost:8080/";
    WebTarget webTarget;

    public BookApi() {
        webTarget = ClientBuilder.newClient().target(PATH).path("books");
    }

    @Override
    public ArrayList<Book> getBooks(Map<String, String> queryParams) {
        if (queryParams != null) {
            for (String key : queryParams.keySet()) {
                String value = queryParams.get(key);
                webTarget = webTarget.queryParam(key, value);
            }
        }
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        ArrayList<Book> res = response.readEntity(new GenericType<ArrayList<Book>>() {
        });
        System.out.println(res);
        return res;
    }

    @Override
    public Book updateBook(Book book) {
        webTarget = webTarget.path(book.getId());
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(book, MediaType.APPLICATION_JSON));
        Book res = response.readEntity(Book.class);
        return res;
    }
}
