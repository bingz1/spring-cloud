package cloud.simple.cloudzuul;

import org.joda.time.LocalTime;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

public class CloudZuulApplicationTests {

    RestTemplate restTemplate = new RestTemplate();

    @Test
    public void contextLoads() throws InterruptedException {
        int count = 0;
        while (true) {
            String s = restTemplate.getForObject("https://api-staging.wework.cn/chinaos/baseService/api/v1/fe/base/front/switch", String.class);
            if (s.contains("Forwarding error")) {
                count++;
                System.out.println(new LocalTime() + ":error" + count);
            } else {
                System.out.println(new LocalTime() + ":true" + count);
            }
            count++;
            Thread.sleep(200);
            if (count > 2) {
                break;
            }
        }
    }

}
