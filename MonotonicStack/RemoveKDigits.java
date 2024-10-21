package MonotonicStack;

import java.util.Stack;

public class RemoveKDigits {
    public String removeKdigits(String nums, int k) {
        Stack<Character> st = new Stack<>();
        for (Character ch : nums.toCharArray()) {
            while (!st.isEmpty() && (st.peek() - '0') > (ch - '0') && k > 0) {
                st.pop();
                k--;
            }
            st.push(ch);
        }
        if (st.isEmpty()) {
            return "0";
        }

        while (k > 0) {
            st.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder("");
        while (!st.isEmpty()) {
            ans = ans.append(st.pop());
        }
        ans.reverse();
        int i = 0;
        while (i<ans.length() && ans.charAt(i) == '0') {
            i++;
        }
        if(ans.length() == 0){
            return "0";
        }
        String StrAns = ans.substring(i - 1).toString();
        return StrAns;

    }
}