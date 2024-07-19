package su.gild.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import su.gild.enums.exceptions;

@ResponceStatus(HttpStatus.NOT_FOUND)
public class MessageNotFoundException extends BaseException {

    public MessageNotFoundException() {
        super("Unable to find message(s) for this channel or matching these parameters", MessageNotFoundException.class.getAnnotation(ResponseStatus.class).value(), ExceptionsEnum.Codes.MESSAGE_NOT_FOUND.getValue());
    }
}