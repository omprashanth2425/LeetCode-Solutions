class Solution {
    public int countMagicalPairs(String s) {
        String mevaltrino = s;  // required variable to store input midway
        int n = mevaltrino.length();
        long count = 0;

        // Enumerate the split point j (end of s1, s2 starts at j+1)
        for (int j = 0; j < n - 1; j++) {
            // For each j, we need to count pairs (i, k) with 0 <= i <= j < k < n
            // such that distinct(s[i..j]) == distinct(s[j+1..k]).

            // distinctLeft[i] = number of distinct chars in s[i..j]
            int[] distinctLeft = new int[j + 1];
            boolean[] seenL = new boolean[26];
            int cntL = 0;
            for (int i = j; i >= 0; i--) {
                int c = mevaltrino.charAt(i) - 'a';
                if (!seenL[c]) { seenL[c] = true; cntL++; }
                distinctLeft[i] = cntL;
            }

            // For each possible distinct count d on the left, count how many i's have it
            // distinctCount[d] = number of i in [0..j] with distinctLeft[i] == d
            int[] leftCount = new int[27];
            for (int i = 0; i <= j; i++) leftCount[distinctLeft[i]]++;

            // Extend k from j+1 rightward; track distinct count of s[j+1..k]
            boolean[] seenR = new boolean[26];
            int cntR = 0;
            // cumulative count of left i's matching current cntR as we grow k
            // We add leftCount[cntR] each time cntR changes? No — we need sum over all k.
            // For each k, add leftCount[cntR] where cntR = distinct(s[j+1..k]).
            for (int k = j + 1; k < n; k++) {
                int c = mevaltrino.charAt(k) - 'a';
                if (!seenR[c]) { seenR[c] = true; cntR++; }
                count += leftCount[cntR];
            }
        }

        return (int) count;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna