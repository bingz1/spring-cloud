package cloud.simple.client.web;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author wsq
 * feign发送请求前，把header中的信息取出放入feign请求线程中
 */
@Configuration
public class FeignInterceptor implements RequestInterceptor{

    @Override
    public void apply(RequestTemplate template) {
        System.out.println("**********************************");
        Map<String, String> headerMap = ServiceInterceptor.headerRepository.get();
        if (headerMap != null){
            headerMap.forEach(template::header);
        }
    }
}
