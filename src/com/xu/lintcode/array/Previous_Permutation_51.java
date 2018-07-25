package com.xu.lintcode.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Previous_Permutation_51 {

    public List<Integer> previousPermuation(List<Integer> nums) {
        ArrayList<Integer> perm = new ArrayList<Integer>(nums);
        if (nums == null || nums.size() == 0) return perm;

        // step1: search the first num[k] > num[k+1] backward
        int k = -1;
        for (int i = perm.size() - 2; i >= 0; i--) {
            if (perm.get(i) > perm.get(i + 1)) {
                k = i;
                break;
            }
        }
        // if current rank is the smallest, reverse it to largest, return
        if (k == -1) {
            reverse(perm, 0, perm.size() - 1);
            return perm;
        }

        // step2: search the first perm[k] > perm[l] backward
        int l = perm.size() - 1;
        while (l > k && perm.get(l) >= perm.get(k)) {
            l--;
        }

        // step3: swap perm[k] with perm[l]
        Collections.swap(perm, k, l);

        // step4: reverse between k+1 and perm.length-1;
        reverse(perm, k + 1, perm.size() - 1);

        return perm;
    }

    private void reverse(List<Integer> nums, int lb, int ub) {
        for (int i = lb, j = ub; i < j; i++, j--) {
            Collections.swap(nums, i, j);
        }
    }


}
