package com.oms.serverapi.dvd;

import com.oms.bean.DigitalVideoDisc;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Map;

public class DVDApi implements IDVDApi {
    public static final String PATH = "http://localhost:8080/";
    WebTarget webTarget;

    public DVDApi() {
        webTarget = ClientBuilder.newClient().target(PATH).path("dvds");
    }

    @Override
    public ArrayList<DigitalVideoDisc> getDvds(Map<String, String> queryParams) {
        if (queryParams != null) {
            for (String key : queryParams.keySet()) {
                String value = queryParams.get(key);
                webTarget = webTarget.queryParam(key, value);
            }
        }
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();
        ArrayList<DigitalVideoDisc> res = response.readEntity(new GenericType<ArrayList<DigitalVideoDisc>>() {
        });
        System.out.println(res);
        return res;
    }
}
