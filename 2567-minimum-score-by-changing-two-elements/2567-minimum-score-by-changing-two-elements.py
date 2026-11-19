class Solution:
    def minimizeSum(self, nums: List[int]) -> int:
        small = nsmallest(3, nums)
        large = nlargest(3, nums)
        return min(large[0] - small[2], large[1] - small[1], large[2] - small[0])

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna