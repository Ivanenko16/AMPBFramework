package utils;

public class RegexRun {

    public static void main(String[] args) {

        String email = "as.bulk@mail.com";
        String email1 = "as.bulk@mail.";
        String ip = "172.15.75.213";
        String ip1 = "172.15.75";
        String cardNumber = "4532152161137134";
        String cardNumber1 = "4532152a61137134";

        System.out.println(RegexUtil.isValidEmail(email));
        System.out.println(RegexUtil.isValidEmail(email1));
        System.out.println(RegexUtil.isValidIp4Address(ip));
        System.out.println(RegexUtil.isValidIp4Address(ip1));
        System.out.println(RegexUtil.isValidVisaCardNumber(cardNumber));
        System.out.println(RegexUtil.isValidVisaCardNumber(cardNumber1));
    }
}
