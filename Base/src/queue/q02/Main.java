package queue.q02;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 用两个队列实现一个栈
 *
 * 思路：q1 和 q2
 * 入栈:如果 q1 为空，入q1 ，否则入 q2
 * 出栈：把不为空的队列的 n-1 元素 放到空队列，然后删除最后一个元素，并返回它
 */
public class Main {

    public static void main(String[] args) {

    }

}
