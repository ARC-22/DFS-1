// Time Complexity : O(m*n)
// Space Complexity : O(m*n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No
// add sorce row & col to queue. iterate over till empty and travel in 4 direction for each matrix element.
// if element equal to initial color change it to given color and add it to queue. 
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0 || image[sr][sc] == color){
            return image;
        }
        int m = image.length; // row
        int n = image[0].length; //col
        Queue<Integer> rows = new LinkedList<>();
        Queue<Integer> cols = new LinkedList<>();
        int initColor = image[sr][sc];
        int[][] dirs = {{-1,0}, {1,0}, {0,-1}, {0,1}}; // U D L R
        rows.add(sr);
        cols.add(sc);
        
        image[sr][sc] = color; // imp edge case

        while(!rows.isEmpty()){
            int row = rows.poll();
            int col = cols.poll();

            for(int []dir : dirs){
                int nr = row + dir[0]; 
                int nc = col + dir[1];
                if(nr >=0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == initColor){
                    image[nr][nc] = color;
                    rows.add(nr);
                    cols.add(nc);
                }
            }
        }
        return image;
    }   
}