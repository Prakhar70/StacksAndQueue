package FAQs;

import java.util.Deque;
import java.util.LinkedList;

public class SlidingWindow {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int n = arr.length;
        int[] ans = new int[n - k + 1];
        int w=0;
        Deque<Integer> ds = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            while(!ds.isEmpty() && arr[i] > arr[ds.peekLast()]){
                ds.removeLast();
            }
            ds.addLast(i);
            if(i>=k-1){
                if(ds.peekFirst()<=i-k){
                    ds.removeFirst();
                }
                ans[w++]=arr[ds.peekFirst()];
            }
        }
        return ans;
    }
}
