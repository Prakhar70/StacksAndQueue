package FAQs;

import java.util.Stack;

public class StockSpan {
    public int[] stockSpan(int[] arr, int n) {
        int[] prevGreaterIdx = prevGreaterIdx(arr);
        int[] ans= new int[n];
        for(int i =0;i<n;i++){
            ans[i]=i-prevGreaterIdx[i];
        }
        return ans;
    }
    public int[] prevGreaterIdx(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
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
}
