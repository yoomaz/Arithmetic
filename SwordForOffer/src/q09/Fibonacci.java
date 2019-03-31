package q09;

/**
 * 求一个函数，输入n，求斐波那契数列的第Ｎ项
 * <p>
 * 1,1,2,3,5
 */
public class Fibonacci {

    public long fibonacci(int n) {

        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }


        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}
