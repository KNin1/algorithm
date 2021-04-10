package top.knin1.algo.binarytree;

import org.junit.Assert;
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

    @Test
    public void testBST() {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.insert("Java");
        bst.insert("C++");
        bst.insert("Python");
        bst.insert("Go");
        bst.insert("C#");

        BinaryTreeAlgo.inOrderTraverse(bst.getRoot());
        System.out.println();

        Assert.assertEquals(2, BinaryTreeAlgo.calcTreeHeight(bst.getRoot()));

        Assert.assertNotNull(bst.find("C++"));
        Assert.assertNull(bst.find("Ruby"));

        bst.delete("Python");
        Assert.assertNull(bst.find("Python"));
    }
}
