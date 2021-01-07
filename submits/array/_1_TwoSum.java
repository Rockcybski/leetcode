package array;

import java.util.HashMap;
import java.util.Map;

/*

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 */
public class _1_TwoSum {
	public int[] twoSum(int[] nums, int target) throws IllegalArgumentException {
		Map<Integer, Integer> answer2IndexMap = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(answer2IndexMap.containsKey(nums[i])) {
				return new int[] {answer2IndexMap.get(nums[i]), i};
			}
			answer2IndexMap.put(target - nums[i], i);
		}
		throw new IllegalArgumentException("No answer");
	}
	
	public static void main(String[] args) {
		int[] nums = {3, 2, 4};
		int[] x = null;
		try {
			x = new _1_TwoSum().twoSum(nums, 6);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(x);
	}
}
