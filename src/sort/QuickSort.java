package sort;

import java.util.Random;

/**
 * @author huwei
 * @date 2020/6/3 23:37
 */
public class QuickSort<T extends Comparable> {
    /**
     * 封装统一接口
     */
    public void quickSort(T[] arrays) {
        if( arrays == null || arrays.length <= 1 )
            return;
        qsort(arrays, 0,  arrays.length - 1);
    }

    private void qsort(T[] arrays, int left, int right) {
        if( left >= right )
            return;
        // 获取基准
        T pivot = find_mid(arrays, left, right);
        int low = left, high = right - 1;
        // 退出while循环的唯一条件为 low == high
        while (true){
            /**
             * 遇到等于基准的数，需要停下来交换，虽然这样会有多余的操作，但这样是值得的
             * 考虑这种情况，数组中的所有值均相等。如果不交换，那么分治策略将失效
             */
            while ( low < high && arrays[++low].compareTo(pivot) < 0 );
            while ( low < high && arrays[--high].compareTo(pivot) > 0 );
            if( low < high )
                swap(arrays, low, high);
            else break;
        }
        // 将基准换到正确的位置
        swap(arrays, right-1, low);
        // 递归解决左边
        qsort(arrays, left, low - 1);
        // 递归解决右边
        qsort(arrays, low + 1, right);
    }

    /**
     * 寻找arrays数组中left, mid, right下标对应的三个值中的中间值（基准）
     */
    private T find_mid(T[] arrays, int left, int right) {
        int mid = (left + right) / 2;
        if( arrays[left].compareTo(arrays[mid]) > 0 )
            swap(arrays, left, mid);
        if( arrays[left].compareTo(arrays[right]) > 0 )
            swap(arrays, left, right);
        if( arrays[mid].compareTo(arrays[right]) > 0 )
            swap(arrays, mid, right);
        /* 此时arrays[left] <= arrays[mid] <= arrays[right] */
        // 将基准放到arrays[right-1]，因为arrays[right]一定不小于基准，不用参与后续比较过程
        swap(arrays, mid, right - 1);
        // 返回基准
        return arrays[right-1];
    }

    private void swap(T[] arrays, int index1, int index2) {
        T tmp = arrays[index1];
        arrays[index1] = arrays[index2];
        arrays[index2] = tmp;
    }
}

class Test{
    public static void main(String[] args) {
        Integer[] arrays = new Integer[10];
        Random random = new Random();
        System.out.println("排序前数组：");
        for (int i = 0; i < arrays.length; i++) {
            arrays[i] = random.nextInt(100);
            System.out.print(arrays[i] + "\t");
        }
        System.out.println();
        QuickSort<Integer> obj = new QuickSort<>();
        obj.quickSort(arrays);
        System.out.println("排序后数组：");
        int pre = arrays[0];
        boolean successable = true;
        for (Integer array : arrays) {
            System.out.print(array + "\t");
            if( array < pre )
                successable = false;
            pre = array;
        }
        System.out.println("\n排序结果是否正确：" + successable);
    }
}
