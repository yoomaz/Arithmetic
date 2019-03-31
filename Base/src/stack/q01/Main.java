package stack.q01;

import java.util.Stack;

/**
 * 创建一个栈，使 getMin 的时间复杂度是 O(1)
 */
public class Main {

    public static void main(String[] args) {
        AdvanceStack advanceStack = new AdvanceStack();

        advanceStack.push(5);
        advanceStack.push(3);
        advanceStack.push(1);
        advanceStack.push(2);

        System.out.println(advanceStack.getMin());// 1
        advanceStack.pop();
        System.out.println(advanceStack.getMin());// 1
        advanceStack.pop();
        System.out.println(advanceStack.getMin());// 3
        advanceStack.pop();
        System.out.println(advanceStack.getMin());// 5
        advanceStack.pop();
        System.out.println(advanceStack.getMin());// null
    }


    static class AdvanceStack {

        private Stack<Integer> elementStack = new Stack<>();
        private Stack<Integer> minStack = new Stack<>();

        public Integer push(Integer item) {
            elementStack.push(item);

            if (minStack.empty()) {
                minStack.push(item);
            } else {
                if (item <= minStack.peek()) {
                    minStack.push(item);
                } else {
                    minStack.push(minStack.peek());
                }
            }
            return item;
        }

        public synchronized Integer pop() {
            minStack.pop();

            return elementStack.pop();
        }

        public synchronized Integer peek() {
            return elementStack.peek();
        }

        public boolean empty() {
            return elementStack.empty();
        }

        public Integer getMin() {
            if (minStack.empty()) {

                return null;
            }
            return minStack.peek();
        }
    }
}
