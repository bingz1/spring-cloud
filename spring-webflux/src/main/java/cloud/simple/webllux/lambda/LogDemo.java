package cloud.simple.webllux.lambda;


import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author 张向兵
 * @date 2019-05-12.
 */
@Slf4j
public class LogDemo {

    private static final Logger logger = Logger
            .getLogger(LogDemo.class.getName());

    @Override
    public String toString() {
        System.out.println("这个方法执行了, 耗时1秒钟");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
        }

        return "LogDemo";
    }

    public void test() {
        if (log.isInfoEnabled()) {
            log.info("" + this);
        }

        logger.fine(() -> "123");
    }

    public static void main(String[] args) {
        LogDemo logDemo = new LogDemo();
        logDemo.test();

    }
}
