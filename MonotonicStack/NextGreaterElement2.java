package MonotonicStack;
import java.util.Stack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] arr) {
        int n = arr.length;
        
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            st.push(arr[i]);
        }
        int[] output = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            while(!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            output[i] = st.isEmpty()?-1:st.peek();
            st.push(arr[i]);
        }
        return output;
    }
}
