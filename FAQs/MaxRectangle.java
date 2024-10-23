package FAQs;
import java.util.Stack;



public class MaxRectangle {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int max = 0;
        int[] count = new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    count[j]++;
                }else{
                    count[j]=0;
                }
            }
            
            max=Math.max(max, largestRectangleArea(count));
        }
        return max;
        
    }
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
