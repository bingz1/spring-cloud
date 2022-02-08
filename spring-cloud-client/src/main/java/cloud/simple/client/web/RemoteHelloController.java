package cloud.simple.client.web;

import cloud.simple.client.service.RemoteHelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;


/**
 *
 * @author zxb
 * @date 7/6/16
 */
@RestController
public class RemoteHelloController {

    @Autowired
    RemoteHelloService remoteHelloService;

    @RequestMapping("remoteHello")
    public String remoteHello() {
        return "test";
    }

    @PostMapping("person")
    public Person addPerson(@RequestBody Person person) {
        return person;
    }

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    @PostMapping(value = "transferFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String transferFile(@RequestPart(name = "files") MultipartFile[] files) {
        return remoteHelloService.transferFile(files);
    }

    @RequestMapping("ribbonHello")
    public String ribbonHello() {
        String body = restTemplate.getForEntity("http://test-server/hello", String.class).getBody();
        return body;
    }

    public String timeout() {
        return "超时";
    }
}
