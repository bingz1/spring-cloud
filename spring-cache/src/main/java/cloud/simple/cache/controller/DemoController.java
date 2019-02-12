package cloud.simple.cache.controller;

import cloud.simple.cache.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiangbingzhang
 * @date 2019-01-16
 **/
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @GetMapping("/demo")
    public String getPhone(){
        return demoService.getA("185");
    }

}
