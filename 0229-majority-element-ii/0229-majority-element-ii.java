class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int n = nums.length;

        if(n < 3) {
            for (int num : nums) { // foreach loop -> for(int i: nums)
                if (!list.contains(num)) list.add(num);
            }
            return list;
        } 

        int min = n/3;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i: nums) {
            map.put(i, map.getOrDefault(i, 0) + 1); // frequencey
        }

        
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            if (e.getValue() > min) {
                list.add(e.getKey()); 
            }
        }

        return list;
    }
}