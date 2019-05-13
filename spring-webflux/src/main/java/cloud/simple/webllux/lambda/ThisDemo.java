package cloud.simple.webllux.lambda;

/**
 * @author 张向兵
 * @date 2019-05-12.
 */
public class ThisDemo {

    private String name = "ThisDemo";

    public void test() {

        new Thread(new Runnable() {

            private String name = "Runnable";

            @Override
            public void run() {
                System.out.println(this.name);
            }
        }).start();


        new Thread(() -> {
            System.out.println(this.name);
        }).start();
    }

    public static void main(String[] args) {
        ThisDemo demo = new ThisDemo();
        demo.test();
    }
}
