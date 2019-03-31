package q33;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印出能拼接出的所有数字中的最小的一个
 * <p>
 * 思路：相当于对数组进行一次排序，排序的原则是 m+n 大 还是 n+m 大；这里使用的是快排
 */
public class PrintMinNumber {

    public static void main(String[] args) {
        int[] array = {3, 1, 32};

//        int[] array = {3, 1, 2, 7, 55, 7, 32};

        printMin(array);
    }

    public static void printMin(int[] array) {
        if (array == null) {

            return;
        }
        quickSort(array, 0, array.length - 1);

        for (int i : array) {
            System.out.print(i);
        }
    }

    public static void quickSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = getMiddle(array, start, end);
            quickSort(array, start, middle - 1);
            quickSort(array, middle + 1, end);
        }
    }

    private static int getMiddle(int[] array, int start, int end) {
        int temp = array[start];
        while (start < end) {
            while (start < end && isSmallOrEqual(String.valueOf(temp), String.valueOf(array[end]))) {
                end--;
            }
            array[start] = array[end];

            while (start < end && isSmallOrEqual(String.valueOf(array[start]), String.valueOf(temp))) {
                start++;
            }
            array[end] = array[start];
        }

        array[start] = temp;

        return start;
    }

    public static boolean isSmallOrEqual(String m, String n) {
        String left = m + n;
        String right = n + m;

        boolean result = true;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) < right.charAt(i)) {

                return true;
            }
            if (left.charAt(i) > right.charAt(i)) {

                return false;
            }
        }

        return result;
    }

}
