package integer;

/*

The count-and-say sequence is the sequence of integers with the first five terms as following:

1.     1
2.     11
3.     21
4.     1211
5.     111221
1 is read off as "one 1" or 11.
11 is read off as "two 1s" or 21.
21 is read off as "one 2, then one 1" or 1211.
Given an integer n, generate the nth term of the count-and-say sequence.

Note: Each term of the sequence of integers will be represented as a string.

Example 1:

Input: 1
Output: "1"

Example 2:

Input: 4
Output: "1211"

 */
public class _38_CountAndSay {
	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		return handler(n);
	}

	private String handler(int n) {
		StringBuilder sb = new StringBuilder();
		if (n == 1) {
			return "1";
		} else {
			String prevStr = handler(n - 1);
			int count = 1;
			char temp = prevStr.charAt(0);
			for (int i = 1; i < prevStr.length(); i++) {
				if (temp != prevStr.charAt(i)) {
					sb.append(count).append(temp);
					temp = prevStr.charAt(i);
					count = 1;
				} else {
					count++;
				}
			}
			sb.append(count).append(temp);
			return sb.toString();
		}
	}

	public static void main(String[] args) {
		_38_CountAndSay cs = new _38_CountAndSay();
		for(int i=0;i<10;i++) {
			System.out.println(cs.countAndSay(i));
		}
	}
}
