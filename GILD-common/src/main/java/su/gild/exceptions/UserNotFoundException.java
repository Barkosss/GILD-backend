package su.gild.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import su.gild.enums.ExceptionsEnum;

@ReponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundException extends BaseException {

    public UserNotFoundException() {
        super("Unknown user", UserNotFoundException.class.getAnnotation(ResponseStatus.class).value(), ExceptionsEnum.Codes.USER_NOT_FOUND.getValue());
    }
}