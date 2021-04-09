package top.knin1.algo.binarytree;

import org.junit.Test;

/**
 * @author KNin1
 */
public class BinaryTreeTest {
    @Test
    public void testBinaryTreeTraversal() {
        // 组织一颗二叉树
        TreeNode<String> root = new TreeNode<>("A");
        TreeNode<String> sub1 = new TreeNode<>("B");
        TreeNode<String> sub2 = new TreeNode<>("C");
        TreeNode<String> sub3 = new TreeNode<>("D");
        TreeNode<String> sub4 = new TreeNode<>("E");
        root.left = sub1;
        root.right = sub2;
        sub1.left = sub3;
        sub2.left = sub4;

        BinaryTreeAlgo.preOrderTraverse(root);
        System.out.println();

        BinaryTreeAlgo.inOrderTraverse(root);
        System.out.println();

        BinaryTreeAlgo.postOrderTraverse(root);
        System.out.println();

        BinaryTreeAlgo.layerTraverse(root);
    }
}
