package commons;

public class GlobalConstants {
    // System Info - Lấy thông tin hệ thống
    public static final String PROJECT_PATH = System.getProperty("user.dir");
    public static final String OS_NAME = System.getProperty("os.name");
    public static final String SEPARATOR = System.getProperty("file.separator");

    // Admin Info - Thông tin đăng nhập admin
    public static final String ADMIN_USERNAME = "admin";
    public static final String ADMIN_PASSWORD = "guru99com";

    // Wait Info - Thời gian chờ
    public static final long SHORT_TIMEOUT = 10;
    public static final long LONG_TIMEOUT = 30;
    public static final long POLLING_TIMEOUT = 500; // milliseconds

    // Download/Upload file - Đường dẫn file
    public static final String UPLOAD_PATH = PROJECT_PATH + SEPARATOR + "uploadFiles" + SEPARATOR;
    public static final String DOWNLOAD_PATH = PROJECT_PATH + SEPARATOR + "downloadFiles" + SEPARATOR;

    // Retry Case Failed - Số lần thử lại khi test fail
    public static final int RETRY_NUMBER = 3;

    // Browser Logs/Extension - Đường dẫn logs và extension
    public static final String BROWSER_LOG_PATH = PROJECT_PATH + SEPARATOR + "browserLogs" + SEPARATOR;
    public static final String BROWSER_EXTENSION_PATH = PROJECT_PATH + SEPARATOR + "browserExtensions" + SEPARATOR;

    // HTML Report Folder - Đường dẫn các loại report
    public static final String REPORTNG_PATH = PROJECT_PATH + SEPARATOR + "htmlReportNG" + SEPARATOR;
    public static final String EXTENT_PATH = PROJECT_PATH + SEPARATOR + "htmlExtent" + SEPARATOR;
    public static final String ALLURE_PATH = PROJECT_PATH + SEPARATOR + "htmlAllure" + SEPARATOR;

    // Data Test/Environment - Đường dẫn data test và config
    public static final String DATA_TEST_PATH = PROJECT_PATH + SEPARATOR + "dataTest" + SEPARATOR;
    public static final String ENVIRONMENT_CONFIG_PATH = PROJECT_PATH + SEPARATOR + "environmentConfig" + SEPARATOR;

    // Browser Name - Tên các browser
    public static final String CHROME_BROWSER = "chrome";
    public static final String FIREFOX_BROWSER = "firefox";
    public static final String EDGE_BROWSER = "edge";
    public static final String SAFARI_BROWSER = "safari";

    // Environment - Các môi trường test
    public static final String DEV_ENVIRONMENT = "dev";
    public static final String STAGING_ENVIRONMENT = "staging";
    public static final String PRODUCTION_ENVIRONMENT = "production";
}