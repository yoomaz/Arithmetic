package tree.q07;

import base.BinaryTreeNode;
import base.DataUtils;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 查找二叉树最深节点的方法
 */
public class Main {

    public static void main(String[] args) {
        System.out.print("最深节点:");
        System.out.println(deepestNodeInBinaryTree(DataUtils.getSimpleBinaryTree()).getData());
    }

    /**
     * 借助层次遍历，最后一个进入队列的是最深的元素
     */
    public static BinaryTreeNode deepestNodeInBinaryTree(BinaryTreeNode treeNode) {
        if (treeNode == null) {

            return null;
        }
        BinaryTreeNode temp = null;

        Queue<BinaryTreeNode> queue = new ArrayDeque<>();
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.getLeft() != null) {
                queue.add(temp.getLeft());
            }
            if (temp.getRight() != null) {
                queue.add(temp.getRight());
            }
        }

        return temp;
    }
}
