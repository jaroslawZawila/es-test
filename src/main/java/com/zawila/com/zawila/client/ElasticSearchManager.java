package com.zawila.com.zawila.client;

import org.elasticsearch.action.index.IndexResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ElasticSearchManager {


    private final String TYPE = "test_type";
    private final String INDEX = "test_index";

    @Autowired
    StoreManager clientManager;

    public String saveName(final String name) {
        IndexResponse response = clientManager.getClient().prepareIndex(INDEX, TYPE).setSource("Name", name).get();
        return response.getId();
    }

}
