package cloud.simple.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xiangbingzhang
 * @date 2019-01-10
 **/
@RestController
public class UserController {

    @GetMapping("/ss/name")
    public String index() {
        return "user";
    }

}
