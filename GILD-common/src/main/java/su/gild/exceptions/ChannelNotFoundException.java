package su.gild.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import su.gild.enums.ExceptionsEnum;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ChannelNotFoundException extends BaseException {

    public ChannelNotFoundException() {
        super("Unknown channel", ChannelNotFoundException.class.getAnnotation(ResponseStatus.class).value(), ExceptionsEnum.Codes.CHANNEL_NOT_FOUND.getValue());
    }
}