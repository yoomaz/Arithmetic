package q14;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整数组中的数字的顺序，使得所有奇数位于数组的前半部分，偶数位于后半部分
 * <p>
 * 思路1：遍历一次数组，把奇数放到一个集合，把偶数放到一个集合，然后在原数组再依次赋值
 * <p>
 * 思路2：从 0 开始记录一个下标，遍历一次数组，如果是奇数就与前面的下标元素替换，然后下标+1 ;  这种方式还能顺便得出有多少个奇数
 */
public class Reorder {

    public static void main(String[] args) {

        int[] array = new int[]{5, 4, 2, 3, 1, 6, 7, 8};

//        order01(array);

        order02(array);

        for (int i : array) {
            System.out.println(i);
        }

    }

    public static void order02(int[] array) {
        if (array == null) {

            return;
        }
        // 要被替换的元素位置
        int index = 0;
        // 从 0 开始是因为不用去校验 array 长度是 1 的情况
        for (int i = 0; i < array.length; i++) {
            if (!isEven(array[i])) {
                int temp = array[i];
                array[i] = array[index];
                array[index] = temp;

                index++;
            }
        }
    }

    public static void order01(int[] array) {
        if (array == null) {

            return;
        }
        List<Integer> evenList = new ArrayList<>();
        List<Integer> oddListList = new ArrayList<>();

        for (int i : array) {
            if (isEven(i)) {
                evenList.add(i);
            } else {
                oddListList.add(i);
            }
        }
        int index = 0;
        for (int oddNum : oddListList) {
            array[index] = oddNum;
            index++;
        }
        for (int evenNum : evenList) {
            array[index] = evenNum;
            index++;
        }
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }
}
