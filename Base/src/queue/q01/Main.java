package queue.q01;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 逆置一个队列
 *
 * 思路：队列依次出队，放到一个栈中，然后栈在入队列
 */
public class Main {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        reserveQueue(queue);
    }

    public static void reserveQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();
        while (!queue.isEmpty()) {
            stack.push(queue.poll());
        }
        while (!stack.empty()) {
            queue.offer(stack.pop());
        }

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}
