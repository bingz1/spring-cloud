package cloud.simple.springsecurity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class SpringSecurityApplicationTests {

    private static final String AUTHORIZATION_BASE_URI = "/oauth2/authorization";
    private static final String AUTHORIZE_BASE_URL = "http://localhost:8080/login/oauth2/code";

	@Test
	public void contextLoads() {
	    //"$2a$10$4gIaDSGLiNgkUViXa1UcheeWKyeKOJBlGj4DY1ltjfCXNYZam2a0C";

        System.out.println(BCrypt.hashpw("123456",BCrypt.gensalt()));
        System.out.println(BCrypt.checkpw("123456","$2a$10$4gIaDSGLiNgkUViXa1UcheeWKyeKOJBlGj4DY1ltjfCXNYZam2a0C"));
	}

}

