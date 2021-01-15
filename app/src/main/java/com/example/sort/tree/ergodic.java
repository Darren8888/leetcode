package com.example.sort.tree;

public class ergodic {
    //前序遍历
    public static void pre_order(TreeNode node) {
        if (null == node) return;

        System.out.println(node.value);
        pre_order(node.left);
        pre_order(node.right);
    }

    public static void middle_order(TreeNode node) {
        if (null == node) return;

        middle_order(node.left);
        System.out.println(node.value);
        middle_order(node.right);
    }

    public static void post_order(TreeNode node) {
        if (null == node) return;

        pre_order(node.left);
        pre_order(node.right);
        System.out.println(node.value);
    }
}
