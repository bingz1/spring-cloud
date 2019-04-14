package cloud.simple.springsecurity.security;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.servlet.http.HttpServletResponse;

import static org.junit.Assert.*;

/**
 * @author 张向兵
 * @date 2019-04-14.
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TokenAuthenticationServiceTest {

    @Autowired
    HttpServletResponse response;

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @Test
    public void addAuthentication() {
        tokenAuthenticationService.addAuthentication(response,"张向兵");
    }

    @Test
    public void getAuthentication() {
    }
}