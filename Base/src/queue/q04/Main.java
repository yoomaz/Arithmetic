package queue.q04;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 给定一个整数队列，可一个值 k，让队列前 k 个元素逆转，其他元素不变
 *
 * 思路：
 * 1. 先把前 k 个元素放到栈中
 * 2. 再把栈中的元素放到队列后面
 * 3. 把对象前面的剩余元素放到队列的后面
 */
public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        reverseQueueFirstKElements(queue, 3);
    }

    public static void reverseQueueFirstKElements(Queue<Integer> queue, int k) {
        if (queue.size() < k) {

            return;
        }
        // 先把前 k 个元素放到栈中
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < k; i++) {
            stack.push(queue.poll());
        }
        // 再把栈中的元素放到队列后面
        while (!stack.empty()) {
            queue.add(stack.pop());
        }

        // 把对象前面的剩余元素放到队列的后面
        for (int i = 0; i < (queue.size() - k); i++) {
            queue.add(queue.poll());
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }

}
