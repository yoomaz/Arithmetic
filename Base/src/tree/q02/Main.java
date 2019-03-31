package tree.q02;

import base.BinaryTreeNode;
import base.DataUtils;

/**
 * 查找二叉树中最大值
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(findMax(DataUtils.getSimpleBinaryTree()));
    }

    /**
     * 递归方式
     */
    public static int findMax(BinaryTreeNode treeNode) {
        int leftMax;
        int rightMax;
        int max = Integer.MIN_VALUE;

        if (treeNode != null) {
            leftMax = findMax(treeNode.getLeft());
            rightMax = findMax(treeNode.getRight());

            if (leftMax > rightMax) {
                max = leftMax;
            } else {
                max = rightMax;
            }

            if (max < treeNode.getData()) {
                max = treeNode.getData();
            }
        }
        return max;
    }

    /**
     * 层次遍历方式
     */
    public static int findMaxByLevelOrder(BinaryTreeNode treeNode) {

        return 0;
    }
}
