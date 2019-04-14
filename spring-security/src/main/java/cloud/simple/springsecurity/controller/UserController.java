package cloud.simple.springsecurity.controller;

import cloud.simple.springsecurity.entity.User;
import cloud.simple.springsecurity.security.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;


/**
 * @author xiangbingzhang
 * @date 2019-01-10
 **/
@RestController
public class UserController {

    @Autowired
    private TokenAuthenticationService tokenAuthenticationServicel;

    @PostMapping("/login")
    public User login(@RequestBody User user, HttpServletResponse response){
        tokenAuthenticationServicel.addAuthentication(response,user.getName());
        return user;
    }

    @GetMapping("open/needLogin")
    public String needLogin(){
        return "1231";
    }

    @GetMapping("/user/name")
    public String index() {
        return "user";
    }

}
