package FAQs;

import java.util.Stack;
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] prevSmallerIdx = prevSmallerIdx(heights);
        int[] nextSmallerIdx = nextSmallerIdx(heights);
        int maxHeight = 0;
        for(int i=0;i<n;i++){
            int length = nextSmallerIdx[i] - prevSmallerIdx[i]-1;
            maxHeight = Math.max(maxHeight, length*heights[i]);
        }
        return maxHeight;
    }
    public int[] prevSmallerIdx(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
    public int[] nextSmallerIdx(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=n;
            }else{
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}
