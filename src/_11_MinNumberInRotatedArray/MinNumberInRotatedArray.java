package _11_MinNumberInRotatedArray;

/**
 * @author huwei
 * @date 2020/6/5 17:09
 * @leetcode https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 */
public class MinNumberInRotatedArray {
    public static void main(String[] args) {
        int[] numbers = {2,2,2,2};
        System.out.println(minArray(numbers));
    }

    public static int minArray(int[] numbers) {
        if( numbers == null || numbers.length <= 0 )
            return 0;
        if( numbers.length == 1 )
            return numbers[0];
        int left = 0, right = numbers.length - 1;
        //当数组没有旋转时，直接返回第一个数
        if( numbers[left] < numbers[right] )
            return numbers[left];
        int ans = 0;
        while( left < right ){
            if( right - left == 1 ){
                ans = numbers[right];
                break;
            }
            int mid = (left + right) / 2;
            if( numbers[left] == numbers[mid] && numbers[mid] == numbers[right] ){
                ans = findMinInOrder(numbers);
                break;
            }
            if( numbers[left] <= numbers[mid] )
                left = mid;
            else
                right = mid;
        }
        return ans;
    }

    public static int findMinInOrder(int[] numbers) {
        int ans = numbers[0], pre = ans;
        for (int number : numbers) {
            if( number < pre ){
                ans = number;
                break;
            }
            pre = number;
        }
        return ans;
    }
}
