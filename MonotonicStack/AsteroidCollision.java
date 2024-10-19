package MonotonicStack;
import java.util.Stack;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        
        for(int ele:asteroids){
            if(ele>0){
                st.push(ele);
            }
            else{
                while(!st.isEmpty() && st.peek()>0 && st.peek() < Math.abs(ele)){
                    st.pop();
                }
                if(st.isEmpty()){
                    st.push(ele);
                }else if(st.peek() >0 && st.peek() == Math.abs(ele)){
                    st.pop();
                }
            }
        }
        

        int[] ans=new int[st.size()];
        int n = ans.length;
        int i = n-1;

        while(!st.isEmpty()){
            ans[i]=st.pop();
            i--;
        }
        return ans;
        
    }
}
