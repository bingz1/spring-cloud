package cloud.simple.client.web;

import org.springframework.stereotype.Component;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
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
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        if (!request.getContentType().contains("multipart/form-data")) {
            RequestWrapper requestWrapper = new RequestWrapper(httpServletRequest);
            /**
             * 获取 request 中 body值 进行解密校验
             * 如果是get方法 校验方式
             * 如果是post方法 校验方式
             */
            String method = httpServletRequest.getMethod();
            System.out.println(requestWrapper.getBody());
        }
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
