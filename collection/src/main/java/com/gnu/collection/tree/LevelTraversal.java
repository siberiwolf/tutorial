package com.gnu.collection.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 水平优先遍历
 *
 * @author siberiwolf@hotmail.com on 2017/11/23
 */
public class LevelTraversal {
    public static void traversalWithQueue(Node node) {
        Queue<Node> queue = new LinkedList<>();
        Node temp = node;

        while (temp != null) {
            System.out.print(temp.key + ",");
            if (temp.left != null) {
                queue.add(temp.left);
            }

            if (temp.right != null) {
                queue.add(temp.right);
            }

            temp = queue.poll();
        }
    }

    public static void traversalWithRecursion(BinaryTree tree) {
        int height = height(tree.root);

        for (int i = 1; i <= height; i++) {
            List<Node> nodes = getLevelNodes(tree, i);
            for (Node node: nodes ) {
                System.out.print(node.key + ",");
            }
        }
    }

    // 计算树的高度
    private static int height(Node root) {
        if (root == null) return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);

        if (lheight >= rheight) {
            return lheight + 1;
        } else {
            return rheight + 1;
        }
    }

    private static List<Node> getLevelNodes(BinaryTree tree, int level) {
        if (tree == null || tree.root == null) {
            return null;
        }

        List<Node> nodes = new ArrayList<>();
        if (level == 1) {
            // 第一层，只有根节点
            nodes.add(tree.root);
            return nodes;
        }

        // 获取上一层的节点，遍历上一层节点列表，获取到的子节点即为当前层节点
        List<Node> parentNodes = getLevelNodes(tree, level - 1);
        for (Node node : parentNodes) {
            if (node.left != null) {
                nodes.add(node.left);
            }
            if (node.right != null) {
                nodes.add(node.right);
            }
        }

        return nodes;
    }
}
