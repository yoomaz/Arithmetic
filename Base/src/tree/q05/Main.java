package tree.q05;

import base.BinaryTreeNode;
import base.DataUtils;

/**
 * 删除一颗二叉树
 * <p>
 * 思路：需要先删除树的左右子节点，然后再删除自己，后根遍历方式正好合适
 */
public class Main {

    public static void main(String[] args) {
        deleteBinaryTree(DataUtils.getSimpleBinaryTree());
    }

    /**
     * 递归方式
     */
    public static void deleteBinaryTree(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            deleteBinaryTree(treeNode.getLeft());
            deleteBinaryTree(treeNode.getRight());

            System.out.println("origin:" + treeNode.getData());
            treeNode.setData(-1);
        }
    }
}
