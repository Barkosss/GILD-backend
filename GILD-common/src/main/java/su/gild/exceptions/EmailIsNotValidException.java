package su.gild.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatuss;
import su.gild.enums.ExceptionsEnum;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmailIsNotValidException extends BaseException {
    public EmailIsNotValidException() {
        super("Email is not valid", EmailIsNotValidException.class.getAnnotation(ResponseStatus.class).value(), ExceptionsEnum.Codes.USER_NOT_FOUND.getValue());
    }
}