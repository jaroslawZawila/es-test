package com.zawila.test.utils;

import static org.elasticsearch.node.NodeBuilder.*;

import com.zawila.App;
import com.zawila.com.zawila.client.StoreManager;
import org.apache.tools.ant.types.Commandline;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;
import org.omg.CORBA.SystemException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Component
@Profile("es-integation")
public class ElastiSearchNode implements InitializingBean, StoreManager, DisposableBean {

    private final static Logger LOG = LoggerFactory.getLogger(ElastiSearchNode.class);
    private final static  String DEFAULT_NAME = "es-data";
    private final Path path;

    private Client client;
    private Node node;

    public ElastiSearchNode() {
        LOG.debug(String.format("Created class %s.",getClass().getName()));

        try {
           path =  Files.createTempDirectory(DEFAULT_NAME);
           LOG.info(String.format("Path: %s", path.toString()));
        } catch (IOException e) {
            throw new RuntimeException("Cannot create data firectory." , e);
        }

        ImmutableSettings.Builder elasticsearchSettings = ImmutableSettings.settingsBuilder()
                .put("http.enabled", "false")
                .put("path.data", path.toString());

        this.node = nodeBuilder().local(true).settings(elasticsearchSettings).node();
        this.client = node.client();

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        LOG.info("Started Elastic Search node.");
        this.node.start();
    }

    public Client getClient(){
        return this.client;
    }

    @Override
    public void destroy() throws Exception {
        LOG.info("Close ElasticSearch node.");
        this.node.close();

        LOG.info("Close ElasticSearch node.");
        new File(path.toString()).deleteOnExit();
    }
}
