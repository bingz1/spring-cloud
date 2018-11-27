package cloud.simple.cloudzuul.filter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zxb on 7/6/16.
 */
@RestController
public class RemoteHelloController {

    @RequestMapping("remoteHello")
    public String remoteHello() {
        return "wework";
    }

    public String timeout(){
        return "超时";
    }
}
