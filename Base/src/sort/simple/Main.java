package sort.simple;

/**
 *
 */
public class Main {

    public static void main(String[] args) {
        int[] data = new int[]{6, 8, 1, 4, 5, 3, 2, 7};
        int n = data.length;

//        System.out.println("冒泡排序：");
//        bubbleSort(data, n);

        System.out.println();
        System.out.println("快速排序：");
        quick(data);

//        System.out.println();
//        System.out.println("选择排序：");
//        selectionSort(data, n);
//
//        System.out.println();
//        System.out.println("插入排序：");
//        insertSort(data, n);


    }

    /**
     * 冒泡排序
     * <p>
     * O(n的平方)
     * <p>
     * 从前到后，两两比较，如果大于，就交换
     */
    private static void bubbleSort(int[] data, int n) {
        for (int end = n - 1; end >= 0; end--) {
            for (int i = 0; i <= end - 1; i++) {
                if (data[i] > data[i + 1]) {
                    int temp = data[i];
                    data[i] = data[i + 1];
                    data[i + 1] = temp;
                }
            }
        }

        printArray(data);

    }

    /**
     * 快速排序
     * <p>
     * 把整个序列看做一个数组，把第零个位置看做中轴，和最后一个比，如果比它小交换，比它大不做任何处理；交换了以后再和小的那端比，比它小不交换，比他大交换。这样循环往复，一趟排序完成，左边就是比中轴小的，右边就是比中轴大的，然后再用分治法，分别对这两个独立的数组进行排序。
     * <p>
     * * 最好：O(nLogN)
     * * 最差：O(n*n)
     *
     * @param numbers 带排序数组
     *
     *
     *  6, 8, 1, 4, 5, 3, 2, 7: 6
     *  2, 8, 1, 4, 5, 3, 6, 7: 6
     *  2, 6, 1, 4, 5, 3, 8, 7: 6
     *  2, 3, 1, 4, 5, 6, 8, 7: 6
     */
    public static void quick(int[] numbers) {
        if (numbers.length > 0)   //查看数组是否为空
        {
            quickSort(numbers, 0, numbers.length - 1);

            printArray(numbers);
        }
    }

    /**
     * @param numbers 带排序数组
     * @param low     开始位置
     * @param high    结束位置
     */
    public static void quickSort(int[] numbers, int low, int high) {
        if (low < high) {
            int middle = getMiddle(numbers, low, high);
            quickSort(numbers, low, middle - 1);
            quickSort(numbers, middle + 1, high);
        }
    }

    public static int getMiddle(int[] numbers, int low, int high) {
        int temp = numbers[low];
        while (low < high) {
            while (low < high && numbers[high] >= temp) {
                high--;
            }
            numbers[low] = numbers[high];
            while (low < high && numbers[low] <= temp) {
                low++;
            }
            numbers[high] = numbers[low];
        }
        numbers[low] = temp;

        return low;
    }

    /**
     * 选择排序
     * <p>
     * O(n的平方)
     * <p>
     * 选择第一个，依次和后面的进行比较，选出最小的一个元素放到第一位；依次这样循环下去
     */
    private static void selectionSort(int[] data, int n) {
        for (int i = 0; i < n - 1; i++) {
            int min = data[i];
            for (int j = i + 1; j < n; j++) {
                if (data[j] < min) {
                    min = data[j];
                }
            }
            if (data[i] != min) {
                data[i] = min;
            }
        }

        printArray(data);
    }

    /**
     * 插入排序
     * <p>
     * O(n的平方)
     * <p>
     * 6, 8, 1, 4, 5, 3, 2, 7
     * <p>
     * 假设前面半段都是有序的，后面的元素依次和前面的元素比，如果小就互换，相当于插入到前半段已经排序的数组中
     */
    private static void insertSort(int[] data, int n) {
        for (int i = 2; i <= n - 1; i++) {
            int temp = data[i];
            int j = i;
            while (temp < data[j - 1] && j >= 1) {
                data[j] = data[j - 1];
                j--;
            }
            data[j] = temp;
        }

        printArray(data);
    }


    public static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + ",");
        }
    }
}
