package FAQs;

public class TrappingRainWater {
    public int trap(int[] height) {
        int water = 0;
        int n = height.length;
        int maxAhead[] = new int[n];
        int maxi = 0;
        for (int i = n - 1; i >= 0; i--) {
            maxAhead[i] = maxi;
            maxi = Math.max(maxi, height[i]);
        }
        
        maxi = 0;
        for (int i = 0; i < n; i++) {
            int leftMax = maxi;
            int rightMax = maxAhead[i];
            int min = Math.min(leftMax, rightMax);
            if(min>height[i]){
                water+=min-height[i];
            }
            maxi = Math.max(maxi, height[i]);
        }
        return water;
    }
}
