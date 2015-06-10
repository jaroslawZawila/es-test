package com.zawila.com.zawila.client;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

/**
 * Created by zawila on 09/06/15.
 */
@Component
@Profile("production")
public class ClientManager implements StoreManager {

    private TransportClient client;

    public ClientManager(){
        System.out.print("\n\n\n\n HERE BAD\n\n\n\n");

        Settings settings = ImmutableSettings.settingsBuilder()
                .put("client.transport.ignore_cluster_name", true).build();

        client = new TransportClient(settings).addTransportAddress(
                new InetSocketTransportAddress("127.0.0.1", 9300)
        );
    }

    public TransportClient getClient(){
        return client;
    }
}
