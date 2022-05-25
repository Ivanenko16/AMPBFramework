package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static constants.RegexExpression.*;

public class RegexUtil {
    public static String getStringByPattern(String pattern, String matcher) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(matcher);
        if (m.find()) {
            return m.group();
        } else {
            return null;
        }
    }

    public static boolean isValidEmail(String email) {
        return patternMatcher(EMAIL_PATTERN, email);
    }

    public static boolean isValidIp4Address(String ip4) {
        return patternMatcher(IPV4_PATTERN, ip4);
    }

    public static boolean isValidVisaCardNumber(String cardNumber) {
        return patternMatcher(VISA_CARD_NUMBER_PATTERN, cardNumber);
    }

    private static boolean patternMatcher(String pattern, String matcher) {
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(matcher);
        return m.matches();
    }
}
