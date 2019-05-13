package cloud.simple.webllux.lambda;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;


/**
 * @author 张向兵
 * @date 2019-05-12.
 */
public class RunStream {
    public static void main(String[] args) {
        Random random = new Random();

        Stream stream = Stream.generate(() -> random.nextInt()).limit(500).peek(s -> print("peek" + s))
                .filter(s -> s > 1000).sorted((i1, i2) -> i1.compareTo(i1))
                .peek(s -> print("peek" + s))
                .parallel();
        stream.count();

    }

    /**
     * 打印日志并sleep 5 毫秒
     *
     * @param s
     */
    public static void print(String s) {
        // System.out.println(s);
        System.out.println(Thread.currentThread().getName() + " > " + s);
        try {
            TimeUnit.MILLISECONDS.sleep(5);
        } catch (InterruptedException e) {
        }
    }
}
