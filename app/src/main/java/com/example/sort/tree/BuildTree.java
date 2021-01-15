package com.example.sort.tree;

import android.util.Log;

import java.util.Arrays;

public class BuildTree {
    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value) {
            this.value = value;
        }
    }

    //有前序、中序，构建二叉树 ======================================begin
    public static TreeNode buildTree(int pre[], int in[]) {
        if ((null == pre)
            || (null == in)
            || (0>=pre.length)
            || (0>=in.length)
            || (pre.length != in.length)) {
            return null;
        }

        TreeNode root = new TreeNode(pre[0]);

        int index = 0;
        for (int i=0; i<in.length; ++i) {
            if (root.value == in[i]) {
                index = i;
                break;
            }
        }

        int leftIn[] = Arrays.copyOfRange(in, 0, index);
        int rightIn[] = Arrays.copyOfRange(in, index+1, in.length);
        int leftPre[] = Arrays.copyOfRange(pre, 1, leftIn.length+1);
        int rightPre[] = Arrays.copyOfRange(pre, index+1, pre.length);

        root.left = buildTree(leftPre, leftIn);
        root.right = buildTree(rightPre, rightIn);

        return root;
    }

    public static void posttraverse(TreeNode root) {
        if (null == root) {
            return;
        }

        posttraverse(root.left);
        posttraverse(root.right);
        Log.d("darren", "" + root.value + ", ");
//        System.out.println(""+root.value);
    }
    //有前序、中序，构建二叉树 ======================================end


    //有后序、中序，构建二叉树 ======================================begin
    public static TreeNode buildTree1(int in[], int post[]) {
        if ((null == in)
            || (null == post)
            || (0>=in.length)
            || (0>=post.length)
            || (in.length != post.length)) {
            return null;
        }

        TreeNode root = new TreeNode(post[post.length-1]);

        int index = 0;
        for (int i=0; i<in.length; ++i) {
            if (root.value == in[i]) {
                index = i;
                break;
            }
        }

        int leftIn[] = Arrays.copyOfRange(in, 0, index);
        int rightIn[] = Arrays.copyOfRange(in, index+1, in.length);
        int leftPost[] = Arrays.copyOfRange(post, 0, leftIn.length);
        int rightPost[] = Arrays.copyOfRange(post, leftIn.length, post.length-1);

        root.left = buildTree1(leftIn, leftPost);
        root.right = buildTree1(rightIn, rightPost);

        return root;
    }

    public static void printPre(TreeNode root) {
        if (null == root) {
            return ;
        }

        Log.d("darren", "" + root.value + ", ");
//        System.out.println(""+root.value);
        printPre(root.left);
        printPre(root.right);
    }
    //有后序、中序，构建二叉树 ======================================end

    public static void main(String[] args) {
        int pre[] = {1, 2, 4, 7, 3, 5, 6, 8};
        int in[] = {4, 7, 2, 1, 5, 3, 8, 6};
        int post[] = {7, 4, 2, 5, 8, 6, 3, 1};

        BuildTree.TreeNode root = BuildTree.buildTree(pre, in);
        BuildTree.posttraverse(root);

        System.out.println("=========================================");

        root = BuildTree.buildTree1(in, post);
        BuildTree.printPre(root);
    }
}
