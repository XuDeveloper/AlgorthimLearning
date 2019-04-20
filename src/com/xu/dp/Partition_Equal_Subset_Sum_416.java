package com.xu.dp;

public class Partition_Equal_Subset_Sum_416 {

    // 0-1背包问题变种

    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        memo = new int[nums.length][sum / 2 + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < sum / 2 + 1; j++) {
                memo[i][j] = -1;
            }
        }
        return tryPartition(nums, nums.length - 1, sum / 2);
    }

    // memo[i][c]
    // -1表示为未计算，0表示不可以填充，1表示可以填充
    private int[][] memo;

    // 使用nums[0...index], 是否可以完全填充一个容量为sum的背包
    private boolean tryPartition(int[] nums, int index, int sum) {
        if (sum == 0) {
            return true;
        }
        if (sum < 0 || index < 0) {
            return false;
        }
        if (memo[index][sum] != -1) {
            return memo[index][sum] == 1;
        }
        memo[index][sum] = (tryPartition(nums, index - 1, sum) ||
                tryPartition(nums, index - 1, sum - nums[index])) ? 1 : 0;
        return memo[index][sum] == 1;
    }

    public boolean canPartition2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }

        int n = nums.length;
        int c = sum / 2;
        boolean[] memo = new boolean[c + 1];
        for (int i = 0; i <= c; i++) {
            memo[i] = (nums[0] == i);
        }
        for (int i = 1; i < n; i++) {
            for (int j = c; j >= nums[i]; j--) {
                memo[j] = memo[j] || memo[j - nums[i]];
            }
        }
        return memo[c];
    }

    public boolean canPartition3(int[] nums) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if (sum % 2 != 0) {
            return false;
        }
        boolean[][] memo = new boolean[nums.length][sum / 2 + 1];
        for (int i = 0; i < sum / 2 + 1; i++) {
            memo[0][i] = (nums[0] == i);
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = sum / 2; j >= 0; j--) {
                if (j < nums[i]) {
                    memo[i][j] = memo[i - 1][j];
                } else {
                    memo[i][j] = memo[i - 1][j] || memo[i - 1][j - nums[i]];
                }
            }
        }
        return memo[nums.length - 1][sum / 2];
    }

}
