package cloud.simple.client.web;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author xiangbingzhang
 * @data 2018-11-27
 **/
@Component
public class OauthInterceptor implements Filter {


    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)request;
        RequestWrapper requestWrapper = new RequestWrapper(httpServletRequest);
        /**
         * 获取 request 中 body值 进行解密校验
         * 如果是get方法 校验方式
         * 如果是post方法 校验方式
         */
        String method = httpServletRequest.getMethod();
        System.out.println(requestWrapper.getBody());

        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void destroy() {

    }
}
