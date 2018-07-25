package com.xu.offer;

public class Verify_Squence_of_BST_24 {

    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length == 0)
            return false;
        // 调用函数，java没有指针，要用下标模拟指针，新建函数判断
        return isTreeBST(sequence, 0, sequence.length - 1);
    }

    public boolean isTreeBST(int[] sequence, int start, int end) {
        int index = start;
        for (; index < end; index++) {
            if (sequence[index] > sequence[end]) {
                break;
            }
        }
        for (int i = index; i < end; i++) {
            if (sequence[i] < sequence[end]) {
                return false;
            }
        }
        return isTreeBST(sequence, start, index - 1) && isTreeBST(sequence, index, end - 1);
    }

}
