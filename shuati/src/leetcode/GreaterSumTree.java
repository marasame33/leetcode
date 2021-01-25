package leetcode;

/**
 * 把二叉树变成累加树
 * 利用镜像先序遍历
 */
public class GreaterSumTree {

    int num = 0;

    public BinaryTree.BinaryTreeNode convertBST(BinaryTree.BinaryTreeNode root) {
        if (root != null) {
            convertBST(root.right);
            root.val += num;
            num = root.val;
            convertBST(root.left);
        }
        return root;
    }
}
