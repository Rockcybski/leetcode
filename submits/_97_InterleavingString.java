/*
 * leetcode 97
//TODO TLE method (time limit...)
Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

 */
public class _97_InterleavingString {
	public boolean isInterleave(String s1, String s2, String s3) {
		if (s3 == null)
			return false;
		if (s1 == null)
			return s3.equals(s2);
		if (s2 == null)
			return s3.equals(s1);
		if ((s1.length() + s2.length()) != s3.length())
			return false;
		char[] cs1 = s1.toCharArray();
		char[] cs2 = s2.toCharArray();
		char[] cs3 = s3.toCharArray();
		int i = 0, j = 0, k = 0;
		return helper(cs1, cs2, cs3, i, j, k);
	}

	private boolean helper(char[] cs1, char[] cs2, char[] cs3, int i, int j, int k) {
		if (i == cs1.length) {
			return new String(cs2, j, cs2.length - j).equals(new String(cs3, k, cs3.length - k));
		}
		if (j == cs2.length) {
			return new String(cs1, i, cs1.length - i).equals(new String(cs3, k, cs3.length - k));
		}
		
		if((cs1[i] == cs3[k] && helper(cs1, cs2, cs3, i+1, j, k+1)) || (cs2[j] == cs3[k] && helper(cs1, cs2, cs3, i, j+1, k+1))) {
			return true;
		}
//		if (cs1[i] == cs3[k] && cs2[j] == cs3[k]) {
//			if (helper(cs1, cs2, cs3, i + 1, j, k + 1)) {
//				return true;
//			} else {
//				return helper(cs1, cs2, cs3, i, j + 1, k + 1);
//			}
//		} else if (cs1[i] == cs3[k]) {
//			return helper(cs1, cs2, cs3, i + 1, j, k + 1);
//		} else if (cs2[j] == cs3[k]) {
//			return helper(cs1, cs2, cs3, i, j + 1, k + 1);
//		}
		return false;
	}
	
	public static void main(String[] args) {
		_97_InterleavingString is = new _97_InterleavingString();
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(is.isInterleave(s1, s2, s3));
		s3 = "aadbbbaccc";
		System.out.println(is.isInterleave(s1, s2, s3));
		s1 = "aax";
		s2 = "abx";
		s3 = "aabxax";
		System.out.println(is.isInterleave(s1, s2, s3));
	}
}
