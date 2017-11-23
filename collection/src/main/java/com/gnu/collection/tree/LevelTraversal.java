package com.gnu.collection.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 水平优先遍历
 * @author siberiwolf@hotmail.com on 2017/11/23
 */
public class LevelTraversal {
    public static void traversal(Node node) {
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
}
