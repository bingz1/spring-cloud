package me.wantgo.common.web;

import me.wantgo.common.entity.ErrorResult;
import me.wantgo.common.util.EnumerationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * Global exception controller.
 * <p>
 * Handles all exceptions, if the exception have a response status,
 * set the HTTP status to that, else set the HTTP status to 500.
 * <p>
 * Error message displays only if the response status presents,
 * having the first non-empty value of following:
 * <ol>
 * <li>Response status reason</li>
 * <li>Localized message of exception</li>
 * <li>"Unknown error"</li>
 * </ol>
 * <p>
 * This handler also log every exception the generate 5XX error.
 */
@Component
@ControllerAdvice
public class GlobalExceptionController {

    /**
     * 日志记录类.
     */
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionController.class);

    /**
     * 异常处理类.
     * @param e Exception
     * @return ErrorResult
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public final ErrorResult handleException(HttpServletRequest request, Exception e) {
        int code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        String message = "服务器开了小差,请稍后重试.";

        ResponseStatus status = e.getClass().getAnnotation(ResponseStatus.class);
        if (status != null) {
            code = status.value().value();

            if (!StringUtils.isEmpty(status.reason())) {
                message = status.reason();
            } else if (!StringUtils.isEmpty(e.getLocalizedMessage())) {
                message = e.getLocalizedMessage();
            }
        }

        if (code >= HttpStatus.INTERNAL_SERVER_ERROR.value()) {
            StringBuilder messageBuilder = new StringBuilder("Unhandled exception in request:\n");
            messageBuilder.append(request.getMethod());
            messageBuilder.append(" ");
            messageBuilder.append(request.getRequestURI());
            messageBuilder.append("\nHeader:");
            EnumerationUtils.toIterable(request::getHeaderNames).forEach(name -> {
                messageBuilder.append("\n");
                String value = request.getHeader(name);
                messageBuilder.append(name);
                messageBuilder.append(": ");
                messageBuilder.append(value);
            });
            this.logger.error(messageBuilder.toString(), e);
        }

        return new ErrorResult(code, message);
    }
}
