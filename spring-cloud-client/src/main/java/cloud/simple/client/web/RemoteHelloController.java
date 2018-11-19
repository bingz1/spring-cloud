package cloud.simple.client.web;

import cloud.simple.client.service.RemoteHelloService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by zxb on 7/6/16.
 */
@RestController
public class RemoteHelloController {

    @Autowired
    RemoteHelloService remoteHelloService;

    @RequestMapping("remoteHello")
    public String remoteHello() {
        return "wework";
    }

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @RequestMapping("ribbonHello")
    public String ribbonHello() {
        String body = restTemplate.getForEntity("http://test-service/hello", String.class).getBody();
        return body;
    }

    public String timeout(){
        return "超时";
    }
}
