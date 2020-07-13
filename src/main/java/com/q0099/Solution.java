package com.q0099;

import com.q0101_symmetric_tree.TreeNode;

/**
 * @author xjn
 * @since 2020-06-07
 * https://leetcode-cn.com/problems/recover-binary-search-tree/
 * 99. 恢复二叉搜索树
 */
public class Solution {
    private TreeNode pre;
    private TreeNode a,b;
    public void recoverTree(TreeNode root) {
        if(root == null){
            return;
        }
        pre = null;
        a = null;
        b = null;
        inorder(root);
        int c = a.val;
        a.val = b.val;
        b.val = c;

    }
    //  2
    //1   4
    //      3
    private void inorder(TreeNode root){
        if(root == null){
            return;
        }
        inorder(root.left);
        if(pre != null && root.val <= pre.val){
            if(a == null){
                a = pre;
                b = root;
            }else{
                b = root;
            }
        }
        pre = root;
        inorder(root.right);
    }
}
