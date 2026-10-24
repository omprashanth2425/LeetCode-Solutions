class Solution {
    public int peakValleyDifference(int[] nums) {
        int ps=0,vs=0;
        for(int i=1; i<nums.length-1;i++){
            if(nums[i]>nums[i-1] && nums[i]>nums[i+1]){
                ps+=nums[i];
            }
            else if (nums[i]<nums[i-1] && nums[i]<nums[i+1]){
                vs+=nums[i];
            }
        }
        return ps-vs;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna