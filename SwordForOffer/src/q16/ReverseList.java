package q16;

import base.DataUtils;
import base.ListNode;

/**
 * 输入一个链表的头结点，翻转改链表并输出翻转后的头结点
 * <p>
 * 在 Base->list->q04
 * <p>
 * 思路1：定义一个中间变量，每次出来一个node，中间变量就把出来的这个加进去
 * 思路2：先依次出来，放到一个栈中，然后再出栈
 */
public class ReverseList {

    public static void main(String[] args) {
        System.out.println(reverseList(DataUtils.getList()).getData());

        // 输出逆转后的链表
        DataUtils.printList(reverseList(DataUtils.getList()));
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pTemp = null;
        ListNode pNext;

        while (head != null) {
            pNext = head.getNextNode();
            head.setNextNode(pTemp);

            pTemp = head;
            head = pNext;
        }

        return pTemp;
    }

}
