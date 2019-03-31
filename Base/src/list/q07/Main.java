package list.q07;

import base.DataUtils;
import base.ListNode;

/**
 * 从表尾开始输出链表
 *
 * 思路1：递归
 * 思路2：放到一个栈里，然后出栈输出
 */
public class Main {

    public static void main(String[] args) {
        printListFromEnd(DataUtils.getListNode());
    }

    public static void printListFromEnd(ListNode head) {
        if (head == null) {
            return;
        }
        printListFromEnd(head.getNext());
        System.out.println(head.getData());
    }
}
