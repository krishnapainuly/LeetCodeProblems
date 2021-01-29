package com.problems.easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * https://leetcode.com/problems/meeting-rooms-ii/
 * Given an array of time intervals (start, end) for classroom lectures (possibly overlapping), find the minimum number of rooms required. 
 * For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.
 * @author 16605
 *
 */
public class MeetingRoom {

	public static void main(String args[]) {
		int[][] intervals = new int[][] { { 0, 30 }, { 5, 10 }, { 15, 20 } };
		System.out.println(minMeetingRooms(intervals));
	}

	private static int minMeetingRooms(int[][] intervals) {
		if (intervals.length < 2) {
			return intervals.length;
		}

		// sort by start time
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(final int a[], final int b[]) {
				return a[0] - b[0];
			}
		});

		// Min heap
		PriorityQueue<Integer> allocation = new PriorityQueue<>(intervals.length, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});

		allocation.add(intervals[0][1]);
		// interate over remaining intervals
		for (int i = 1; i < intervals.length; i++) {
			// if room is free(end time of allocated meeting is < new time ), assign that
			// meeting room
			if (intervals[i][0] >= allocation.peek()) {
				allocation.poll();
			}
			// assign new room, if old room is allocated
			allocation.add(intervals[i][1]);

		}
		return allocation.size();
	}
}
