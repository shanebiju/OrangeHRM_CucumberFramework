package com.automation.utils;

import java.util.Random;

public class RandomGenerator {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()";
    private static final String DIGITS="0123456789";
    private static final Random random = new Random();

    public static String generateRandomUsername(int length) {
        StringBuilder username = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            username.append(CHARACTERS.charAt(index));
        }

        return username.toString();
    }

    public static String generateRandomPassword(int length) {
        StringBuilder password = new StringBuilder();
        password.append(DIGITS.charAt(random.nextInt(DIGITS.length())));
        for (int i = 1; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length() + SPECIAL_CHARACTERS.length());
            if (index < CHARACTERS.length()) {
                password.append(CHARACTERS.charAt(index));
            } else {
                password.append(SPECIAL_CHARACTERS.charAt(index - CHARACTERS.length()));
            }
        }

        return password.toString();
    }

}
