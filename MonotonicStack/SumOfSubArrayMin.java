package MonotonicStack;
import java.util.Stack;

public class SumOfSubArrayMin {
    private final int MOD = (int)1e9+7;
    public int sumSubarrayMins(int[] arr) {
        int sum =0;
        int n = arr.length;
        int[] nsi = nextSmallerIdx(arr);
        int[] psei = prevSmallerEqIdx(arr);
        for(int i=0;i<n;i++){
            int ele = arr[i];
            int right = nsi[i]-i;
            int left = i-psei[i];
            long freqOfSubArrHavingEle = right * left * 1L;
            int sumOfSubArrHavingEle = (int)((freqOfSubArrHavingEle * ele) % MOD);
            sum = (sum+sumOfSubArrHavingEle)%MOD;
        }
        return sum;
   
    }
    private int[] prevSmallerEqIdx(int[] arr) {
        int n = arr.length;
        int[] ans=new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<n;i++){
            int ele = arr[i];
            while(!st.isEmpty() && arr[st.peek()]>ele){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=-1;
            }else if(arr[st.peek()]<=ele){
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
       
    }
    public int[] nextSmallerIdx(int [] arr){
        int n = arr.length;
        int[] ans=new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            int ele = arr[i];
            while(!st.isEmpty() && arr[st.peek()]>=ele){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i]=n;
            }else if(arr[st.peek()]<ele){
                ans[i]=st.peek();
            }
            st.push(i);
        }
        return ans;
    }
}
