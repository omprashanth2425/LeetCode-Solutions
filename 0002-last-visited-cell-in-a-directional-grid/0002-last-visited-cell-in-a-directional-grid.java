class Solution {
    public int[] lastVisitedCell(char[][] grid) {
       int m = grid.length;
        int n= grid[0].length;
        boolean[][] visited  = new boolean[m][n];
        
        int r=0,c=0;
        visited[r][c]=true;
        while(true){
            int nr =r,nc=c;
            char dir = grid[r][c];

            if(dir=='L') nc =c-1;
            else if(dir =='R')nc=c+1;
            else if(dir=='U')nr=r-1;
            else if (dir=='D')nr=r+1;

            if(nr<0 || nr>=m || nc<0|| nc>=n|| visited[nr][nc]){
                break;
            }
            r=nr;
            c=nc;
            visited[r][c]=true;
        }
        return new int[]{r,c};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna