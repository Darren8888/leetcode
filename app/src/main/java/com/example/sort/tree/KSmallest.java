package com.example.sort.tree;

import android.widget.TableRow;

//二查查找树的第K个最小值（二查查找树性质：左节点的值小于当前节点，右节点大于当前节点；左树也一样，右树也一样）
public class KSmallest {
    private int result = 0;
    private int count = 0;
    public int getKSmallest(TreeNode node, int k) {
        count = k;
        inOrder(node);
        return result;
    }
    private void inOrder(TreeNode node) {
        if ((null == node) || (0>=count)) return;

        inOrder(node.left);
        if (0 == --count) result = node.value;
        inOrder(node.right);
    }
}
