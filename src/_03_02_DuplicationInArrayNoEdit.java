/**
 * @author huwei
 * @date 2020/5/30 19:12
 */
public class _03_02_DuplicationInArrayNoEdit {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 4, 3, 2, 6, 7};
        System.out.println(getDuplication(nums));
    }

    public static int getDuplication(int[] nums) {
        if( nums == null || nums.length < 1 )
            return -1;
        int left = 1, right = nums.length - 1;
        while( left < right ){
            int mid = (left + right) / 2;
            if( countRange(nums, left, mid) > mid - left + 1 )
                right = mid;
            else
                left = mid + 1;
        }
        if( countRange(nums, left, right) > 1 )
            return left;
        else
            return -1;
    }

    public static int countRange(int[] nums, int left, int right) {
        int count = 0;
        for (int num : nums) {
            if( num >= left && num <= right )
                count++;
        }
        return count;
    }
}
