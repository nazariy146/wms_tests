package tests.mobile.mobileUtils;

import com.google.common.base.Stopwatch;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.sleep;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class AssertionUtils {

    private static final int DEFAULT_POLL_INTERVAL = Math.toIntExact(Duration.ofSeconds(10).toMillis());

    public static final int WAIT_TASK_TIMEOUT = Math.toIntExact(Duration.ofSeconds(200).toMillis());

    public static void waitUntilPass(int timeout, URunnable task) throws Exception {
        waitUntilPass(timeout, DEFAULT_POLL_INTERVAL, task);
    }

    public static void waitUntilPass(int timeout, int pollInterval, URunnable task) throws Exception {
        AssertionError lastAssertionError;
        Stopwatch stopwatch = Stopwatch.createStarted();
        do {
            try {
                task.run();
                return;
            } catch (AssertionError e) {
                lastAssertionError = e;
            }
            sleep(pollInterval);
        }
        while (stopwatch.elapsed(MILLISECONDS) < timeout);
        throw lastAssertionError;
    }
}
