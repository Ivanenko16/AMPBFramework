package utils;

import static constants.Constants.*;

public class UrlFactory {

    public static String getUrl(String pageName) {
        String url = null;
        switch (pageName) {
            case ("Initial home page"):
                url = HOME_URL;
                break;
            case ("Login page"):
                url = LOGIN_URL;
                break;
            case ("Contact page"):
                url = CONTACT_URL;
                break;
            case ("Help page"):
                url = HELP_URL;
                break;
            case ("Wish page"):
                url = WISH_URL;
                break;
            case ("Track page"):
                url = TRACK_URL;
                break;
        }
        return url;
    }
}
