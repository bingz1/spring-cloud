package cloud.simple.springsecurity.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.servlet.http.HttpServletResponse;


/**
 * @author 张向兵
 * @date 2019-04-14.
 */
@SpringBootTest
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