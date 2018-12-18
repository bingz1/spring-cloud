package cloud.simple.client.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Enumeration;

/**
 * @author wsq
 * 全局异常拦截类
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private Logger logger = LoggerFactory.getLogger(this.getClass().getName());

    @ExceptionHandler(Throwable.class)
    public String handlerException(HttpServletRequest request, Throwable throwable) throws IOException {
        logger.error("全局异常拦截:", throwable);
        StringBuilder messageBuilder = new StringBuilder("Unhandled exception in request:\n");
        messageBuilder.append(request.getMethod());
        messageBuilder.append(" ");
        messageBuilder.append(request.getRequestURI());
        messageBuilder.append("\nHeader:");
        Enumeration<String> headerNames = request.getHeaderNames();
        if (headerNames.hasMoreElements()) {
            String name = headerNames.nextElement();
            String value = request.getHeader(name);
            messageBuilder.append("\n" + name + ":" + value + "\n");
        }
        messageBuilder.append("\nParameters:");
        Enumeration<String> parameterNames = request.getParameterNames();
        if (parameterNames.hasMoreElements()) {
            String name = parameterNames.nextElement();
            String value = request.getParameter(name);
            messageBuilder.append("\n" + name + ":" + value + "\n");
        }
        messageBuilder.append("\npostBody:");
        String postBody = StreamUtils.copyToString(request.getInputStream(), Charset.forName("UTF-8"));
        messageBuilder.append("\n" + postBody);
        logger.error(messageBuilder.toString(), throwable);
        return messageBuilder.toString();
    }


}