package cloud.simple.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author xiangbingzhang
 * @date 2019-01-10
 **/
@RestController
public class AdminController {

    @GetMapping("/admin/name")
    public String index() {

        return "admin";
    }

}
