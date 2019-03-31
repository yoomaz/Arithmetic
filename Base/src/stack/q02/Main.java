package stack.q02;

import java.util.Queue;
import java.util.Stack;

/**
 * 如何实现用两个栈实现一个队列
 */
public class Main {

    public static void main(String[] args) {
        QueueWithTowStack queue = new QueueWithTowStack();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(4);
        queue.enQueue(3);
        queue.enQueue(4);

        while (!queue.isEmpty()) {
            System.out.println(queue.deQueue());
        }


    }

    static class QueueWithTowStack {

        private Stack<Integer> stack1 = new Stack<>();
        private Stack<Integer> stack2 = new Stack<>();

        public boolean isEmpty() {
            return stack1.empty() && stack2.isEmpty();
        }

        public Integer deQueue() {
            if (!stack2.empty()) {
                return stack2.pop();
            } else {
                if (!stack1.empty()) {
                    while (!stack1.empty()) {
                        stack2.push(stack1.pop());
                    }
                    return stack2.pop();
                }
            }

            return null;
        }

        public void enQueue(Integer value) {
            stack1.push(value);
        }
    }
}
