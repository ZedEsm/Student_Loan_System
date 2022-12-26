package util;

import exceptions.ValidationException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
    public static void isValidPassword(String password) throws ValidationException {
        String regex = "^(?=.*[0-9])"
                + "(?=.*[a-z])(?=.*[A-Z])"
                + "(?=.*[@#$%^&+=])"
                + "(?=\\S+$).{8}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        boolean matches = matcher.matches();
        if (!matches) {
            throw new ValidationException("password should contain 8 character and at least one upperCse, one lowerCase, one character & % $ # @ , one number");
        }

    }
}
