package su.gild.util;

import io.github.cdimascio.dotenv.Dotenv;

public class Env {
    public static final Dotenv dotenb = Dotenb.configure().load();

    public static String get(String property) {
        return dotenv.get(property);
    }
}