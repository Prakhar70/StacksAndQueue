package MonotonicStack;

import java.util.Stack;

public class SumOfSubArrayRange {
    public long subArrayRanges(int[] nums) {
        int n = nums.length;
        int[] nextSmallerIdx = nextSmallerIdx(nums);
        int[] nextGreaterIdx = nextGreaterIdx(nums);
        int[] prevSmallerOrEqIdx = prevSmallerOrEqIdx(nums);
        int[] prevGreaterOrEqIdx = prevGreaterOrEqIdx(nums);
        long sum = 0;
        long diff = 0;
        for (int i = 0; i < n; i++) {
            long left_min = i-prevSmallerOrEqIdx[i];
            long right_min = nextSmallerIdx[i]-i;
            long cnt_min = left_min*right_min*1L;
            long val1 = cnt_min*nums[i]*1L;
            diff = diff+val1;

            long left_max = i-prevGreaterOrEqIdx[i];
            long right_max = nextGreaterIdx[i]-i;
            long cnt_max = left_max*right_max*1L;
            long val2 = cnt_max*nums[i]*1L;
            sum =sum+val2;
        }
        return sum-diff;
    }

    private int[] nextSmallerIdx(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    private int[] prevSmallerOrEqIdx(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] > nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    private int[] prevGreaterOrEqIdx(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && nums[st.peek()] < nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

    private int[] nextGreaterIdx(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                st.pop();
            }
            if (st.isEmpty()) {
                ans[i] = n;
            } else {
                ans[i] = st.peek();
            }
            st.push(i);
        }
        return ans;
    }

}
