package top.knin1.algo.binarytree;

/**
 * 二叉树节点
 * @author KNin1
 * @date 2021-04-09
 */
public class TreeNode<T> {
    private T data;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
