package com.learning.datastructures.leetcode;

import com.learning.datastructures.segmenttree.SegmentTree;

/**
 * 307. 区域和检索 - 数组可修改
 * 给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *
 * update(i, val) 函数可以通过将下标为 i 的数值更新为 val，从而对数列进行修改。
 *
 * 示例:
 *
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 说明:
 *
 * 数组仅可以在 update 函数下进行修改。
 * 你可以假设 update 函数与 sumRange 函数的调用次数是均匀分布的。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/range-sum-query-mutable
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution307_2 {

    private SegmentTree<Integer> segmentTree;

    public Solution307_2(int[] nums) {
        if(nums.length == 0) {
            return ;
        }
        Integer[] data = new Integer[nums.length];
        for(int i = 0; i < nums.length; i ++) {
            data[i] = nums[i];
        }
        segmentTree = new SegmentTree<Integer>(data, (a, b) -> a + b);
    }

    public void update(int index, int val) {
        segmentTree.set(index, val);
    }

    public int sumRange(int i, int j) {
        return segmentTree.query(i, j);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5};
        Solution307_2 solution307 = new Solution307_2(nums);
        System.out.println(solution307.sumRange(0, 2));
        solution307.update(1, 2);
        System.out.println(solution307.sumRange(0, 2));
    }
}
