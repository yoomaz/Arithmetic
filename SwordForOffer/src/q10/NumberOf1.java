package q10;

/**
 * 输入一个整数，输出该数二进制表示中的１的个数
 * 结论：把一个整数减去１再和原整数与，就会把整数二进制最右边一个１变成０
 * <p>
 * 1 : 001
 * 2 : 010
 * 3 : 011
 * 4 : 100
 */
public class NumberOf1 {

    public int numberOf1(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

}
