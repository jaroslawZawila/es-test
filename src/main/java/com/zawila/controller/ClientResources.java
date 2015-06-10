package com.zawila.controller;

import com.zawila.com.zawila.client.ClientController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.websocket.server.PathParam;

/**
 * Created by zawila on 03/06/15.
 */
@Controller
public class ClientResources {

    @Autowired
    private ClientController clientController;

    @RequestMapping("/client/{id}")
    @ResponseBody
    public String getClient(@PathVariable final String id ) {
        return clientController.getClient(id);
    }

    @RequestMapping(value = "/client/{name}", method = RequestMethod.POST)
    @ResponseBody
    public String saveName(@PathVariable final String name) {
        return clientController.saveClientName(name);
    }
}
