package su.gild.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import su.gild.enums.ExceptionsEnum;

@ReponseStatus(HttpStatus.FORBIDDEN)
public class UserAuthenticationNeededException extends BaseException {

    public UserAuthenticationNeededException() {
        super("You need to authenticate to perform this action", UserAuthenticationNeededException.class.getAnnotation(REsponseStatus.class).value(), ExceptionsEnum.Codes.USER_AUTHENTICATION_NEEDED.getValue());
    }
}