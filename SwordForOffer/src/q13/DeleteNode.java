package q13;

import base.DataUtils;
import base.ListNode;

/**
 * 给定单向链表的头指针和一个节点，定义一个函数在O(1)时间删除该节点
 * <p>
 * 1. 如果被删除的节点是最后一个，那个就把最后一个节点删掉
 * 2. 如果是中间的，就把 删掉节点元素 换成 删除节点下一个节点 的元素，然后删掉 删除节点的下一个节点
 */
public class DeleteNode {

    public static void main(String[] args) {
        ListNode head = DataUtils.getList();
        deleteNode(head, head.getNextNode().getNextNode());

        DataUtils.printList(head);
    }

    public static ListNode deleteNode(ListNode head, ListNode deListNode) {
        if (head == null || deListNode == null) {

            return null;
        }
        if (head == deListNode) {

            return null;
        }
        // 到了这里说明至少有两个节点
        if (deListNode.getNextNode() == null) {
            ListNode temp = head;
            while (temp.getNextNode().getNextNode() != null) {
                temp = temp.getNextNode();
            }
            temp.setNextNode(null);
        } else {
            deListNode.setData(deListNode.getNextNode().getData());
            deListNode.setNextNode(deListNode.getNextNode().getNextNode());
        }

        return head;
    }
}
