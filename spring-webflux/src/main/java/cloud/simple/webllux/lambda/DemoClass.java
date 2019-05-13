package cloud.simple.webllux.lambda;

import java.util.function.IntUnaryOperator;

/**
 * @author 张向兵
 * @date 2019-05-12.
 */
public class DemoClass {

    public static int staticMethod(int i) {
        return i * 2;
    }

    public int normalMethod(int i) {
        return i * 3;
    }

    public static void main(String[] args) {
        IntUnaryOperator intUnaryOperator = DemoClass::staticMethod;
        System.out.println(intUnaryOperator.applyAsInt(11));

        DemoClass demoClass = new DemoClass();

        IntUnaryOperator intUnaryOperator1 = demoClass::normalMethod;

        System.out.println(intUnaryOperator1.applyAsInt(11));

    }
}
