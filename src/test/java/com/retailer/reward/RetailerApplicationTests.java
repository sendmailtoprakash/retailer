package com.retailer.reward;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RetailerApplicationTests {

    @Test
    void contextLoads() {
    }

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getMonthlyRewardPointsTest() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/retailer/customer/getMonthlyRewardPoints?customerId=10&year=2023&month=6").toString(), String.class);
        assertTrue(response.getBody()!=null);
    }

    @Test
    public void getYearlyRewardPointsTest() throws Exception {

        ResponseEntity<String> response = restTemplate.getForEntity(
                new URL("http://localhost:" + port + "/retailer/customer/getYearlyRewardPoints?customerId=10&year=2023").toString(), String.class);
        assertTrue(response.getBody()!=null);
    }
}
