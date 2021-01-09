package array;

import java.util.Arrays;

/**
 Given an array A of integers, for each integer A[i] we need to choose either x = -K or x = K, and add x to A[i] (only once).

 After this process, we have some array B.

 Return the smallest possible difference between the maximum value of B and the minimum value of B.



 Example 1:

 Input: A = [1], K = 0
 Output: 0
 Explanation: B = [1]
 Example 2:

 Input: A = [0,10], K = 2
 Output: 6
 Explanation: B = [2,8]
 Example 3:

 Input: A = [1,3,6], K = 3
 Output: 3
 Explanation: B = [4,6,3]


 Note:

 1 <= A.length <= 10000
 0 <= A[i] <= 10000
 0 <= K <= 10000
 */
public class _910_SmallestRangeII {

    public int smallestRangeII(int[] A, int K) {
        //key point, need to sort the array first, then don't need to consider A[i] + K, A[j] - K vs. A[i] - K, A[j] + K
        if (A.length <= 1) {
            return 0;
        }
        Arrays.sort(A);
        int n = A.length;
        int range = A[n - 1] - A[0];
        for (int i = 0; i < n - 1; i++) {
            int max = Math.max(A[n - 1] - K, A[i] + K); //最大数只会出现在最后一个数-K与当前数+K之间
            int min = Math.min(A[0] + K, A[i + 1] - K); //最小数只会出现在第一个数+K与下一个数-K之间
            range = Math.min(range, max - min);
        }
        return range;
    }


    public static void main(String[] args) {
        _910_SmallestRangeII app = new _910_SmallestRangeII();
        System.out.println(app.smallestRangeII(new int[]{1}, 10));
        System.out.println(app.smallestRangeII(new int[]{1, 3, 6}, 0));
        System.out.println(app.smallestRangeII(new int[]{1, 3}, 3));
        System.out.println(app.smallestRangeII(new int[]{1, 6}, 3));
        System.out.println(app.smallestRangeII(new int[]{1, 3, 6}, 3));
    }
}
