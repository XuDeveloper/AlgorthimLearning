package com.xu.tree;

public class Find_Mode_in_Binary_Search_Tree_501 {

    public int[] findMode(TreeNode root) {
        inOrder(root);
        modes = new int[modeCount];
        currCount = 0;
        modeCount = 0;
        inOrder(root);
        return modes;
    }

    int currVal = 0;
    int currCount = 0;
    int maxCount = 0;
    int modeCount = 0;

    int[] modes;

    public void handleValue(int val) {
        if (currVal != val) {
            currVal = val;
            currCount = 0;
        }
        currCount++;
        if (currCount > maxCount) {
            maxCount = currCount;
            modeCount = 1;
        } else if (currCount == maxCount) {
            if (modes != null) {
                modes[modeCount] = currVal;
            }
            modeCount++;
        }
    }

    public void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        handleValue(root.val);
        inOrder(root.right);
    }

}
