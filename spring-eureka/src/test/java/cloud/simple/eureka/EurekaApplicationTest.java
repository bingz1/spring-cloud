package cloud.simple.eureka;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by zxb on 7/5/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class EurekaApplicationTest {

    private int port = 8889;

    @Test
    public void catalogLoads(){
        ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://localhost:"+port+"eureka/apps",Map.class);
        assertEquals(HttpStatus.OK,entity.getStatusCode());
    }

    @Test
    public void adminLoads(){
        ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://localhost:"+port+"/env",Map.class);
        assertEquals(HttpStatus.OK,entity.getStatusCode());
    }
}