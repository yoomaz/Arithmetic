package q42;

/**
 * 问题1：输入一个递增排序的数组和一个数字s.在数组中查找两个数使他们的和为s，如果有多对数字的和等于s，输出一对即可
 * <p>
 * 问题2：输入一个整数s，打印出所有和为s的连续正数序列（至少含有两个数）
 * <p>
 * 思路：(要有一个窗口的概念 start-end)保证总体是一个递增的序列，定义 一个起点 和 一个终点，一个加，一个减，只要找到合适的
 */
public class ReverseSentence {

    public static void main(String[] args) {
        // 测试问题 1
        int[] array = {1, 2, 4, 7, 11, 15};
//        findNumbersWithSum(array, 9);


        // 测试问题 2
        findContinuousSequence(3);
        findContinuousSequence(11);
        findContinuousSequence(18);


    }

    /**
     * 问题 1
     */
    public static void findNumbersWithSum(int[] sortedArray, int number) {
        if (sortedArray == null || sortedArray.length < 2) {

            return;
        }
        int start = 0;
        int end = sortedArray.length - 1;
        while (end > start) {
            int sum = sortedArray[start] + sortedArray[end];

            if (sum == number) {
                System.out.println("start:" + sortedArray[start]);
                System.out.println("end:" + sortedArray[end]);

                break;
            } else {
                if (sum > number) {
                    end--;
                } else {
                    start++;
                }
            }
        }
    }

    /**
     * 问题 2
     */
    public static void findContinuousSequence(int s) {
        if (s < 3) {

            return;
        }
        int small = 1;
        int big = 2;
        while (small < (s + 1) / 2) {
            int sum = 0;
            for (int i = small; i <= big; i++) {
                sum += i;
            }
            if (sum == s) {
                // 输出结果
                for (int i = small; i <= big; i++) {
                    System.out.println(i);
                }

                System.out.println("----");

                small++;
            } else {
                if (sum > s) {
                    small++;
                } else {
                    big++;
                }
            }
        }
    }

}
