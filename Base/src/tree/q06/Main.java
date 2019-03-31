package tree.q06;

import base.BinaryTreeNode;
import base.DataUtils;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 计算二叉树的高度
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(heightOfBinaryTree(DataUtils.getSimpleBinaryTree()));
        System.out.println(heightOfBinaryTree2(DataUtils.getSimpleBinaryTree()));
    }

    /**
     * 递归方式
     */
    public static int heightOfBinaryTree(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            int height;
            int leftHeight = heightOfBinaryTree(treeNode.getLeft());
            int rightHeight = heightOfBinaryTree(treeNode.getRight());

            height = Math.max(leftHeight, rightHeight);

            return height + 1;
        }

        return 0;
    }

    /**
     * 非递归方式
     *
     * 计算不对！
     */
    public static int heightOfBinaryTree2(BinaryTreeNode treeNode) {
        if (treeNode == null) {

            return 0;
        }
        int level = 1;
        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        queue.add(new BinaryTreeNode(-1));
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            if (node.getData() == -1) {
                // 说明是节点
                if (node.getLeft() != null) {
                    queue.add(node.getLeft());
                }
                if (node.getRight() != null) {
                    queue.add(node.getRight());
                }
            } else {
                if (!queue.isEmpty()) {
                    queue.add(new BinaryTreeNode(-1));
                }

                level++;
            }
        }

        return level;
    }
}
