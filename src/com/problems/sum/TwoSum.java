package com.problems.sum;
/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSumSolution solution = new TwoSumSolution();
        int ar[] = { 5, 4, 2, 6, 7, 1 };

        int[] output = solution.twoSum(ar, 8);
        System.out.println(ar);
        System.out.println(output[0] + ":" + output[1]);
    }
}

class TwoSumSolution {

    public int[] twoSum(int[] nums, int target) {
        int targetNums[] = new int[3];
        for (int index = 0; index < nums.length - 1; index++) {
            for (int index2 = index + 1; index2 < nums.length; index2++) {
                int sum = nums[index] + nums[index2];
                if (sum == target) {
                    targetNums[0] = nums[index];
                    targetNums[1] = nums[index2];
                }
            }
        }
        return targetNums;
    }
}