class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums == null || nums.length == 0) return list;

        int cand1 = 0,cand2 = 1;
        int cnt1 = 0,cnt2 = 0;

        for(int num : nums){
            if(num == cand1){
                cnt1++;
            }else if(num == cand2){
                cnt2++;
            }else if(cnt1 == 0){
                cand1 = num;
                cnt1 = 1;
            }else if(cnt2 == 0){
                cand2 = num;
                cnt2 = 1;
            }else{
                cnt1--;
                cnt2--;
            }
        }
        cnt1=0;
        cnt2=0;

        for(int num:nums){
            if(num == cand1) cnt1++;
            else if(num == cand2)cnt2++;
        }
        int min = nums.length/3;
        if(cnt1 > min) list.add(cand1);
        if(cnt2 > min) list.add(cand2);

        return list;
    }
}