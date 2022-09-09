package enums;

public enum RequestPaths {

    USERS_CARTS("api/v2/kvn/users/anonymous/carts"),
    USER_ENTRIES("api/v2/kvn/users/anonymous/carts/{guid}/entries");

    public final String path;

    RequestPaths(String path) {
        this.path = path;
    }

}
