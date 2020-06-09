package _16_Power;

/**
 * @author huwei
 * @date 2020/6/9 14:16
 * @leetcode https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 */
public class Power {

    public static void main(String[] args) {
        System.out.println(myPow(1.00000, -2147483648));
    }

    public static double myPow(double x, int n) {
        if( Math.abs(x) < 10e-9 && n <= 0 )
            throw new IllegalArgumentException();
        boolean isNegative = n < 0;
        //使用long类型存储|n|，是为了避免n == Integer.MIN_VALUE时发生溢出
        long exp = Math.abs((long)n);
        double ans = 1;
        while( exp != 0 ){
            if( (exp & 1) == 1 )
                ans *= x;
            x *= x;
            exp >>= 1;
        }
        return isNegative ? (1 / ans) : ans;
    }
}
