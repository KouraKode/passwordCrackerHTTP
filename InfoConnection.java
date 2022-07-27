public class InfoConnection {
    private static final String USER_AGENT = "Mozilla/5.0";

	// private static final String GET_URL = "http://localhost/TestCracking/login.php";

	private static final String POST_URL = "http://localhost/TestCracking/login.php";
    private static final String HOME_URL = "http://localhost/TestCracking/home.php";



    public static String getUserAgent() {
        return USER_AGENT;
    }
    public static String getPostUrl() {
        return POST_URL;
    }
    public static String getHomeUrl() {
        return HOME_URL;
    }
}
