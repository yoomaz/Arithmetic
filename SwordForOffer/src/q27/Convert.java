package q27;

import base.BinaryTreeNode;

/**
 * 将二叉搜索树转换成一个排序的双向链表
 * <p>
 * 思路：中根排序(目前解法有问题)
 */
public class Convert {

    public static void main(String args[]) {
        test01();
    }

    public static BinaryTreeNode convert(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        BinaryTreeNode node = new BinaryTreeNode();
        convert(root, node);
        while (node != null && node.getLeftNode() != null) {
            node = node.getLeftNode();
        }

        return node;
    }

    public static void convert(BinaryTreeNode root, BinaryTreeNode lastNode) {
        if (root != null) {
            BinaryTreeNode current = root;
            if (current.getLeftNode() != null) {
                convert(current.getLeftNode(), lastNode);
            }
            current.setLeftNode(lastNode);
            if (lastNode != null) {
                lastNode.setRightNode(current);
            }

            lastNode = current;

            if (current.getRightNode() != null) {
                convert(current.getRightNode(), lastNode);
            }
            current.setLeftNode(lastNode);
            if (lastNode != null) {
                lastNode.setRightNode(current);
            }
        }
    }

    private static void printList(BinaryTreeNode head) {
        while (head != null) {
            System.out.print(head.data + "->");
            head = head.rightNode;
        }
        System.out.println("null");
    }

    private static void printTree(BinaryTreeNode root) {
        if (root != null) {
            printTree(root.leftNode);
            System.out.print(root.data + "->");
            printTree(root.rightNode);
        }
    }

    //            10
    //         /      \
    //        6        14
    //       /\        /\
    //      4  8     12  16
    private static void test01() {
        BinaryTreeNode node10 = new BinaryTreeNode();
        node10.data = 10;
        BinaryTreeNode node6 = new BinaryTreeNode();
        node6.data = 6;
        BinaryTreeNode node14 = new BinaryTreeNode();
        node14.data = 14;
        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.data = 4;
        BinaryTreeNode node8 = new BinaryTreeNode();
        node8.data = 8;
        BinaryTreeNode node12 = new BinaryTreeNode();
        node12.data = 12;
        BinaryTreeNode node16 = new BinaryTreeNode();
        node16.data = 16;
        node10.leftNode = node6;
        node10.rightNode = node14;
        node6.leftNode = node4;
        node6.rightNode = node8;
        node14.leftNode = node12;
        node14.rightNode = node16;
        System.out.print("Before convert: ");
        printTree(node10);
        System.out.println("null");
        BinaryTreeNode head = convert(node10);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    //               5
    //              /
    //             4
    //            /
    //           3
    //          /
    //         2
    //        /
    //       1
    private static void test02() {
        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.data = 1;
        BinaryTreeNode node2 = new BinaryTreeNode();
        node2.data = 2;
        BinaryTreeNode node3 = new BinaryTreeNode();
        node3.data = 3;
        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.data = 4;
        BinaryTreeNode node5 = new BinaryTreeNode();
        node5.data = 5;
        node5.leftNode = node4;
        node4.leftNode = node3;
        node3.leftNode = node2;
        node2.leftNode = node1;
        System.out.print("Before convert: ");
        printTree(node5);
        System.out.println("null");
        BinaryTreeNode head = convert(node5);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 1
    //  \
    //   2
    //    \
    //     3
    //      \
    //       4
    //        \
    //         5
    private static void test03() {
        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.data = 1;
        BinaryTreeNode node2 = new BinaryTreeNode();
        node2.data = 2;
        BinaryTreeNode node3 = new BinaryTreeNode();
        node3.data = 3;
        BinaryTreeNode node4 = new BinaryTreeNode();
        node4.data = 4;
        BinaryTreeNode node5 = new BinaryTreeNode();
        node5.data = 5;
        node1.rightNode = node2;
        node2.rightNode = node3;
        node3.rightNode = node4;
        node4.rightNode = node5;
        System.out.print("Before convert: ");
        printTree(node1);
        System.out.println("null");
        BinaryTreeNode head = convert(node1);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

    // 只有一个结点
    private static void test04() {
        BinaryTreeNode node1 = new BinaryTreeNode();
        node1.data = 1;
        System.out.print("Before convert: ");
        printTree(node1);
        System.out.println("null");
        BinaryTreeNode head = convert(node1);
        System.out.print("After convert : ");
        printList(head);
        System.out.println();
    }

}
