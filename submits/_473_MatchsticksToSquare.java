import java.util.Arrays;

/*
 @leetcode
Remember the story of Little Match Girl? By now, you know exactly what matchsticks the little match girl has, please find out a way you can make one square by using up all those matchsticks. You should not break any stick, but you can link them up, and each matchstick must be used exactly one time.

Your input will be several matchsticks the girl has, represented with their stick length. Your output will either be true or false, to represent whether you could make one square using all the matchsticks the little match girl has.

Example 1:
Input: [1,1,2,2,2]
Output: true

Explanation: You can form a square with length 2, one side of the square came two sticks with length 1.
Example 2:
Input: [3,3,3,3,4]
Output: false

Explanation: You cannot find a way to form a square with all the matchsticks.
Note:
The length sum of the given matchsticks is in the range of 0 to 10^9.
The length of the given matchstick array will not exceed 15
 */
public class _473_MatchsticksToSquare {
	public boolean makesquare(int[] nums) {
		Arrays.sort(nums);
		if (nums == null || nums.length < 4) {
			return false;
		}
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if (sum <= 3) {
			return false;
		}
		if (sum % 4 != 0) {
			return false;
		}
		int avg = sum / 4;
		int[] sqs = new int[] { 0, 0, 0, 0 };
		return dfs(nums, sqs, nums.length-1, avg);
		
//wrong answer for case like 5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3
//		boolean put = false;
//		for (int j = nums.length - 1; j >= 0; j--) {
//			put = false;
//			for (int k = 0; k < 4; k++) {
//				if (sq[k] == avg) {
//					continue;
//				}
//				if (sq[k] + nums[j] <= avg) {
//					sq[k] = sq[k] + nums[j];
//					put = true;
//					break;
//				}
//			}
//			if (!put)
//				return false;
//		}
//		return true;
	}
	
	private boolean dfs(int[] nums, int[] sqs, int index, int target) {
		if(index == -1) {
			if(sqs[0] == target && sqs[1] == target && sqs[2] == target && sqs[3] == target) {
				return true;
			}
			return false;
		}
		for(int i=0;i<4;i++) {
			if(sqs[i] + nums[index] > target) {
				continue;
			}
			sqs[i]+=nums[index];
			if(dfs(nums, sqs, index-1, target)) {
				return true;
			}
			sqs[i]-=nums[index];
		}
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println(new _473_MatchsticksToSquare().makesquare(new int[] {5, 5, 5, 5, 4, 4, 4, 4, 3, 3, 3, 3}));
	}
}
