package cloud.simple.cache.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author xiangbingzhang
 * @date 2019-01-16
 **/
@Service
public class DemoService {

    @Cacheable(value = "name", key = "#phone")
    public String getNanme(String phone) {
        return phone;
    }

    public String getA(String phone){
        return getNanme(phone);
    }

}
