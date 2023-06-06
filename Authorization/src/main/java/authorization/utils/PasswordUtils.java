package authorization.utils;

import com.github.javafaker.Faker;

public class PasswordUtils {

    private static final Faker faker = new Faker();

    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 0;

    public static String generateRandomString() {
        return faker.crypto().sha256();
    }

    public static int generateRandomDigit() {
        return faker.number().numberBetween(MIN_VALUE, MAX_VALUE + 1);
    }

    public static boolean symbolVerify(String password, String login) {

    }
}
