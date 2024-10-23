package FAQs;

import java.util.*;
public class CelebrityProblem {
    public int celebrity(int[][] M) {
        int n = M.length;
        
        if(n==1){
            return 0;
        }
        
        Stack<Integer> st = new Stack<>();
        
        for(int i=0;i<n;i++){
            st.push(i);
        }

        while(st.size()>1){
            int x = st.pop();
            int y = st.pop();
            if(M[x][y]==1){
                st.push(y);
            }else{
                st.push(x);
            }
        }
        int pot_ans = st.pop();
        for( int i=0;i<n;i++){
            if(M[pot_ans][i] == 1){
                return -1;
            }
        }
        for(int j=0;j<n;j++){
            if(pot_ans != j && M[j][pot_ans] == 0){
                return -1;
            }
        }
        return pot_ans;
    }
}
