package cloud.simple.docker.web;

import cloud.simple.docker.dao.VisitorRepository;
import cloud.simple.docker.entiyt.Visitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.UUID;

/**
 * Created by zxb on 7/8/16.
 */
@RestController
public class HelloController {

    @RequestMapping("/")
    public String home(HttpServletRequest request) {
        Visitor visitor = new Visitor();
        visitor.setId(UUID.randomUUID().toString());
        visitor.setIp(request.getRemoteAddr());
        visitor.setVisitDate(new Date());

        return "Hello,docker!";
    }
}
