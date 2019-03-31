package list.q09;

import base.DataUtils;
import base.ListNode;

/**
 * 把两个有序链表合并成一个有序链表
 * <p>
 * 使用递归的方式
 */
public class Main {

    public static void main(String[] args) {
        ListNode result = mergeList(DataUtils.getListNode(), DataUtils.getListNode());

        DataUtils.printListNode(result);
    }

    public static ListNode mergeList(ListNode head1, ListNode head2) {
        if (head1 == null) return null;
        if (head2 == null) return null;

        ListNode result;
        if (head1.getData() <= head2.getData()) {
            result = head1;
            result.setNext(mergeList(head1.getNext(), head2));
        } else {
            result = head2;
            result.setNext(mergeList(head1, head2.getNext()));
        }

        return result;
    }

}
