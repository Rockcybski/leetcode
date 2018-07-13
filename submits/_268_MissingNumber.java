/**

 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

 Example 1:

 Input: [3,0,1]
 Output: 2
 Example 2:

 Input: [9,6,4,2,3,5,7,0,1]
 Output: 8

 */

public class _268_MissingNumber {
    public int missingNumber(int[] nums) {
        int l = nums.length;
        int expected_sum = l * (l + 1) / 2;
        int actual_sum = 0;
        for(int i=0;i<l;i++){
            actual_sum += nums[i];
        }
        return expected_sum - actual_sum;
    }
}
