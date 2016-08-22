package cloud.simple.eureka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by zxb on 7/5/16.
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = EurekaServerApplication.class)
//@WebAppConfiguration
//@IntegrationTest("server.port=0")
public class EurekaServerApplicationTest {

    /*@Value("${local.server.port}")
    private int port = 0;

    @Test
    public void catalogLoads(){
        ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://localhost:"+port+"eureka/apps",Map.class);
        assertEquals(HttpStatus.OK,entity.getStatusCode());
    }

    @Test
    public void adminLoads(){
        ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://localhost:"+port+"/env",Map.class);
        assertEquals(HttpStatus.OK,entity.getStatusCode());
    }*/
}