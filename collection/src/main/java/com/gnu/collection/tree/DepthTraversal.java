package com.gnu.collection.tree;

/**
 * 深度优先遍历
 * @author siberiwolf@hotmail.com on 2017/11/23
 */
public class DepthTraversal {
    /**
     * 中序遍历(left->parent->right)
     * @param node
     */
    public static void inorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        System.out.print(node.key + ",");
        inorderTraversal(node.right);
    }

    /**
     * 前序遍历(parent->left->right)
     * @param node
     */
    public static void preorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        System.out.print(node.key + ",");
        preorderTraversal(node.left);
        preorderTraversal(node.right);
    }

    /**
     * 后序遍历(left->right->parent)
     * @param node
     */
    public static void postorderTraversal(Node node) {
        if (node == null) {
            return;
        }

        postorderTraversal(node.left);
        postorderTraversal(node.right);
        System.out.print(node.key + ",");
    }
}
