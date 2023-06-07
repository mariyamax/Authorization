package authorization.utils;

import com.github.javafaker.Faker;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PasswordUtils {


    private static final String PASSWORD_PATTERN = "^([a-z](?=.*[!@#%()-[{}];:',&/*~$^+=<>]).(?=.*[0-9])).{6}$";
    private static final Pattern pattern = Pattern.compile(PASSWORD_PATTERN);
    private static final Faker faker = new Faker();

    private static final int MAX_VALUE = 100;
    private static final int MIN_VALUE = 0;

    public static String generateRandomString() {
        String password = faker.crypto().sha512().substring(0,7).concat("!");
        password.length();
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
