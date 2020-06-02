package _10_Fibonacci;

/**
 * @author huwei
 * @date 2020/6/3 0:30
 */
public class Fibonacci {

    public static void main(String[] args) {
        System.out.println(fib(95));
    }

    public static int fib(int n) {
        if( n == 0 )
            return 0;
        if( n == 1 )
            return 1;
        //尽管 n <= 100，使用long存储真实fib值依然会溢出
        int last_1 = 1, last_2 = 0;
        for (int i = 2; i <= n; i++) {
            //为了避免溢出，此处直接求余，与对fib(n)求余等价
            int cur = (last_1 + last_2) % 1000000007;
            last_2 = last_1;
            last_1 = cur;
        }
        return last_1;
    }
}
