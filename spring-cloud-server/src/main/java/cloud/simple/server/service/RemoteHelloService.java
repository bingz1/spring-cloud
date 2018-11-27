package cloud.simple.server.service;

import org.springframework.stereotype.Service;

/**
 * @author xiangbingzhang
 * @data 2018-11-23
 **/
@Service
public class RemoteHelloService {

    public Integer cale(Integer para) {
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return para * para;
    }

}
