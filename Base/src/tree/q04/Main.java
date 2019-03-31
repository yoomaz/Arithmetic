package tree.q04;

import base.BinaryTreeNode;
import base.DataUtils;

/**
 * 查找二叉树节点的个数
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(sizeOfBinaryTree(DataUtils.getSimpleBinaryTree()));
        System.out.println(sizeOfBinaryTree(DataUtils.getSimpleBinaryTree2()));
    }

    /**
     * 递归方式
     */
    public static int sizeOfBinaryTree(BinaryTreeNode treeNode) {
        if (treeNode != null) {
            int leftSize = sizeOfBinaryTree(treeNode.getLeft());
            int rightSize = sizeOfBinaryTree(treeNode.getRight());

            return leftSize + rightSize + 1;
        }
        return 0;
    }
}
