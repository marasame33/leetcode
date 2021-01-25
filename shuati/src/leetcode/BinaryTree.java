package leetcode;

import Utils.ArrayUtils;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

public class BinaryTree {

    /**
     * 非递归后续遍历
     *
     * @param root
     */
    public static List<Integer> postorderTraversal(BinaryTreeNode root) {
        List<Integer> res = Lists.newArrayList();
        BinaryTreeNode lastVisit = root;
        Stack<BinaryTreeNode> stack = new Stack<>();
        if (root == null) {
            return Lists.newArrayList();
        }
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            BinaryTreeNode p = stack.pop();
            if (p.right == null || p.right == lastVisit) {
                lastVisit = p;
                res.add(p.val);
            } else {
                stack.push(p);
                p = p.right;
                while(p!=null){
                    stack.push(p);
                    p = p.left;
                }
            }
        }
        return res;
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

        public int val;

        public BinaryTreeNode left;

        public BinaryTreeNode right;

        public BinaryTreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        BinaryTreeNode node1 = new BinaryTreeNode(2);
        BinaryTreeNode node2 = new BinaryTreeNode(3);
        BinaryTreeNode node3 = new BinaryTreeNode(4);
        BinaryTreeNode node4 = new BinaryTreeNode(5);
        BinaryTreeNode node5 = new BinaryTreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        postorderTraversal(root).forEach(System.out::println);
    }
}
