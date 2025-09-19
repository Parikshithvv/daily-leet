class Solution {
    public int reversePairs(int[] nums) {
        return mergesort(nums, 0,nums.length-1);
    }

    private int mergesort(int[] arr,int low, int high){
        if(low >= high) return 0;

        int mid = low+(high-low)/2;
        int cnt = 0;

        cnt += mergesort(arr,low,mid);
        cnt += mergesort(arr,mid+1,high);
        cnt += countpairs(arr,low,mid,high);
        merge(arr,low,mid,high);
        return cnt;
    }

    private int countpairs(int[] arr,int low,int mid,int high){
        int right = mid+1;
        int cnt = 0;

        for(int i=low; i<=mid; i++){
            while(right <= high && (long)arr[i] > 2L * arr[right]){
                right++;
            }
            cnt += (right - (mid+1));

        }
        return cnt;
        
    }

    private void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int left = low, right = mid + 1, idx = 0;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[idx++] = arr[left++];
            } else {
                temp[idx++] = arr[right++];
            }
        }
        while (left <= mid) {
            temp[idx++] = arr[left++];
        }
        while (right <= high) {
            temp[idx++] = arr[right++];
        }
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }
    


    }
}