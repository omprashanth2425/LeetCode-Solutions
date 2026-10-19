class Solution {
    public int findColoredRoot(int[][] edges, String colors) {
        int n = colors.length();
        int[] colorldx = new int[n];
        for(int i=0;i<n;i++){
            char c = colors.charAt(i);
            if(c=='R')colorldx[i]=0;
            else if(c=='B')colorldx[i]= 1;
            else colorldx[i]=2;
        }

        int[] inDegree = new int[n];
        int[] degree = new int[n];
        for(int[] edge : edges){
            int u = edge[0],v=edge[1];
            degree[u]++;
            degree[v]++;
            int cu = colorldx[u],cv=colorldx[v];
            boolean uToV = (cv == (cu+1)%3);
            boolean vToU = (cu==(cv+1)%3);
            if(uToV && !vToU){
                inDegree[v]++;
            }
            else if(vToU && !uToV){
                inDegree[u]++;
                
            }else{
                return -1;
            }
        }

        int root=-1;
        for(int i=0;i<n;i++){
            if(inDegree[i]==0){
                if(root!=-1)return -1;
                root =i;
            }
            else if(inDegree[i]!=1){
                return -1;
            }
        }
        if(root==-1)return -1;
        if(degree[root]>2)return -1;
        return root;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna