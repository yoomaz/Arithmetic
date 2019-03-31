package tree.q03;

import base.BinaryTreeNode;
import base.DataUtils;

/**
 * 查找某个元素是否在二叉树中
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(findNodeInBinaryTree(DataUtils.getSimpleBinaryTree(), 1));
        System.out.println(findNodeInBinaryTree(DataUtils.getSimpleBinaryTree(), 10));
    }

    /**
     * 递归方式
     */
    public static boolean findNodeInBinaryTree(BinaryTreeNode treeNode, int data) {
        if (treeNode != null) {
            if (treeNode.getData() == data) {

                return true;
            }
            boolean leftIn = findNodeInBinaryTree(treeNode.getLeft(), data);
            boolean rightIn = findNodeInBinaryTree(treeNode.getRight(), data);

            return leftIn || rightIn;
        }
        return false;
    }
}
