/*
 
Reverse digits of an integer.

Example1: x = 123, return 321
Example2: x = -123, return -321

Note:
The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 
 */
public class _7_ReverseInteger {
	public int reverse(int x) {
        long result = getAns(x);
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
        	return 0;
        }
        return (int) result;
    }
	
	private long getAns(int x) {
		int tx = x;
		long result = 0;
		int pop = 0;
		while(tx >= 10 || tx <= -10) {
			pop = tx % 10;
			result = result * 10 + pop;
			tx = ((int) tx / 10);
		}
		result = result * 10 + tx;
		return result;
	}
	
	public static void main(String[] args) {
		_7_ReverseInteger ri = new _7_ReverseInteger();
		System.out.println(ri.reverse(123));
		System.out.println(ri.reverse(-123));
		System.out.println(ri.reverse(-1000000003));
	}
}
