package commons;

import org.testng.ITestResult;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Class này dùng để lưu trữ tất cả các lỗi xảy ra trong một test case
 * Nó sử dụng Singleton pattern để đảm bảo chỉ có 1 instance duy nhất
 */
public class VerificationFailures extends HashMap<ITestResult, List<Throwable>> {

    // Singleton instance - chỉ có 1 object duy nhất trong toàn bộ chương trình
    private static VerificationFailures failures;
    private static final long serialVersionUID = 1L;

    /**
     * Constructor private để prevent việc tạo object từ bên ngoài
     * Đây là nguyên tắc của Singleton pattern
     */
    private VerificationFailures() {
        super(); // Gọi constructor của HashMap
    }

    /**
     * Method này trả về instance duy nhất của VerificationFailures
     * Nếu chưa có thì tạo mới, nếu có rồi thì trả về instance cũ
     */
    public static VerificationFailures getFailures() {
        if (failures == null) {
            failures = new VerificationFailures();
        }
        return failures;
    }

    /**
     * Lấy danh sách tất cả lỗi của một test case cụ thể
     *
     * @param result - kết quả của test case
     * @return danh sách các exception/lỗi
     */
    public List<Throwable> getFailuresForTest(ITestResult result) {
        List<Throwable> exceptions = get(result); // get() là method của HashMap
        return exceptions == null ? new ArrayList<Throwable>() : exceptions;
    }

    /**
     * Thêm một lỗi mới cho test case
     *
     * @param result    - kết quả test case
     * @param throwable - lỗi cần thêm vào
     */
    public void addFailureForTest(ITestResult result, Throwable throwable) {
        List<Throwable> exceptions = getFailuresForTest(result);
        exceptions.add(throwable);
        put(result, exceptions); // put() là method của HashMap
    }
}