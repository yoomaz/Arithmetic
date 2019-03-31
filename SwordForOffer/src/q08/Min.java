package q08;

/**
 * 输入递增排序数组的一个旋转，输出旋转数组的最小元素。
 * <p>
 * 思路：利用是递增数组旋转的特性，进行二分查找，判断中间位置是属于递增数组前半段，还是属于后半段
 * <p>
 * 注意：
 * 1. 当 start mid end 这三个位置都相同时候，需要进行简历依次比较
 * 2. 位置相差 1 的时候，后面那位就是最小的位置
 */
public class Min {

    public static void main(String[] args) {
        int[] array1 = {1, 1, 1, 2, 0};

        int[] array2 = {3, 4, 5, 1, 2};

//        System.out.println(minInReversingList2(array1));
//        System.out.println(minInReversingList2(array2));

        System.out.println(minInReversingList(array1));
        System.out.println(minInReversingList(array2));

    }

    public static int minInReversingList(int[] array) {
        if (array == null) {
            return -1;
        }
        int start = 0;
        int end = array.length - 1;
        int mid = 0;

        while (end > start) {
            if (end - start == 1) {
                mid = end;

                break;
            }
            mid = (start + end) / 2;
            // 无法判断类型，直接遍历求解
            if (array[start] == array[mid] && array[mid] == array[end]) {

                return minInReversingList2(array);
            }

            // tip: 这里要包含等于号，避免出现等于 start 的情况，又大于 end 的
            if (array[mid] >= array[start]) {
                start = mid;
            }
            if (array[mid] <= array[end]) {
                end = mid;
            }
        }

        return array[mid];
    }

    /**
     * 依次比较法
     */
    public static int minInReversingList2(int[] array) {
        if (array == null) {

            return -1;
        }
        int temp = array[0];
        for (int i = 0; i < array.length; i++) {
            if (temp > array[i]) {
                temp = array[i];
            }
        }

        return temp;
    }


}
