package cloud.simple.service.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 *
 * @author zxb
 * @date 7/5/16
 */
@RestController
public class RemoteHelloController {

    @Autowired
    private DiscoveryClient client;

    @RequestMapping("hello")
    public String hello(){
        long start = System.currentTimeMillis();

        String instance = client.getServices().get(0);

        try {
            Thread.sleep(new Random().nextInt(100));
        }catch (Exception e){
            e.printStackTrace();
        }

        long cost = System.currentTimeMillis() - start;

        return "Remote Hello ~" + instance + ", spent " +cost;
    }

}
