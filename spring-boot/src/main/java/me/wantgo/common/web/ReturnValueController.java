package me.wantgo.common.web;

import me.wantgo.common.entity.ErrorResult;
import me.wantgo.common.entity.RawString;
import me.wantgo.common.entity.ReturnValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created by zxb on 7/1/16.
 */
@Component
@ControllerAdvice
public class ReturnValueController implements ResponseBodyAdvice {

    private Logger logger = LoggerFactory.getLogger(ReturnValueController.class);

    /**
     * 处理返回字符串.
     * @param response response
     * @param string string
     * @return
     */
    private Void printRawString(final ServerHttpResponse response, final String string) {
        try {
            response.getHeaders().setContentType(MediaType.TEXT_PLAIN);
            response.getBody().write(string.getBytes("US-ASCII"));
        } catch (Exception e) {
            logger.error("write raw string failed", e);
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
            return printRawString(response, body.toString());
        else
            return new ReturnValue(true, body);
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }
}
