package cloud.simple.webllux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author xiangbingzhang
 * @data 2018-12-29
 **/
@RestController
@RequestMapping("users")
public class MyRestController {

    @GetMapping
    public Mono<User> getUser() {

        User user = new User();
        user.setAge(20);
        user.setName("张三");
        return Mono.just(user);
    }

}
