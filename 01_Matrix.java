// Time Complexity : O(m*n)
// Space Complexity : O(m*n) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
// Initially add 0s to queue, and make other elements to -1
// iterate till queue is empty and fill the -1 with level count in all 4 dircetions.
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if(mat == null || mat.length ==0){
            return mat;
        }       
        int m = mat.length; //row
        int n = mat[0].length; //col
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = {{-1,0},{1,0},{0,-1}, {0,1}}; // U D L R

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mat[i][j] == 0){
                    q.add(new int[] {i, j});
                }
                else{
                    mat[i][j] = -1;
                }
            }
        }
        
        int lvl = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i< size; i++){
                int []curr = q.poll();
                for(int []dir : dirs){
                    int nr = curr[0] + dir[0];
                    int nc = curr[1] + dir[1];
                    if(nr >=0 && nr < m && nc >=0 && nc < n && mat[nr][nc] == -1){
                        mat[nr][nc] = lvl+1;
                        q.add(new int[] {nr, nc});
                    }
                }
            }
            lvl++;
        }
        return mat;
    }
}