class Solution {
    public int minMoves(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int x : nums) {
            max = Math.max(max, x);
            sum += x;
        }
        return max * nums.length - sum;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna