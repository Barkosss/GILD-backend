package su.gild.enums;

public class APIEnum {
    public static final String MESSAGES = "/v1/messages";
    public static final String USERS = "/v1/userus";
    public static final String AUTH = "/v1/auth";

    public enum RateLimit {
        CAPACITY(20),
        TOKENS(20),
        MINUTES(1);

        private final int value;

        RateLimit(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}