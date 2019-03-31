package q45;

import java.util.ArrayList;
import java.util.List;

/**
 * 0,1...n-1这Ｎ个数字排成一个圆圈，从从数字０开始每次从这个圆圈里删除第Ｍ个数字, 求这个圈圈里剩下的最后一个数字
 * <p>
 * 思路：利用取模，找到真正要删除的位置
 */
public class LastRemaining {

    public static void main(String[] args) {

        //  位置 3:   0,1,2,3,4  : 3 ,2 （取模位置，真正删除位置）
        // -> 0,1,2,4 : 3, 2
        // -> 0,1,2 : 0, 2
        // -> 0,1 -> 1, 0
        // -> 1
        System.out.println(lastRemaining(5, 3));


    }

    public static int lastRemaining(int count, int m) {
        if (count < 2) {

            return -1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add(i);
        }

        while (list.size() > 1) {
            int delPosition;
            int position = m % list.size();
            if (position == 0) {
                delPosition = list.size() - 1;
            } else {
                delPosition = position - 1;
            }

            list.remove(delPosition);
        }

        return list.get(0);
    }

}
