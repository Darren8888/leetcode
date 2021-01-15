package com.example.sort.tree;

public class CompleteBinayNodeNum {
    /**
     完全二叉树的高度可以直接通过不断地访问左子树就可以获取
     判断左右子树的高度:
     如果相等说明左子树是满二叉树, 然后进一步判断右子树的节点数(最后一层最后出现的节点必然在右子树中)
     如果不等说明右子树是深度小于左子树的满二叉树, 然后进一步判断左子树的节点数(最后一层最后出现的节点必然在左子树中)
     **/
    public int count(TreeNode node) {
        if (null == node) return 0;

        int leftDeep = deep(node.left);
        int rightDeep = deep(node.right);

        if (leftDeep == rightDeep) return ((1<<leftDeep)+count(node.right)); // 1(根节点) + (1 << ld)-1(左完全左子树节点数) + 右子树节点数量
        else return (1<<rightDeep) + count(node.left); // 1(根节点) + (1 << rd)-1(右完全右子树节点数) + 左子树节点数量
    }

    private int deep(TreeNode node) {
        int deep = 0;
        while (null != node) {
            ++deep;
            node = node.left;
        }
        return deep;
    }
}
