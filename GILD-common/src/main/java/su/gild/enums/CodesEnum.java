package su.gild.enums;

public class CodesEnum {
    public enum Lifetime {
        VERIFY(),
        DELETE();

        private final long time;

        Lifetime(long time) {
            this.time = time;
        }

        public long getValue() {
            return time;
        }
    }
}