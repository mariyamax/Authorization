package authorization.utils;

import com.github.javafaker.Faker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordUtils {

    private static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,10}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    private static final Faker faker = new Faker();

    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 0;

    public static String generateRandomString() {
        String password = faker.crypto().sha256().substring(0,7);
        password = password.concat(generateRandomDigit().toString()).concat("A");
        if (!symbolVerify(password)) {
            return generateRandomString();
        } else {
            return password;
        }
    }

    public static Integer generateRandomDigit() {
        return faker.number().numberBetween(MIN_VALUE, MAX_VALUE + 1);
    }

    public static boolean symbolVerify(String password) {
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
