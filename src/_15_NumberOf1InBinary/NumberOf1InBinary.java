package _15_NumberOf1InBinary;

/**
 * @author huwei
 * @date 2020/6/9 11:08
 * @leetcode https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 */
public class NumberOf1InBinary {

    public static void main(String[] args) {
        int n = Integer.MIN_VALUE;
        System.out.println(hammingWeight1(n));
        System.out.println(hammingWeight2(n));
    }

    // you need to treat n as an unsigned value
    public static int hammingWeight1(int n) {
        int count = 0;
        while( n != 0 ){
            if( (n & 1) == 1 )
                count++;
            //>>>表示无符号右移
            n >>>= 1;
        }
        return count;
    }

    /**
     * 把一个整数（原码或补码均可）减去1之后再和原来的整数做位与运算，
     * 得到的结果相当于把整数的二进制表示中最右边的1变成0。
     *
     * 操作次数为n的二进制表示中1的个数，时间复杂度优于hammingWeight1
     * @param n - treat it as unsigned integer
     */
    public static int hammingWeight2(int n) {
        int count = 0;
        while( n != 0 ){
            n = (n - 1) & n;
            count++;
        }
        return count;
    }
}
