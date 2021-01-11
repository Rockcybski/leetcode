package string;

import java.util.Stack;

/**
 Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

 Note that after backspacing an empty text, the text will continue empty.

 Example 1:

 Input: S = "ab#c", T = "ad#c"
 Output: true
 Explanation: Both S and T become "ac".
 Example 2:

 Input: S = "ab##", T = "c#d#"
 Output: true
 Explanation: Both S and T become "".
 Example 3:

 Input: S = "a##c", T = "#a#c"
 Output: true
 Explanation: Both S and T become "c".
 Example 4:

 Input: S = "a#c", T = "b"
 Output: false
 Explanation: S becomes "c" while T becomes "b".
 Note:

 1 <= S.length <= 200
 1 <= T.length <= 200
 S and T only contain lowercase letters and '#' characters.
 Follow up:

 Can you solve it in O(N) time and O(1) space?
 */
public class _844_BackspaceStringCompare {

    /**
     * 也可以用StringBuilder
     */
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stackS = new Stack<>();
        Stack<Character> stackT = new Stack<>();
        buildStack(stackS, S);
        buildStack(stackT, T);
        while (!stackS.empty() && !stackT.empty()) {
            if (stackS.pop() != stackT.pop()) {
                return false;
            }
        }
        if (stackS.empty() && stackT.empty()) {
            return true;
        }
        return false;
    }

    private void buildStack(Stack<Character> stack, String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#' && !stack.empty()) {
                stack.pop();
            }
            if (s.charAt(i) != '#') {
                stack.push(s.charAt(i));
            }
        }
    }

    /**
     * O(N) time and O(1)
     * 从后往前读取，用一个变量back记录需要跳过（删除的字符）
     */
    private boolean backspaceCompare2(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1, back;

        while (true) {
            back = 0;
            //如果back > 0, 当前读到字符将被跳过
            //如果为#， back++
            while (i >= 0 && (back > 0 || S.charAt(i) == '#')) {
                back += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }

            back = 0;
            while (j >= 0 && (back > 0 || T.charAt(j) == '#')) {
                back += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }

            //比较S 和 T 当前字符
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--;
                j--;
            } else {
                break;
            }
        }
        return i == -1 && j == -1;
    }
}
