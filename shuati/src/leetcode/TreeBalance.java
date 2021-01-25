package leetcode;

import bean.TreeNode;

/**
 * 判断一颗二叉树是否是平衡二叉树
 * 左右子树的深度差值不超过1
 */
public class TreeBalance {

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return false;
        }
        return Math.abs(deepOfTree(root.left) - deepOfTree(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int deepOfTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(deepOfTree(root.left), deepOfTree(root.right)) + 1;
    }

}
