package com.problems.easy.sum;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/two-sum/
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

//        int[] output = solution.twoSumBruteForce(ar, 8);
        int[] output = solution.twoSumIndexes(ar, 8);
        System.out.println(ar);
        System.out.println(output[0] + ":" + output[1]);
    }
}

class TwoSumSolution {

    public int[] twoSumBruteForce(int[] nums, int target) {
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
    public int[] twoSumIndexes(int[] nums, int target) {
    	Map<Integer, Integer> numDiff = new HashMap<>();
    	for(int index =0; index< nums.length; index++) {
    		int diff = target - nums[index];
    		if(numDiff.containsKey(diff)) {
    			return new int[] {numDiff.get(diff), index};
    		}else {
    			numDiff.put(nums[index], index);
    		}
    	}
    	throw new IllegalArgumentException("Two sum not found");
    }
}