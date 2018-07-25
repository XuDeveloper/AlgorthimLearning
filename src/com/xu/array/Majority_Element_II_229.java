package com.xu.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. 超过n/3元素个数最多只有2个，记为num1和num2
 * <p>
 * 2. 数组中连续3个数据为一组的话,一共n/3组,那么如果存在符合条件的元素,这个元素一定出现在某一个组内两次
 * <p>
 * 3. 知道了以上两个条件后,用所谓的摩尔投票法,共两轮,
 * <p>
 * 第一轮:找出出现次数最多的两个元素,每次存储两个元素num1和num2,如果第三个元素与其中一个相同,则增加计数c1或c2,否则,清除n1和n2,从下一个数据开始重新统计.
 * <p>
 * 根据第二条,数目较多的元素一定可以被查到,当然查到的不一定是大于n/3的.
 * <p>
 * 第二轮:验证这两个元素是否满足条件,即出现的次数是否大于n/3;
 */
public class Majority_Element_II_229 {

    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        if (nums.length == 1) {
            result.add(nums[0]);
            return result;
        }
        int num1 = 0;
        int num2 = 0;
        int c1 = 0;
        int c2 = 0;
        for (int num : nums) {
            if (num1 == num) c1++;
            else if (num2 == num) c2++;
            else if (c1 < 1) {
                c1 = 1;
                num1 = num;
            } else if (c2 < 1) {
                c2 = 1;
                num2 = num;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int num : nums) {
            if (num == num1) c1++;
            else if (num == num2) c2++;
        }
        if (c1 > nums.length / 3) result.add(num1);
        if (c2 > nums.length / 3) result.add(num2);
        return result;
    }

}
