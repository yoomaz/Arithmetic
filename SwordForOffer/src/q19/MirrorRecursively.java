package q19;

import base.BinaryTreeNode;
import base.DataUtils;

import java.util.Stack;

/**
 * 输入一个二叉树，输出它的镜像
 * <p>
 * 思路1：递归
 * 思路2：非递归，用栈保存节点, 比较难理解
 */
public class MirrorRecursively {

    public static void main(String[] args) {
        BinaryTreeNode root = DataUtils.getSimpleBinaryTree2();

        DataUtils.levelOrder(root);

//        mirrorRecursively1(root);
        mirrorRecursively2(root);

        System.out.println();

        DataUtils.levelOrder(root);
    }

    public static void mirrorRecursively1(BinaryTreeNode root) {
        if (root == null) {

            return;
        }
        BinaryTreeNode temp = root.getLeftNode();
        root.setLeftNode(root.getRightNode());
        root.setRightNode(temp);

        mirrorRecursively1(root.getLeftNode());
        mirrorRecursively1(root.getRightNode());
    }

    public static void mirrorRecursively2(BinaryTreeNode root) {
        if (root == null) {

            return;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                BinaryTreeNode temp = node.getLeftNode();
                node.setLeftNode(node.getRightNode());
                node.setRightNode(temp);

                stack.push(node);
                node = node.getLeftNode();
            }

            node = stack.pop().getRightNode();
        }
    }
}
