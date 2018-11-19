package me.wantgo.common.web;

import me.wantgo.common.entity.ErrorResult;
import me.wantgo.common.entity.RawString;
import me.wantgo.common.entity.ReturnValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.nio.charset.StandardCharsets;

/**
 * Created by zxb on 7/1/16.
 */
@ControllerAdvice
public class ReturnValueController implements ResponseBodyAdvice {

    private final Logger logger = LoggerFactory.getLogger(ReturnValueController.class);

    /**
     * 处理返回字符串.
     * @param response response
     * @param string string
     * @return
     */
    private Void printRawString(ServerHttpResponse response, String string) {
        try {
            response.getHeaders().setContentType(MediaType.TEXT_PLAIN);
            response.getBody().write(string.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
            this.logger.error("write raw string failed", e);
        }
        return null;
    }

    @Override
    public Object beforeBodyWrite(Object body,
                                  MethodParameter methodParameter,
                                  MediaType mediaType, Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse response) {
        if (null == body)
            return new ReturnValue(true, null);
        else if (body instanceof ReturnValue)
            return body;
        else if (body instanceof ErrorResult)
            return new ReturnValue(false, body);
        else if (body instanceof RawString)
            return this.printRawString(response, body.toString());
        else{
            ReturnValue returnValue = new ReturnValue(true,body);
            return returnValue;
        }

    }

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }


}
