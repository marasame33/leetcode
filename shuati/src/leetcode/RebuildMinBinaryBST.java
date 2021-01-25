package leetcode;

import bean.TreeNode;

/**
 * 给定一个有序数组，重建高度最小的二叉搜索树，
 * hint：使用二分法
 */
public class RebuildMinBinaryBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    private TreeNode help(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new TreeNode(nums[left]);
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.right = help(nums, mid + 1, right);
        root.left = help(nums, left, mid - 1);
        return root;
    }

}
