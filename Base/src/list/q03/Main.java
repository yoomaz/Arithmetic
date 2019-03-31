package list.q03;

import base.DataUtils;
import base.ListNode;

/**
 * 问题1：判定链表是否是一个环
 * 问题2：如果是一个环，环的起始点
 * 问题3：如果是一个环，求环的长度
 *
 * 问题1：
 * 1. 散列表法：一次遍历，地址为key，如果有节点已经在散列表里，则是一个环，时间复杂度是 O(n)
 * 2. Floyd 法，两个指针，一个移动快，一个移动慢，如果是环，一定会指向同一个节点。(例如龟兔赛跑，在环内，慢的一定会追上快的)
 *
 * 问题2：
 * 找到环以后，一个指针回到 head，然后同时两个指针每次移动一个位置，再次相遇的点事起始点
 *
 * 问题3：
 * 找到环以后，一个指针不动，然后同时另一个指针每次移动一个位置
 */
public class Main {

    public static void main(String[] args) {
//        System.out.println(doesLinkedNodeHasLoop(DataUtils.getListNode()));
//        System.out.println(doesLinkedNodeHasLoop(DataUtils.getCircleListNode()));

        ListNode node = findBeginLoopNode(DataUtils.getCircleListNode());
        if (node == null) {
            System.out.println("null");
        } else {
            System.out.println(node.getData());
        }

        System.out.println(getCircleCount(DataUtils.getCircleListNode()));
    }

    public static boolean doesLinkedNodeHasLoop(ListNode head) {
        ListNode pFast = head;
        ListNode pSlow = head;

        while (pFast.getNext() != null && pFast.getNext().getNext() != null) {
            pFast = pFast.getNext().getNext();
            pSlow = pSlow.getNext();

            if (pSlow == pFast) {
                return true;
            }
        }

        return false;
    }

    /**
     * 找到起始点
     */
    public static ListNode findBeginLoopNode(ListNode head) {
        ListNode pFast = head;
        ListNode pSlow = head;

        boolean hasLoop = false;
        while (pFast.getNext() != null && pFast.getNext().getNext() != null) {
            pFast = pFast.getNext().getNext();
            pSlow = pSlow.getNext();

            if (pSlow == pFast) {
                hasLoop = true;

                break;
            }
        }
        // 找到环以后，一个指针回到 head，然后同时两个指针每次移动一个位置，再次相遇的点事起始点
        if (hasLoop) {
            pSlow = head;
            while (pSlow != pFast) {
                pFast = pFast.getNext();
                pSlow = pSlow.getNext();
            }

            return pSlow;
        }

        return null;
    }

    /**
     * 环的长度
     */
    public static int getCircleCount(ListNode head) {
        ListNode pFast = head;
        ListNode pSlow = head;

        boolean hasLoop = false;
        while (pFast.getNext() != null && pFast.getNext().getNext() != null) {
            pFast = pFast.getNext().getNext();
            pSlow = pSlow.getNext();

            if (pSlow == pFast) {
                hasLoop = true;

                break;
            }
        }
        // 找到环以后，一个指针不动，然后同时另一个指针每次移动一个位置
        if (hasLoop) {
            int count = 1;
            pFast = pFast.getNext();
            while (pSlow != pFast) {
                pFast = pFast.getNext();
                count++;
            }

            return count;
        }

        return 0;
    }

}
