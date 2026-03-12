import java.util.*;

class Solution {
    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                }else{
                    dist[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];

            for(int i=0;i<4;i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(nr>=0 && nc>=0 && nr<n && nc<m){
                    if(dist[nr][nc] > dist[r][c] + 1){
                        dist[nr][nc] = dist[r][c] + 1;
                        q.offer(new int[]{nr,nc});
                    }
                }
            }
        }

        return dist;
    }
}