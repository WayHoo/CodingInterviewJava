package _03_01_DuplicationInArray;

/**
 * @author huwei
 * @date 2020/5/30 16:05
 */
public class DuplicationInArray {

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
//        int[] nums = {2, 3, 1, 0, 4, 5, 6};
        System.out.println(findRepeatNumber2(nums));
    }

    /**
     * 时间复杂度O(n)，空间复杂度O(n)
     * 由于原始数组中数据范围为0~(n-1)，因此可以使用哈希算法。
     * 开辟一个与原始数组同样大小的数组，依次记录原始数组中每个值出现的次数
     * 如果发现某个值出现次数大于1，直接返回该值
     */
    public static int findRepeatNumber1(int[] nums) {
        if( nums == null || nums.length < 1 )
            return -1;
        int[] tmp_nums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if( nums[i] < 0 || nums[i] >= nums.length )
                return -1;
            tmp_nums[nums[i]]++;
            if( tmp_nums[nums[i]] > 1 )
                return nums[i];
        }
        return -1;
    }

    /**
     * 时间复杂度O(n)，空间复杂度O(1)
     */
    public static int findRepeatNumber2(int[] nums) {
        if( nums == null || nums.length < 1 )
            return -1;
        for (int i = 0; i < nums.length; i++) {
            if( nums[i] < 0 || nums[i] >= nums.length )
                return -1;
            if( nums[i] == i )
                continue;
            if( nums[i] == nums[nums[i]] )
                return nums[i];
            else{
                int tmp = nums[i];
                nums[i] = nums[tmp];
                nums[tmp] = tmp;
                i--;
            }
        }
        return -1;
    }
}
