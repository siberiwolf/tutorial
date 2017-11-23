package com.gnu.collection.tree;

/**
 * @author siberiwolf@hotmail.com on 2017/11/21
 */
public class Node {
    int key;
    Node left, right;

    public Node(int item) {
        this.key = item;
        this.left = null;
        this.right = null;
    }

}
