package com.example;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_=+[]{};:,.<>?";
    private static final String ALL_CHARACTERS = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;

    private SecureRandom random = new SecureRandom();

    public String generatePassword(int length, boolean includeUppercase, boolean includeDigits, boolean includeSpecialChars) {
        StringBuilder password = new StringBuilder(length);
        String characterSet = LOWERCASE;

        if (includeUppercase) {
            characterSet += UPPERCASE;
        }
        if (includeDigits) {
            characterSet += DIGITS;
        }
        if (includeSpecialChars) {
            characterSet += SPECIAL_CHARACTERS;
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(characterSet.length());
            password.append(characterSet.charAt(randomIndex));
        }

        return password.toString();
    }
}
