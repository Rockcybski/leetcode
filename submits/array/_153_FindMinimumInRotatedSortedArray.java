package array;

/*
Suppose an array of length n sorted in ascending order is rotated between 1 and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:

[4,5,6,7,0,1,2] if it was rotated 4 times.
[0,1,2,4,5,6,7] if it was rotated 7 times.
Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].

Given the sorted rotated array nums, return the minimum element of this array.



Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 11
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.


Constraints:

n == nums.length
1 <= n <= 5000
-5000 <= nums[i] <= 5000
All the integers of nums are unique.
nums is sorted and rotated between 1 and n times.
 */
public class _153_FindMinimumInRotatedSortedArray {

    /**
     * 递归方法
     */
    public int findMin(int[] nums) {
        return findMin(nums, 0, nums.length - 1);
    }

    private int findMin(int[] nums, int start, int end) {
        if (nums[start] <= nums[end]) {
            return nums[start];
        }
        if (end - start == 1) {
            return nums[end];
        }
        int mid = (start + end) / 2;
        if (nums[mid] > nums[end]) {
            return findMin(nums, mid, end);
        } else {
            return findMin(nums, start, mid);
        }
    }

    /**
     * 循环方法
     * 使用2个指针，来实现二分法查找
     */
    public int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        /**快速处理第一位就是最小数的情况**/
        if (nums[left] < nums[right]) {
            return nums[left];
        }
        /**/
        while (left < right) {
            int mid = (left + right) / 2;
            /**快速处理中间值时最小数的情况**/
            if (nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }
            if (nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
             /**/
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums = {5};
        System.out.println(new _153_FindMinimumInRotatedSortedArray().findMin2(nums));
    }

}
