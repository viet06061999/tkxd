package com.oms.serverapi;

import java.util.ArrayList;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.oms.bean.Book;
import com.oms.bean.CompactDisc;
import com.oms.bean.DigitalVideoDisc;
import com.oms.bean.Media;

public class MediaApi implements IMediaApi {
    public static final String PATH = "http://localhost:8080/";

    private Client client;

    private volatile static MediaApi instance;
   WebTarget webTarget = ClientBuilder.newClient().target(PATH).path("cds");
    private MediaApi() {
        client = ClientBuilder.newClient();
    }

    public static MediaApi getInstance() {
        if (instance == null)
            synchronized (MediaApi.class) {
                if (instance == null)
                    instance = new MediaApi();
            }
        return instance;
    }

    public ArrayList<Media> getAllMedias() {
        WebTarget webTarget = client.target(PATH).path("medias");

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        ArrayList<Media> res = response.readEntity(new GenericType<ArrayList<Media>>() {
        });
        System.out.println(res);
        return res;
    }

    @Override
    public ArrayList<Book> getBooks(Map<String, String> queryParams) {
        WebTarget webTarget = client.target(PATH).path("books");


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
        WebTarget webTarget = client.target(PATH).path("books").path(book.getId());

        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(book, MediaType.APPLICATION_JSON));

        Book res = response.readEntity(Book.class);
        return res;
    }


    @Override
    public ArrayList<CompactDisc> getCds(Map<String, String> queryParams) {
        if (queryParams != null) {
            for (String key : queryParams.keySet()) {
                String value = queryParams.get(key);
                webTarget = webTarget.queryParam(key, value);
            }
        }
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        ArrayList<CompactDisc> res = response.readEntity(new GenericType<ArrayList<CompactDisc>>() {
        });
        return res;
    }

    @Override
    public CompactDisc updateCD(CompactDisc cd) {
        webTarget = webTarget.path(cd.getId());
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.post(Entity.entity(cd, MediaType.APPLICATION_JSON));
        CompactDisc res = response.readEntity(CompactDisc.class);
        return res;
    }
}
