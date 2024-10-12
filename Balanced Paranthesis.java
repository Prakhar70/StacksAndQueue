import java.util.Stack;

class Solution {
    public boolean isValid(String str) {
        Stack<Character> st = new Stack<>();
        for(char ch:str.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }else{
                if(ch == ')' && st.peek() != '('){
                    return false;
                }
                else if(ch == '}' && st.peek() != '{'){
                    return false;
                }
                else if(ch == ']' && st.peek() != '['){
                    return false;
                }
                st.pop();
            }
        }
        return st.isEmpty();
    }
}