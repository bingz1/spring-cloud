package cloud.simple.client.web;

import com.alibaba.ttl.TransmittableThreadLocal;
import org.slf4j.MDC;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author wsq
 * service拦截器，进行traceID埋点和接口耗时统计
 */
@Configuration
public class ServiceInterceptor implements WebMvcConfigurer {

    public static final TransmittableThreadLocal<Map<String, String>> headerRepository = new TransmittableThreadLocal<>();

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(requestInterceptor());
    }

    private HandlerInterceptorAdapter requestInterceptor() {
        return new HandlerInterceptorAdapter() {
            @Override
            public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
                return requestHandler(request, response, handler);
            }
        };
    }

    private boolean requestHandler(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        MDC.put("userID", request.getHeader("userID"));

        //把request塞到线程变量里去，防止异步调用丢失requestcontextholder
        headerRepository.set(MDC.getCopyOfContextMap());

        return true;
    }
}
