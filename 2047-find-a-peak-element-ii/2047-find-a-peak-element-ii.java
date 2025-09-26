class Solution {
    public int findmaxindex( int[][] matrix,int n,int m,int col){
        int maxval = -1;
        int index = -1;
        for(int i=0;i<n;i++){
            if(matrix[i][col] > maxval){
            maxval = matrix[i][col];
            index = i;
            }
        }
        return index;
    }

    public int[] findPeakGrid(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int low = 0, high = m-1;
        while(low <= high){
            int mid = low+(high-low)/2;
            int max = findmaxindex(matrix,n,m,mid);
            int left = mid-1 >= 0 ? matrix[max][mid-1] : -1;
            int right = mid+1 < m ? matrix[max][mid+1] : -1;
            if(matrix[max][mid] > left && matrix[max][mid] > right){
                return new int[] {max,mid};
            }else if(matrix[max][mid] < left){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }
        return new int[] {-1,-1};
    }
}