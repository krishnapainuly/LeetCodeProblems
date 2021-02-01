package com.problems.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/merge-intervals/
/**
 * Given a list of possibly overlapping intervals, return a new list of
 * intervals where all overlapping intervals have been merged.
 * 
 * The input list is not necessarily ordered in any way.
 * 
 * For example, given [(1, 3), (5, 8), (4, 10), (20, 25)], you should return
 * [(1, 3), (4, 10), (20, 25)].
 */
public class OverlappingIntervals {
	public static void main(String args[]) {
		int[][] intervals = new int[][] { { 1, 3 }, { 5, 8 }, { 4, 10 }, { 20, 25 } };
//		int[][] intervals = new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18 } }; // [[1,3],[2,6],[8,10],[15,18]]
		System.out.println(Arrays.asList(intervals[0]));
		System.out.println(removeOverlappingIntervals(intervals));
	}

	// my approach
	public static int[][] removeOverlappingIntervals(int[][] intervals) {
		if (intervals.length < 2) {
			return intervals;
		}
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int a[], int b[]) {
				return a[0] - b[0];
			}
		});
		List<Integer> start = new ArrayList();
		List<Integer> end = new ArrayList();
		start.add(intervals[0][0]);
		end.add(intervals[0][1]);
		int count = 0;
		for (int i = 1; i < intervals.length; i++) {
			if (intervals[i][0] <= end.get(count)) {
				if (intervals[i][1] > end.get(count)) {
					end.set(count, intervals[i][1]);
				}
			} else {
				start.add(intervals[i][0]);
				end.add(intervals[i][1]);
				count++;
			}
		}
		int result[][] = new int[start.size()][2];
		for (int i = 0; i < start.size(); i++) {
			result[i][0] = start.get(i);
			result[i][1] = end.get(i);
			System.out.println(result[i][0] + ":" + result[i][1]);
		}

		return result;
	}

	// best approach leetcode
	public int[][] merge2(int[][] intervals) {
		Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
		LinkedList<int[]> merged = new LinkedList<>();
		for (int[] interval : intervals) {

			if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
				merged.add(interval);
			} else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
			}
		}
		return merged.toArray(new int[merged.size()][]);
	}
}
