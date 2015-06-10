package com.zawila.controller;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import com.zawila.App;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = App.class)
@WebAppConfiguration()
@IntegrationTest("server.port:0")
@ActiveProfiles(profiles = "es-integation")
public class TestExample {

    TestRestTemplate testRestTemplate = new TestRestTemplate();

    @Value("${local.server.port}")
    int port;

    @Test
    public void testOne(){

        ResponseEntity<String> response = testRestTemplate.postForEntity("http://localhost:" + port + "/client/myname/", null,  String.class);

        assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));
    }

}
