package _13_RobotMove;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author huwei
 * @date 2020/6/7 15:14
 * @leetcode https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class RobotMove {

    public static void main(String[] args) {
        System.out.println(movingCount(3, 1, 0));
    }

    public static int movingCount(int m, int n, int k) {
        int count = 1;
        boolean[][] isVisited = new boolean[m][n];
        int[][] indexBitSum = new int[m][n];
        // 只需向右和向下搜索即可
        int[][] step = {{0, 1}, {1, 0}};
        Queue<Index> queue = new LinkedList<>();
        queue.add(new Index(0, 0));
        isVisited[0][0] = true;
        while( !queue.isEmpty() ) {
            Index index = queue.poll();
            for (int i = 0; i < step.length; i++) {
                int tmp_i = index.i + step[i][0];
                int tmp_j = index.j + step[i][1];
                if( tmp_i >= 0 && tmp_i < m && tmp_j >= 0 && tmp_j < n &&
                        !isVisited[tmp_i][tmp_j] ) {
                    if( indexBitSum[tmp_i][tmp_j] == 0 )
                        indexBitSum[tmp_i][tmp_j] = calcIndexBitSum(tmp_i, tmp_j);
                    if( indexBitSum[tmp_i][tmp_j] <= k ){
                        queue.add(new Index(tmp_i, tmp_j));
                        isVisited[tmp_i][tmp_j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static int calcIndexBitSum(int i, int j) {
        String str = Integer.toString(i) + Integer.toString(j);
        int sum = 0;
        for (int k = 0; k < str.length(); k++)
            sum += str.charAt(k) - '0';
        return sum;
    }
}

class Index {
    int i, j;
    public Index( int i, int j) {
        this.i = i;
        this.j = j;
    }
}