class Solution {
    
    public int countStudents(int[] nums, int pages) {
        int students = 1;     
        long pagesStudent = 0; 
        for (int num : nums) {
            if (pagesStudent + num <= pages) {
                pagesStudent += num;   
            } else {
                students++;           
                pagesStudent = num;    
            }
        }
        return students;
    }

    public int splitArray(int[] nums, int m) {
        int n = nums.length;

        if (m > n) return -1; 

       
        int low = Arrays.stream(nums).max().getAsInt(); 
        int high = Arrays.stream(nums).sum();           

        while (low <= high) {
            int mid = (low + high) / 2;
            int students = countStudents(nums, mid);

            if (students > m) {
                low = mid + 1; 
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
