package cloud.simple.client.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author wsq
 */
public class ServiceException extends GlobalException {
    public ServiceException(int code, String message) {
        super(code, message);
    }
}
