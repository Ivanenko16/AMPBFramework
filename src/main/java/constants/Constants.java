package constants;

public final class Constants {

    private Constants() {
    }

    public static final String WEB_DRIVER_FILE_PATH = "src/main/resources/chromedriver.exe";
    public static final String LOGIN_URL = "https://www.bookdepository.com/account/login/to/account";
    public static final String HOME_URL = "https://www.bookdepository.com/";
    public static final String HELP_URL = "https://www.bookdepository.com/help";
    public static final String CONTACT_URL = "https://www.bookdepository.com/contactus";
    public static final String TRACK_URL = "https://www.bookdepository.com/track";
    public static final String WISH_URL = "https://www.bookdepository.com/account/login";
    public static final String BESTSELLERS_URL = "https://www.bookdepository.com/bestsellers";
    public static final int IMPLICIT_WAIT_TIMEOUT = 5;
    public static final int PAGE_LOAD_TIMEOUT = 20;
    public static final String IMAGE_PNG = "image/png";
    public static final String ONLY_NUMBER = "[^0-9.]";
    public static final String EMAIL_PATTERN = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    public static final String IPV4_PATTERN = "^(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])(\\.(?!$)|$)){4}$";
    public static final String VISA_CARD_NUMBER_PATTERN = "^4[0-9]{12}(?:[0-9]{3})?$";
}
