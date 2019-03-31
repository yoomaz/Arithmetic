package base;

public class DataUtils {

    /**
     * 获取一个正常链表
     */
    public static ListNode getListNode() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        return node1;
    }

    /**
     * 获取一个有环链表
     */
    public static ListNode getCircleListNode() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        node5.setNext(node3);

        return node1;
    }

    /**
     * 获取一个有环链表
     */
    public static ListNode[] getIntersectingNodeList() {
        ListNode node5 = new ListNode(5);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        ListNode node22 = new ListNode(22, node4);
        ListNode node11 = new ListNode(11, node22);


        return new ListNode[]{node1, node11};
    }

    /**
     * 获取一个二叉树
     *
     *         1
     *      2     3
     *    4  5   6
     */
    public static BinaryTreeNode getSimpleBinaryTree() {
        BinaryTreeNode node6 = new BinaryTreeNode(6);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node3 = new BinaryTreeNode(3, node6, null);
        BinaryTreeNode node2 = new BinaryTreeNode(2, node4, node5);
        BinaryTreeNode node1 = new BinaryTreeNode(1, node2, node3);

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

    public static void printListNode(ListNode head) {
        if (head == null) return;

        System.out.println(head.getData());
        printListNode(head.getNext());
    }
}
