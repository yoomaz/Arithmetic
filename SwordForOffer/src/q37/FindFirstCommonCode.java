package q37;

import base.DataUtils;
import base.ListNode;

import java.util.LinkedHashMap;
import java.util.Stack;

/**
 * 求两个单向链表的第一个公共节点
 * <p>
 * base->list-q05
 * <p>
 * 思路：
 * 解法一：长的链表先移动相差的距离，然后两个链表一起移动，找出交叉点
 * 解法二：把两个链表压入两个栈，然后一起出栈，直到出栈的元素不一样，此时前一个元素就是相同点
 */
public class FindFirstCommonCode {

    public static void main(String[] args) {
        ListNode[] nodes = DataUtils.getIntersectingNodeList();

        System.out.println(findIntersectingNode(nodes[0], nodes[1]).getData());
    }

    /**
     * 解法2
     */
    public static ListNode findIntersectingNode(ListNode listNode1, ListNode listNode2) {
        if (listNode1 == null || listNode2 == null) {

            return null;
        }
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (listNode1 != null) {
            stack1.push(listNode1);
            listNode1 = listNode1.getNextNode();
        }
        while (listNode2 != null) {
            stack2.push(listNode2);
            listNode2 = listNode2.getNextNode();
        }

        ListNode list1NodePop = stack1.pop();
        ListNode list2NodePop = stack2.pop();

        while (!stack1.empty()) {
            if (list1NodePop == list2NodePop && stack1.peek() != stack2.peek()) {
                return list1NodePop;
            }

            list1NodePop = stack1.pop();
            list2NodePop = stack2.pop();
        }

        return null;
    }

}
