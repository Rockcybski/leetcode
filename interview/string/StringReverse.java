package string;

import java.util.Stack;

/**
 * 给定一个英文句子，将单词反转 （对于头尾空格，单词中间间隔的空格保留，有不同的解决）
 * example
 * input: "I have a dream"
 * output: "dream a have I"
 */
public class StringReverse {

    private static final String EMPTY = "";
    private static final String BLANK = " ";

    private String reverseString(String s) {
        reverseString1(s);
        reverseString2(s);
        return reverseString3(s);
    }

    /**
     * 这种方法去除了头尾的空格，并且单词中间的空格只保留一个
     *
     * @param s input string
     * @return reversed string
     */
    private String reverseString1(String s) {
        if (s == null) {
            return EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            String c = String.valueOf(s.charAt(i));
            if (BLANK.equals(c)) {
                if (!stack.empty()) {//遇到第一个空字符，将栈中现有字符转移到输出，每次append时会在最后加一个空字符，在最后删除
                    appendWithBlankAtEnd(stack, sb);
                }
                //空字符不压入栈
                continue;
            }
            stack.push(c);//非空字符压入栈
        }
        if (!stack.empty()) {//输出最后一个单词，句子开头可不为空，首词并未在循环中输出
            appendWithBlankAtEnd(stack, sb);
        }
        if (sb.length() > 0) {//删除句尾空字符， 注意存在输出为空的情况，需判断
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    /**
     * 将栈中字符依次append到StringBuilder中, 并添加空格
     */
    private void appendWithBlankAtEnd(Stack<String> stack, StringBuilder sb) {
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        sb.append(BLANK);
    }

    /**
     * 保留所有空格
     * tips: reverseString2(reverseString2(s)) = s
     *
     * @param s input string
     * @return reversed string
     */
    private String reverseString2(String s) {
        if (s == null) {
            return EMPTY;
        }
        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();
        int len = s.length();
        for (int i = len - 1; i >= 0; i--) {
            String c = String.valueOf(s.charAt(i));
            if (BLANK.equals(c)) {//遇到空格时，先检查栈中是否有字符，有则先将栈中数据输出，然后输出空格
                if (!stack.empty()) {
                    append(stack, sb);
                }
                sb.append(c);
            } else {//遇到字符时，将字符压入栈中
                stack.push(c);
            }
        }
        if (!stack.empty()) {//循环完成后检查栈，如有未输出字符，将其输出
            append(stack, sb);
        }
        return sb.toString();
    }

    /**
     * 将栈中字符依次append到StringBuilder中
     */
    private void append(Stack<String> stack, StringBuilder sb) {
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
    }


    /**
     * 通过reverse char数组来反转string
     */
    private String reverseString3(String s) {
        if (s == null) {
            return EMPTY;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int n = chars.length;
        reverse(chars, start, n - 1); //首先将整个数组反转
        for (int i = 0; i < n; i++) {
            if (chars[i] == ' ') {//依次反转各个单词
                reverse(chars, start, i - 1);
                start = i + 1;
            }
        }
        if (start != n) {//句尾不是' '时，将最后一个未被反转的单词反转
            reverse(chars, start, n - 1);
        }
        return new String(chars);
    }

    /**
     * 反转数组指定区间
     */
    private void reverse(char[] chars, int start, int end) {
        if (end <= start) {//end < start, invalid scenario; end = start, not necessary to reverse
            return;
        }
        int mid = (start + end) / 2;
        char temp;
        for (int i = start; i <= mid; i++) {
            temp = chars[i];
            chars[i] = chars[end - i + start];
            chars[end - i + start] = temp;
        }
    }

    private static void print(String s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        StringReverse stringReverse = new StringReverse();
        print(stringReverse.reverseString(null));
        print(stringReverse.reverseString(" "));
        print(stringReverse.reverseString("   "));
        print(stringReverse.reverseString("hello"));
        print(stringReverse.reverseString(" I have a dream"));
        print(stringReverse.reverseString("I have a dream "));
        print(stringReverse.reverseString("  I     have  a  dream  "));
    }
}
