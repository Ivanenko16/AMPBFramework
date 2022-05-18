package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constants.Constants.*;

public class RegexUtil {

    public static boolean isValidEmail(String email) {

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidIp4Address(String ip4) {

        Pattern pattern = Pattern.compile(IPV4_PATTERN);
        Matcher matcher = pattern.matcher(ip4);
        return matcher.matches();
    }

    public static boolean isValidVisaCardNumber(String cardNumber) {

        Pattern pattern = Pattern.compile(VISA_CARD_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(cardNumber);
        return matcher.matches();
    }
}
