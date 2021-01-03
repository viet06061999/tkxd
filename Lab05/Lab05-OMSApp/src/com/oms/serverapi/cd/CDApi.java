package com.oms.serverapi.cd;

import com.oms.bean.Book;
import com.oms.bean.CompactDisc;
import com.oms.serverapi.cd.ICDApi;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Map;

public class CDApi implements ICDApi {
    public static final String PATH = "http://localhost:8080/";
    WebTarget webTarget;

    public CDApi() {
        webTarget = ClientBuilder.newClient().target(PATH).path("cds");
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
