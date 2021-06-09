package com.ss.jb.five.Assignment_5_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Functional {
	public Functional() {
		System.out.println(rightDigit((new ArrayList<>(Arrays.asList(1, 22, 93)))));
		System.out.println(rightDigit((new ArrayList<>(Arrays.asList(16, 8, 886, 8, 1)))));
		System.out.println(rightDigit((new ArrayList<>(Arrays.asList(10, 0)))));

		System.out.println(doubling((new ArrayList<>(Arrays.asList(1, 2, 3)))));
		System.out.println(doubling((new ArrayList<>(Arrays.asList(6, 8, 6, 8, -1)))));
		System.out.println(doubling((new ArrayList<>(Arrays.asList()))));

		System.out.println(noX((new ArrayList<>(Arrays.asList("ax", "bb", "cx")))));
		System.out.println(noX((new ArrayList<>(Arrays.asList("xxax", "xbxbx", "xxcx")))));
		System.out.println(noX((new ArrayList<>(Arrays.asList("x")))));

		int[] nums1 = { 2, 4, 8 };
		System.out.println(groupSumClump(0, nums1, 10));
		int[] nums2 = { 1, 2, 4, 8, 1 };
		System.out.println(groupSumClump(0, nums2, 14));
		int[] nums3 = { 2, 4, 4, 8 };
		System.out.println(groupSumClump(0, nums3, 14));

	}

	// Given a list of non-negative integers, return an integer list of the
	// rightmost digits. (Note: use %)
	public static ArrayList<Integer> rightDigit(ArrayList<Integer> list) {
		// Replace each number with itself mod 10
		list.replaceAll(x -> x % 10);
		return list;
	}

	// Given a list of integers, return a list where each integer is multiplied by
	// 2.
	public static List<Integer> doubling(List<Integer> list) {
		// Replace each number with its double
		list.replaceAll(x -> x * 2);
		return list;
	}

	// Given a list of strings, return a list where each string has all its "x"
	// removed.
	public static List<String> noX(List<String> list) {
		// Replace x's with ""
		list.replaceAll(x -> x.replace("x", ""));
		return list;
	}

	public static boolean groupSumClump(int iter, int[] nums, int target) {
		// If we've already checked all of nums, return if we are at the target
		if (iter >= nums.length) {
			if (target == 0) {
				return true;
			} else {
				return false;
			}
		}

		// i is for checking the next clump
		int i = iter;
		int total = 0;

		// Find the next clump size
		while (i < nums.length && nums[iter] == nums[i]) {
			total += nums[i];
			i++;
		}

		// Return true if including this clump returns true or if not including this
		// clump returns true, false otherwise
		return groupSumClump(i, nums, target - total) || groupSumClump(i, nums, target);
	}
}
