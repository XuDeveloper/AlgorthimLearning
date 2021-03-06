package com.xu;

import com.xu.basic.*;
import com.xu.linkedlist.ListNode;
import com.xu.linkedlist.Merge_Two_Sorted_Lists_21;
import com.xu.linkedlist.Sort_List_148;
import com.xu.offer.Fibonacci_9;
import com.xu.offer.Least_K_30;
import com.xu.offer.Max_in_Window_65;
import com.xu.offer.Replace_Space_4;
import com.xu.string.Longest_Palindromic_Substring_5;
import com.xu.string.Reorganize_String_767;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        // write your code here
//        ShellSort selectionSort = new ShellSort();
//        int[] vals = {1, 4, 7, 3, 2, 9, 0};
//        selectionSort.sort(vals);
//        for (int i = 0; i < vals.length; i++) {
//            System.out.print(vals[i] + " ");
//        }
//        Sort_List_148 sorted_lists = new Sort_List_148();
//        ListNode l1 = new ListNode(4);
//        ListNode l2 = new ListNode(1);
//        ListNode l3 = new ListNode(3);
//        ListNode l4 = new ListNode(2);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        sorted_lists.sortList(l1);

//        int a = 2;
//        int result = a++ + 4 << 2;
//        System.out.println(result);


    }

    public int binarySort(int[] data, int n, int target) {
        int l = 0, r = n; // 循环不变量：在[l..r)范围内寻找target
        while (l < r) {  // 当l == r时，区间无效
            int mid = l + (r - l) / 2;
            if (data[mid] == target) {
                return mid;
            }
            if (data[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return -1;
    }
}
