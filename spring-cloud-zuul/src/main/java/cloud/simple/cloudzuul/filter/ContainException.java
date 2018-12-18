package cloud.simple.cloudzuul.filter;

import com.netflix.zuul.context.RequestContext;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @author xiangbingzhang
 * @data 2018-11-26
 **/
@RestController
public class ContainException implements ErrorController{

    @Override
    public String getErrorPath() {
        return "error";
    }

    @RequestMapping("error")
    public String remoteHello(HttpServletRequest request, HttpServletResponse response1) {
        Enumeration<String> names = request.getAttributeNames();
        while (names.hasMoreElements()){
            String name = names.nextElement();
            //System.out.println(name +"  "+ request.getAttribute(name));
        }

        RequestContext ctx = RequestContext.getCurrentContext();
        Throwable throwable = ctx.getThrowable();
        Throwable cause = throwable.getCause();
        ctx.setResponseStatusCode(200);
        return cause.getMessage();
    }
}
