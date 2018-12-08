package cloud.simple.client.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by zxb on 7/6/16.
 */
@FeignClient("test-server")
public interface RemoteHelloService {

    @RequestMapping(value = "hello",method = RequestMethod.GET)
    String remoteHello();

}
