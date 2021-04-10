package top.knin1.algo.binarytree;

import java.util.ArrayDeque;

/**
 * @author KNin1
 */
public class BinaryTreeAlgo {
    public static <T> void preOrderTraverse(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.print(node.getData() + "->");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }

    public static <T> void inOrderTraverse(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        inOrderTraverse(node.left);
        System.out.print(node.getData() + "->");
        inOrderTraverse(node.right);
    }

    public static <T> void postOrderTraverse(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.getData() + "->");
    }

    public static <T> void layerTraverse(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        ArrayDeque<TreeNode<T>> nodes = new ArrayDeque<>();
        nodes.add(node);
        while (!nodes.isEmpty()) {
            TreeNode<T> curNode = nodes.pop();
            System.out.print(curNode.getData() + "->");
            if (curNode.left != null) {
                nodes.add(curNode.left);
            }
            if (curNode.right != null) {
                nodes.add(curNode.right);
            }
        }
    }

    /**
     * 计算二叉树的高度
     */
    public static <T> int calcTreeHeight(TreeNode<T> node) {
        if (node == null || (node.left == null && node.right == null)) {
            return 0;
        }
        int leftChildHeight = calcTreeHeight(node.left);
        int rightChildHeight = calcTreeHeight(node.right);
        return leftChildHeight > rightChildHeight ? leftChildHeight + 1 : rightChildHeight + 1;
    }
}
