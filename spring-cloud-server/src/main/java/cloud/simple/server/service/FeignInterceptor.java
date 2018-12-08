package cloud.simple.server.service;

import feign.RequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author wsq
 * feign发送请求前，把header中的信息取出放入feign请求线程中
 */
@Configuration
public class FeignInterceptor {

    @Bean
    public RequestInterceptor requestInterceptor() {
        return (template) -> {
            Map<String, String> headerMap = ServiceInterceptor.headerRepository.get();
            if (headerMap != null) {
                headerMap.forEach(template::header);
            }
        };
    }
}
