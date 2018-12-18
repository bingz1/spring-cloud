package cloud.simple.cloudzuul;

import org.joda.time.LocalTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.Date;

public class CloudZuulApplicationTests {

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void contextLoads() throws InterruptedException {
        int count = 0;
        while (true){
            String s = restTemplate.getForObject("https://api-staging.wework.cn/chinaos/baseService/api/v1/fe/base/front/switch", String.class);
            if (s.contains("Forwarding error")){
                count ++;
                System.out.println(new LocalTime().toString()+":error"+count);
            }else {
                System.out.println(new LocalTime().toString()+":true"+count);
            }
            Thread.sleep(200);
        }
    }

}
