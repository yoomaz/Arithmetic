package list.q06;

import base.DataUtils;
import base.ListNode;

/**
 * 找到链表的中间节点
 *
 * 方法1：第一遍循环，计算总长度，然后第二遍循环取中间的长度
 * 方法2：第一遍循环，放到散列表中，并计算中长度，然后第二遍直接取中间的值
 * 方法3：一个快速指针每次移动两个位置，一个慢速指针每次移动一个位置，当快速指针到最后一个的时候，慢速指针指向的就是中间节点(高效!)
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(findMiddleNode(DataUtils.getListNode()));
    }

    public static ListNode findMiddleNode(ListNode head) {
        ListNode pFast = head;
        ListNode pSlow = head;

        boolean bothMove = false;
        while (pFast.getNext() != null) {
            if (bothMove) {
                pFast = pFast.getNext();
                pSlow = pSlow.getNext();

                bothMove = false;
            } else {
                pFast = pFast.getNext();

                bothMove = true;
            }
        }

        return pSlow;
    }
}
