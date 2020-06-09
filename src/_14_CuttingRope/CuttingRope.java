package _14_CuttingRope;

/**
 * @author huwei
 * @date 2020/6/7 21:13
 * @leetcode https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 */
public class CuttingRope {

    public static void main(String[] args) {
        System.out.println(cuttingRope2(10));
    }

    /**
     * 动态规划解法
     */
    public static int cuttingRope1(int n) {
        //长度为n的绳子切割乘积最大为dp[n]
        int[] dp = new int[n+1];
        //i表示绳子的长度，自底向上求解dp[n]
        for (int i = 2; i <= n; i++) {
            int max = 0;
            //第一段绳子的切法有i-1种，即[1, i-1]。但只需计算[1, i/2]
            for (int j = 1; j <= i / 2; j++) {
                int cur = j * Math.max(i - j, dp[i-j]);
                max = cur > max ? cur : max;
            }
            dp[i] = max;
        }
        return dp[n];
    }

    /**
     * 数学解法
     */
    public static int cuttingRope2(int n) {
        if( n == 2 )
            return 1;
        if( n == 3 )
            return 2;
        //长为n的绳子最多可以切分为numOf3段长为3的绳子
        int numOf3 = n / 3;
        if( n - numOf3 * 3 == 1 )
            numOf3--;
        int numOf2 = (n - numOf3 * 3) / 2;
        return (int)Math.pow(3, numOf3) * (int)Math.pow(2, numOf2);
    }
}
