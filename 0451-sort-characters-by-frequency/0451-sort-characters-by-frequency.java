class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (freq.containsKey(c)) {
                freq.put(c, freq.get(c) + 1);
            } else {
                freq.put(c, 1);
            }
        }
        int n = s.length();
        List<List<Character>> buckets = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            buckets.add(new ArrayList<Character>());
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            char ch = entry.getKey();
            int count = entry.getValue();
            buckets.get(count).add(ch);
        }
        StringBuilder res = new StringBuilder();
        for (int i = n; i > 0; i--) {
            List<Character> bucket = buckets.get(i);
            for (int j = 0; j < bucket.size(); j++) {
                char ch = bucket.get(j);
                for (int k = 0; k < i; k++) {
                    res.append(ch);
                }
            }
        }
        return res.toString();
    }
}
