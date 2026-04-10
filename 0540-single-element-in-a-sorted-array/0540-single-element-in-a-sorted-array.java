class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;

        int low = 0;
        int high = n - 1;
    

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (mid % 2 == 0 && nums[mid] == nums[mid + 1]){
                low = mid + 2;
            }
            else if (mid % 2 == 0 && nums[mid] != nums[mid + 1]){
                high = mid;
            }
            else if(mid % 2 != 0 && nums[mid] == nums[mid-1]){
                low = mid +1;
            }else{
                high = mid;
            }
        }
        return nums[low];

    }
}