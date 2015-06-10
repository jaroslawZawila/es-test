package com.zawila.com.zawila.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by zawila on 03/06/15.
 */
@Component
public class ClientController {

    @Autowired
    ElasticSearchManager manager;

    public String getClient(final String id) {
        return "String " + id;
    }

    public String saveClientName(final String name) {

        return manager.saveName(name);
    }
}
