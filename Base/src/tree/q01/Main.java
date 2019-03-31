package tree.q01;

import base.BinaryTreeNode;
import base.DataUtils;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * 二叉树遍历
 */
public class Main {

    public static void main(String[] args) {

        System.out.print("先根递归:");
        preOrder(DataUtils.getSimpleBinaryTree());
        System.out.println();

        System.out.print("先根非递归:");
        preOrderNonReverse(DataUtils.getSimpleBinaryTree());
        System.out.println();

        System.out.print("中根递归:");
        inOrder(DataUtils.getSimpleBinaryTree());
        System.out.println();

        System.out.print("中根非递归:");
        inOrderNonReverse(DataUtils.getSimpleBinaryTree());
        System.out.println();

        System.out.print("后根递归:");
        postOrder(DataUtils.getSimpleBinaryTree());
        System.out.println();

        System.out.print("后根非递归:");
        postOrderNonReverse(DataUtils.getSimpleBinaryTree());
        System.out.println();

        System.out.print("后根递归2:");
        postOrder(DataUtils.getSimpleBinaryTree2());
        System.out.println();

        System.out.print("后根非递归2:");
        postOrderNonReverse(DataUtils.getSimpleBinaryTree2());
        System.out.println();

        System.out.print("层次遍历:");
        levelOrder(DataUtils.getSimpleBinaryTree());
        System.out.println();

        System.out.print("层次遍历,逆向:");
        levelOrderReserve(DataUtils.getSimpleBinaryTree());
        System.out.println();





    }

    public static void preOrder(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            System.out.print(treeNode.getData());
            preOrder(treeNode.getLeft());
            preOrder(treeNode.getRight());
        }
    }

    public static void preOrderNonReverse(BinaryTreeNode treeNode) {
        if (treeNode == null) {

            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (treeNode != null) {
                System.out.print(treeNode.getData());
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            }
            if (stack.empty()) {
                break;
            }
            treeNode = stack.pop();
            treeNode = treeNode.getRight();
        }
    }

    public static void inOrder(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            inOrder(treeNode.getLeft());
            System.out.print(treeNode.getData());
            inOrder(treeNode.getRight());
        }
    }

    public static void inOrderNonReverse(BinaryTreeNode treeNode) {
        if (treeNode == null) {

            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            }

            if (stack.empty()) {
                break;
            }

            treeNode = stack.pop();
            System.out.print(treeNode.getData());
            treeNode = treeNode.getRight();
        }
    }

    public static void postOrder(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            postOrder(treeNode.getLeft());
            postOrder(treeNode.getRight());
            System.out.print(treeNode.getData());
        }
    }

    public static void postOrderNonReverse(BinaryTreeNode treeNode) {
        if (treeNode == null) {

            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        while (true) {
            if (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.getLeft();
            } else {
                if (stack.empty()) {

                    break;
                }

                if (stack.peek().getRight() == null) {
                    treeNode = stack.pop();
                    System.out.print(treeNode.getData());

                    if (stack.peek().getRight() == treeNode) {
                        // 说明已经完成了节点右边的遍历
                        System.out.print(stack.pop().getData());

                        // 当前节点已经打印完，转移到节点的右边节点
                        if (!stack.empty()) {
                            treeNode = stack.peek().getRight();
                        } else {
                            treeNode = null;
                        }
                    } else {
                        treeNode = stack.peek().getRight();
                    }
                } else {
                    treeNode = stack.peek().getRight();
                }
            }
        }
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
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
            System.out.print(node.getData());
        }
    }

    /**
     * 层次遍历，从下到上，从最底层，逐层输出树节点
     *
     * <p>
     * 借助队列和栈
     */
    public static void levelOrderReserve(BinaryTreeNode treeNode) {
        if (treeNode == null) {

            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }
            stack.push(node);
        }
        while (!stack.empty()) {
            BinaryTreeNode stakeNode = stack.pop();
            System.out.print(stakeNode.getData());

        }
    }
}
