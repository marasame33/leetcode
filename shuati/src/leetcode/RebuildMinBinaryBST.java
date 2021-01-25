package leetcode;

/**
 * 给定一个有序数组，重建高度最小的二叉搜索树，
 * hint：使用二分法
 */
public class RebuildMinBinaryBST {

    public BinaryTree.BinaryTreeNode sortedArrayToBST(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    private BinaryTree.BinaryTreeNode help(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        if (left == right) {
            return new BinaryTree.BinaryTreeNode(nums[left]);
        }
        int mid = (left + right) / 2;
        BinaryTree.BinaryTreeNode root = new BinaryTree.BinaryTreeNode(nums[mid]);
        root.right = help(nums, mid + 1, right);
        root.left = help(nums, left, mid - 1);
        return root;
    }

}
