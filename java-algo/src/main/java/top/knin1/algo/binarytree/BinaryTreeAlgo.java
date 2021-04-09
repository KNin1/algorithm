package top.knin1.algo.binarytree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

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
}
