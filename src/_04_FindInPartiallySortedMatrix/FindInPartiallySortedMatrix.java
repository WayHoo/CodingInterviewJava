package _04_FindInPartiallySortedMatrix;

/**
 * @author huwei
 * @date 2020/5/30 22:38
 * @leecode https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
 */
public class FindInPartiallySortedMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray(matrix, 20));
    }

    /**
     * 始终用矩阵右上角的元素x与target进行比较
     * if(x == target): 查找成功
     * if(x > target): 删除x所在的列
     * if(x < target): 删除x所在的行
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        if( matrix == null || matrix.length < 1 || matrix[0].length < 1 )
            return false;
        int row = 0, col = matrix[0].length - 1;
        while( row < matrix.length && col >= 0 ) {
            if( matrix[row][col] == target )
                return true;
            if( matrix[row][col] > target )
                col--;
            else
                row++;
        }
        return false;
    }
}
