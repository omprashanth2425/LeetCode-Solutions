class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        long v=0;
        int n=nums.length;
        int start = 0;
        for(int end=0; end<=n;end++){
            if(end==n || nums[end]<minK || nums[end]>maxK){
                long len = end-start;
                v+= len * (len + 1)/2;
                start = end +1;
            }
        }
        return v;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna