package q28;

/**
 * 输入一个字符串，打印出字符串中字符的所有排列
 * <p>
 * 思路：两两互换，换到最后一组的时候，第一个和最后一个互换，换完一整组后(即所有的都输出后)，会回归原始的字符串
 */
public class Permutation {

    public static void main(String args[]) {
        permutation("abcd");
    }

    public static void permutation(String str) {
        if (str == null) {

            return;
        }
        if (str.length() == 1) {
            System.out.println(str);
        }
        char[] output = str.toCharArray();
        int point = 0;
        System.out.println(output);
        // 第一次交换 0，1 两个位置
        char temp1 = output[point];
        output[point] = output[++point];
        output[point] = temp1;

        while (!String.valueOf(output).equals(str)) {
            System.out.println(output);

            if (point == output.length - 1) {
                char temp = output[point];
                output[point] = output[0];
                output[0] = temp;
                point = 0;
            } else {
                char temp = output[point];
                output[point] = output[++point];
                output[point] = temp;
            }
        }
    }

}
