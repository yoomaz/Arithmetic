package list.q04;

import base.DataUtils;
import base.ListNode;

/**
 * 逆转一个链表
 *
 * 1. 定义一个中间变量，每次出来一个node，中间变量就把出来的这个加进去
 * 2. 先依次出来，放到一个栈中，然后再出栈
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(reverseList(DataUtils.getListNode()).getData());
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pTemp = null;
        ListNode pNext = null;

        while (head != null) {
            pNext = head.getNext();
            head.setNext(pTemp);

            pTemp = head;
            head = pNext;
        }

        return pTemp;
    }
}
