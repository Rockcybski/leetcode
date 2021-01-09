package string;

/**
 Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

 A string is represented by an array if the array elements concatenated in order forms the string.



 Example 1:

 Input: word1 = ["ab", "c"], word2 = ["a", "bc"]
 Output: true
 Explanation:
 word1 represents string "ab" + "c" -> "abc"
 word2 represents string "a" + "bc" -> "abc"
 The strings are the same, so return true.
 Example 2:

 Input: word1 = ["a", "cb"], word2 = ["ab", "c"]
 Output: false
 Example 3:

 Input: word1  = ["abc", "d", "defg"], word2 = ["abcddefg"]
 Output: true


 Constraints:

 1 <= word1.length, word2.length <= 103
 1 <= word1[i].length, word2[i].length <= 103
 1 <= sum(word1[i].length), sum(word2[i].length) <= 103
 word1[i] and word2[i] consist of lowercase letters.
 */
public class _1662_CheckIfTwoStringArraysAreEquivalent {

    /**
     * 通过4个指针来对每一个字符进行比较
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int w1 = 0, w2 = 0, c1 = 0, c2 = 0;
        while (w1 < word1.length && w2 < word2.length) {
            if (word1[w1].charAt(c1) != word2[w2].charAt(c2)) {
                return false;
            }
            c1++;
            c2++;
            if (c1 == word1[w1].length()) {
                w1++;
                c1 = 0;
            }
            if (c2 == word2[w2].length()) {
                w2++;
                c2 = 0;
            }
        }
        return w1 == word1.length && w2 == word2.length;
    }

    /**
     * Direct approach, but use more space
     */
    private boolean arrayStringsAreEqual2(String[] word1, String[] word2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            sb1.append(word1[i]);
        }
        for (int j = 0; j < word2.length; j++) {
            sb2.append(word2[j]);
        }
        return sb1.toString().equals(sb2.toString());
    }
}
