package cloud.simple.eureka;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by zxb on 7/5/16.
 * @url https://github.com/Netflix/eureka/wiki/Eureka-REST-operations
 */
@WebAppConfiguration
public class EurekaApplicationTest {

    private int port = 8889;

    @Test
    public void catalogLoads() {
        ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://localhost:" + port + "/eureka/apps", Map.class);
        assertEquals(HttpStatus.OK, entity.getStatusCode());
    }

}