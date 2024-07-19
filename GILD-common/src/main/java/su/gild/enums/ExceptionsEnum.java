package su.gild.enums;

public class ExceptionsEnum {
    public enum Codes {
        MESSAGE_NOT_FOUND(101),
        PROFILE_NOT_FOUND(102),
        POT_NOT_FOUND(103),
        DONATE_NOT_FOUND(104),
        CHANNEL_NOT_FOUND(105),
        USER_NOT_FOUND(201),
        USER_EMAIL_NOT_VERIFIED(202),
        USER_AUTHENTICATION_NEEDED(203),
        USER_WITH_THIS_EMAIL_ALREADY_EXIST(204),
        USER_CREDENTIALS_IS_INVALID(205),
        CODE_IS_INVALID(301),


        private final int code;

        Codes(int code) {
            this.code = code;
        }

        public int getValue() {
            return code;
        }
    }
}