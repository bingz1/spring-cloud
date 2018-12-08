package cloud.simple.cloudzuul.filter;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author wsq
 * feign发送请求前，把header中的信息取出放入feign请求线程中
 */
@Configuration
public class FeignInterceptor implements RequestInterceptor {

    @Override
    public void apply(RequestTemplate template) {
        Map<String, String> headerMap = ServiceInterceptor.headerRepository.get();
        headerMap.forEach(template::header);
    }
}
