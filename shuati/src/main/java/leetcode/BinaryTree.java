package leetcode;

import java.util.List;

public class BinaryTree {

    /**
     * 非递归后续遍历
     *
     * @param root
     */
    public List<Integer> postorderTraversal(BinaryTreeNode root) {
        return null;
    }

    /**
     * 非递归中序遍历
     *
     * @param root
     */
    public List<Integer> inorderTraversal(BinaryTreeNode root) {
        return null;
    }

    /**
     * 非递归先序遍历
     *
     * @param root
     */
    public List<Integer> preorderTraversal(BinaryTreeNode root) {
        return null;
    }


    static class BinaryTreeNode {

        private int val;

        private BinaryTreeNode left;

        private BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public BinaryTreeNode getLeft() {
            return left;
        }

        public void setLeft(BinaryTreeNode left) {
            this.left = left;
        }

        public BinaryTreeNode getRight() {
            return right;
        }

        public void setRight(BinaryTreeNode right) {
            this.right = right;
        }
    }
}
