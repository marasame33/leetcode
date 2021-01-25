package leetcode;

import Utils.ArrayUtils;
import bean.TreeNode;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

public class BinaryTree {

    /**
     * 非递归后续遍历
     *
     * @param root
     */
    public static List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = Lists.newArrayList();
        TreeNode lastVisit = root;
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return Lists.newArrayList();
        }
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
        while (!stack.isEmpty()) {
            TreeNode p = stack.pop();
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
    public List<Integer> inorderTraversal(TreeNode root) {
        return null;
    }

    /**
     * 非递归先序遍历
     *
     * @param root
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        return null;
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        postorderTraversal(root).forEach(System.out::println);
    }
}
