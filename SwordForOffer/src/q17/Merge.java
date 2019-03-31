package q17;

import base.DataUtils;
import base.ListNode;

/**
 * 输入两个递增的链表，合并这两个链表并使新链表仍然是递增的
 * <p>
 * 在 Base->list->q09
 * <p>
 * 思路：递归法：两个节点进行不断进行比较，小的节点取出 next节点继续和另一个比较
 */
public class Merge {

    public static void main(String[] args) {

        ListNode pMerge = merge(DataUtils.getAddList1(), DataUtils.getAddList2());

        DataUtils.printList(pMerge);
    }

    public static ListNode merge(ListNode root1, ListNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        ListNode pHead;
        if (root1.getData() < root2.getData()) {
            pHead = root1;
            pHead.setNextNode(merge(pHead.getNextNode(), root2));
        } else {
            pHead = root2;
            pHead.setNextNode(merge(pHead.getNextNode(), root1));
        }

        return pHead;
    }
}
