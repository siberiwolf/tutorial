package com.gnu.collection.tree;

/**
 * @author siberiwolf@hotmail.com on 2017/11/21
 */
public class BinaryTree {
    private Node root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(int key) {
        this.root = new Node(key);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        /* following is the tree after above statement
              1
            /   \
          null  null
         */

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        /* 2 and 3 become children of 1
               1
             /   \
            2      3
          /    \    /  \
        null null null null
         */

        tree.root.left.left = new Node(4);
        /*
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */

        tree.root.left.right = new Node(5);
        /*
                    1
                /       \
               2          3
             /   \
            4    5
         */
        System.out.print("Inorder traversal : ");
        DepthTraversal.inorderTraversal(tree.root);
        System.out.print("\n");

        System.out.print("Preorder traversal : ");
        DepthTraversal.preorderTraversal(tree.root);
        System.out.print("\n");

        System.out.print("Postorder traversal : ");
        DepthTraversal.postorderTraversal(tree.root);
        System.out.print("\n");

        System.out.print("Level traversal : ");
        LevelTraversal.traversal(tree.root);
        System.out.print("\n");
    }
}
