package cloud.simple.server.service;

import org.slf4j.MDC;
import org.springframework.stereotype.Service;

/**
 * @author xiangbingzhang
 * @data 2018-11-23
 **/
@Service
public class RemoteHelloService {

    public Integer cale(Integer para) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para * para;
    }

}
