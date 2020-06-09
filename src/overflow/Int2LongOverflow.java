package overflow;

/**
 * @author huwei
 * @date 2020/6/9 0:25
 */
public class Int2LongOverflow {
    public static void main(String[] args) {
        // Integer.MAX_VALUE = 2147483647
        int a = Integer.MAX_VALUE;
        int b1 = 1;
        long sum1 = a + b1;

        long sum2 = 2147483647 + 1;

        long b2 = 1;
        long sum3 = a + b2;

        long sum4 = 2147483647 + 1L;

        short b3 = 1;
        long sum5 = 2147483647L + b3;

        System.out.println("sum1 = " + sum1);
        System.out.println("sum2 = " + sum2);
        System.out.println("sum3 = " + sum3);
        System.out.println("sum4 = " + sum4);
        System.out.println("sum5 = " + sum5);
    }
}
