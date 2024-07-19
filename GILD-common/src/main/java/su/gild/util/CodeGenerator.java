package su.gild.util;

import java.util.Random;

public class CodeGenerator {

    // ...
    public static String generateDigitCode() {
        Random random = new Random();
        int min = 100_000;
        int max = 999_999;

        int generateNumber = random.nextInt((max - min) + 1) + min;
        return String.format("%06d", generateNumber);
    }

    // ...
    public static String generateLetterCode() {
        int codeLength = 10;
        StringBuilder code = new StringBuilder();

        Random random = new Random();

        for(int index = 0; index < codeLength; index++) {
            char randomChar = (char)(random.nextInt(26) + 'A');
            code.append(randomChar);
        }

        return code.toString();
    }
}