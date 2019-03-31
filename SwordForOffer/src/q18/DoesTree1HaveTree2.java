package q18;

import base.BinaryTreeNode;
import base.DataUtils;
import base.ListNode;

/**
 * 判断二叉树B是不是二叉树A的子树
 * <p>
 * 思路：先判断 A,B 根元素是否相等，
 * 如果相等，再递归遍历左子树和右子树是否是符合子树
 * 如果不相同，看 A 的左子树是否有 B 的子树，如果左边没有，看 A 的右子树有没有 B 的子树
 * <p>
 * 注意：这里有两个递归，一个是判断是否有子树，一个判断是不是相同根节点的子树
 */
public class DoesTree1HaveTree2 {

    public static void main(String[] args) {
        System.out.println(hasSubTree(DataUtils.getSimpleBinaryTree2(), DataUtils.getSimpleBinaryTree3()));
    }

    public static boolean hasSubTree(BinaryTreeNode root1, BinaryTreeNode root2) {
        boolean result = false;
        if (root1 != null && root2 != null) {
            if (root1.getData() == root2.getData()) {
                result = doesTree1HaveTree2(root1, root2);
            }
            if (!result) {
                result = hasSubTree(root1.getLeftNode(), root2);
            }
            if (!result) {
                result = hasSubTree(root1.getRightNode(), root2);
            }
        }

        return result;
    }

    public static boolean doesTree1HaveTree2(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.getData() != root2.getData()) {
            return false;
        }

        return doesTree1HaveTree2(root1.getLeftNode(), root2.leftNode) && doesTree1HaveTree2(root1.getRightNode(), root2.getRightNode());
    }
}
