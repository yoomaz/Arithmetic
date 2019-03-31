package tree.q08;

import base.BinaryTreeNode;
import base.DataUtils;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定两颗二叉树，判定他们的结构是否相同
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(isTheSameTree(DataUtils.getSimpleBinaryTree(), DataUtils.getSimpleBinaryTree()));

        System.out.println(isTheSameTree(DataUtils.getSimpleBinaryTree(), DataUtils.getSimpleBinaryTree2()));
    }

    /**
     * 使用递归，先判断当前节点，然后判断左树和右树
     */
    public static boolean isTheSameTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {

            return true;
        }
        // 排除都为空，说明只有一个为空
        if (root1 == null || root2 == null) {

            return false;
        }
        if (root1.getData() != root2.getData()) {
            return false;
        } else {
            boolean leftSame = isTheSameTree(root1.getLeft(), root2.getLeft());
            boolean rightSame = isTheSameTree(root1.getRight(), root2.getRight());

            return leftSame && rightSame;
        }
    }
}
