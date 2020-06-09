package quickPowAndMod;

/**
 * @author huwei
 * @date 2020/6/8 21:05
 * @luogu https://www.luogu.com.cn/problem/P1226
 */
public class QuickPowAndMod {

    public static void main(String[] args) {
        for (int i = 1; i <= 150; i++) {
            long ans1 = binaryPowAndMod(3, i, 1000000007);
            long ans2 = bitPowAndMod(3, i, 1000000007);
            if( ans1 == ans2 )
                System.out.println(i + ": " + ans1);
            else
                System.out.println("One of the methods goes wrong!");
        }
    }

    /**
     * 计算 base^exp % mod
     * @param base - 底数
     * @param exp - 指数
     * @param mod - 求余
     * @return
     */
    public static long binaryPowAndMod(long base, long exp, long mod) {
        if( exp == 0 )
            return 1;
        //如果exp为奇数，则 base^exp = base * base^(exp-1)
        if( (exp & 1) == 1 )
            return base * binaryPowAndMod(base, exp - 1, mod) % mod;
        /**
         * 如果exp为偶数，则 base^exp = base^(exp/2) * base^(exp/2)
         * 不能直接写成return binaryPowAndMod(base, exp/2, mod) * binaryPowAndMod(base, exp/2, mod) % mod;
         * 因为这样写的话时间复杂度变为O(2^log(exp)) = O(exp)
         */
        long half = binaryPowAndMod(base, exp / 2, mod);
        return half * half % mod;
    }

    public static long bitPowAndMod(long base, long exp, long mod) {
        long ans = 1;
        while( exp > 0 ){
            if( (exp & 1) == 1 )
                ans = ans * base % mod;
            base = base * base % mod;
            exp >>= 1;
        }
        return ans;
    }
}
