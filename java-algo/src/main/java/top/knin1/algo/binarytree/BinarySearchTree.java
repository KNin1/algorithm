package top.knin1.algo.binarytree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 二叉查找树（不包含重复键值）
 * @author KNin1
 * @date 2021-04-10
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;

    public TreeNode<T> getRoot() {
        return root;
    }

    public TreeNode<T> find(T data) {
        if (root == null) {
            return null;
        }
        TreeNode<T> p = root;
        while (p != null) {
            int flag = p.getData().compareTo(data);
            if (flag == 0) {
                return p;
            } else if (flag > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        return null;
    }

    public void insert(T data) {
        TreeNode<T> newNode = new TreeNode<>(data);
        if (root == null) {
            root = newNode;
            return;
        }
        TreeNode<T> p = root;
        while (p != null) {
            int flag = p.getData().compareTo(data);
            if (flag > 0){
                if (p.left == null) {
                    p.left = newNode;
                    return;
                }
                p = p.left;
            } else {
                if (p.right == null) {
                    p.right = newNode;
                    return;
                }
                p = p.right;
            }
        }
    }

    public void delete(T data) {
        if (root == null) {
            return;
        }
        TreeNode<T> p = root; // 指向要删除的节点
        TreeNode<T> pp = null; // 指向 p 的父节点
        int flag;
        while (p != null && ((flag = p.getData().compareTo(data)) != 0)) {
            pp = p;
            if (flag > 0) {
                p = p.left;
            } else {
                p = p.right;
            }
        }
        if (p == null) { // 没有找到
            return;
        }
        // 要删除的节点有两个子节点
        if (p.left != null && p.right != null){
            TreeNode<T> minP = p.right; // 指向右子树中最小的节点
            TreeNode<T> minPP = p; // minPP 表示 minP 的父节点
            while (minP.left != null) {
                minPP = minP;
                minP = minP.left;
            }
            p.setData(minP.getData()); // 将 minP 节点的数据替换到 p 节点中
            p = minP;
            pp = minPP;
        }
        // 要删除的节点是叶子节点或者只有一个子节点
        TreeNode<T> child = null;
        if (p.left != null) {
            child = p.left;
        } else if (p.right != null) {
            child = p.right;
        }
        if (pp == null) {
            // 删除的是根节点
            root = child;
        } else if (pp.left == p) {
            pp.left = child;
        } else {
            pp.right = child;
        }
    }
}
