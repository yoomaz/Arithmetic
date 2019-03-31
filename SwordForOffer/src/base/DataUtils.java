package base;

import java.util.ArrayDeque;
import java.util.Queue;

public class DataUtils {


    public static ListNode getList() {
        ListNode node4 = new ListNode(4, null);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        return node1;
    }

    public static ListNode getAddList1() {
        ListNode node4 = new ListNode(7, null);
        ListNode node3 = new ListNode(5, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(1, node2);

        return node1;
    }

    public static ListNode getAddList2() {
        ListNode node4 = new ListNode(8, null);
        ListNode node3 = new ListNode(6, node4);
        ListNode node2 = new ListNode(4, null);
        ListNode node1 = new ListNode(2, node2);

        return node1;
    }

    /**
     * 获取一个二叉树
     *
     *         1
     *      2     3
     *       5   6
     */
    public static BinaryTreeNode getSimpleBinaryTree2() {
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, null, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

        return node1;
    }

    /**
     * 获取一个二叉树, 是 tree2 的子树
     *
     *
     *      2
     *       5
     */
    public static BinaryTreeNode getSimpleBinaryTree3() {
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node2 = new BinaryTreeNode(2, null, node5);

        return node2;
    }

    /**
     * 层次遍历
     * <p>
     * 借助队列
     */
    public static void levelOrder(BinaryTreeNode treeNode) {
        if (treeNode == null) {

            return;
        }
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if (node.getLeftNode() != null) {
                queue.add(node.getLeftNode());
            }
            if (node.getRightNode() != null) {
                queue.add(node.getRightNode());
            }
            System.out.print(node.getData());
        }
    }

    /**
     * 获取一个有环链表
     */
    public static ListNode[] getIntersectingNodeList() {
        // 1-2-3-4-5
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        // 11-12-4-5
        ListNode node22 = new ListNode(22, node4);
        ListNode node11 = new ListNode(11, node22);


        return new ListNode[]{node1, node11};
    }


    public static void printList(ListNode head) {
        while (head != null) {
            System.out.println(head.getData());

            head = head.getNextNode();
        }
    }
}
