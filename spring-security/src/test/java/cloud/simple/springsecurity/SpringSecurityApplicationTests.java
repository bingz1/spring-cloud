package cloud.simple.springsecurity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
@AutoConfigureMockMvc
public class SpringSecurityApplicationTests {

	@Test
	public void contextLoads() {
        System.out.println(BCrypt.hashpw("123456",BCrypt.gensalt()));
        System.out.println(BCrypt.checkpw("123456","$2a$10$4gIaDSGLiNgkUViXa1UcheeWKyeKOJBlGj4DY1ltjfCXNYZam2a0C"));
	}

}

