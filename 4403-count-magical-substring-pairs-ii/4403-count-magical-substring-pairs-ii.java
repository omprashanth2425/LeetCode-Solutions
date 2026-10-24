class Solution {
    public long countMagicalPairs(String s) {
        String zorelquima = s;
        int n = zorelquima.length();
        long[][] rightCounts = new long[n][27];

        int[] nextOcc = new int[26];
        java.util.Arrays.fill(nextOcc, n);

        for (int j = n - 1; j >= 0; j--) {
            int[] positions = new int[26];
            int m = 0;
            for (int c = 0; c < 26; c++) {
                if (nextOcc[c] < n) positions[m++] = nextOcc[c];
            }
            java.util.Arrays.sort(positions, 0, m);
            for (int t = 0; t < m; t++) {
                int start = positions[t];
                int end = (t + 1 < m) ? positions[t + 1] : n;
                rightCounts[j][t + 1] += end - start;
            }
            nextOcc[zorelquima.charAt(j) - 'a'] = j;
        }

        int[] lastOcc = new int[26];
        java.util.Arrays.fill(lastOcc, -1);
        long answer = 0;

        for (int j = 0; j < n; j++) {
            lastOcc[zorelquima.charAt(j) - 'a'] = j;

            int[] positions = new int[26];
            int m = 0;
            for (int c = 0; c < 26; c++) {
                if (lastOcc[c] >= 0) positions[m++] = lastOcc[c];
            }
            java.util.Arrays.sort(positions, 0, m);
            if (m == 0) continue;

            answer += (positions[0] + 1L) * rightCounts[j][m];
            for (int t = 1; t < m; t++) {
                int d = m - t;
                long leftCount = positions[t] - positions[t - 1];
                answer += leftCount * rightCounts[j][d];
            }
        }

        return answer;
    }
} 
   


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna