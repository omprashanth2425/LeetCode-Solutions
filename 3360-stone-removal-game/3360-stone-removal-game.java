class Solution {
    public boolean canAliceWin(int n) {
        int t = 0;
        int pile = 10;

        while (n >= pile) {
            n -= pile--;
            t ^= 1;
        }

        return (t & 1) == 1;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna