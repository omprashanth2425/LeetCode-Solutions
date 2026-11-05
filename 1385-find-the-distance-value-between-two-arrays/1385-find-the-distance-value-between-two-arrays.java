class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
           int c = 0;
        for(int n : arr1){
            if(isValid(n, arr2, d)) c++;
        }
        return c;
    }
    boolean isValid(int n, int[] arr, int d){
        for(int e : arr){
            if(Math.abs(e - n) <= d) return false;
        }
        return true;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna