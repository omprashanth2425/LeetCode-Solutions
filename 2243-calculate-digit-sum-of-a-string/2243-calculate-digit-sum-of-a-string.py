class Solution:
    def digitSum(self, s: str, k: int) -> str:
        while len(s) > k:
            s = ''.join(str(sum(map(int, g))) for g in batched(s, k))
        return s

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna