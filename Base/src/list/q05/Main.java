package list.q05;

import base.DataUtils;
import base.ListNode;

/**
 * 找出两个链表交叉的节点(拉链的节点)
 *
 * 思路：
 * 解法一：长的链表先移动相差的距离，然后两个链表一起移动，找出交叉点
 * 解法二：把两个链表压入两个栈，然后一起出栈，直到出栈的元素不一样，此时前一个元素就是相同点
 */
public class Main {

    public static void main(String[] args) {
        ListNode[] nodes = DataUtils.getIntersectingNodeList();

        System.out.println(findIntersectingNode(nodes[0], nodes[1]));
    }

    public static ListNode findIntersectingNode(ListNode listNode1, ListNode listNode2) {
        // 1. 先计算出出长度
        int nodeLength1 = 0, nodeLength2 = 0;
        ListNode longNode = listNode1;
        ListNode shortNode = listNode2;
        while (longNode != null) {
            nodeLength1++;
            longNode = longNode.getNext();
        }
        while (shortNode != null) {
            nodeLength2++;
            shortNode = shortNode.getNext();
        }

        // 算出差值
        int diff;
        if (nodeLength1 > nodeLength2) {
            diff = nodeLength1 - nodeLength2;
            longNode = listNode1;
            shortNode = listNode2;

        } else {
            diff = nodeLength2 - nodeLength1;
            longNode = listNode2;
            shortNode = listNode1;
        }
        // 让长的链表先移动差值的距离
        for (int i = 0; i < diff; i++) {
            longNode = longNode.getNext();
        }
        // 共同移动
        while (longNode != null && shortNode != null) {
            if (longNode == shortNode) {
                return longNode;
            }
            longNode = longNode.getNext();
            shortNode = shortNode.getNext();
        }

        return null;
    }
}
