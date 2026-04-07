class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        Set<String> st = new HashSet<>(wordList);
        if (!st.contains(endWord)) return 0;

        int steps = 1;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int s = 0; s < size; s++) {
                String word = q.poll();
                if (word.equals(endWord)) return steps;

                char[] arr = word.toCharArray();
                for (int i = 0; i < arr.length; i++) {
                    char original = arr[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        arr[i] = ch;
                        String newWord = new String(arr);
                        if (st.contains(newWord)) {
                            q.add(newWord);
                            st.remove(newWord);
                        }
                    }
                    arr[i] = original;
                }
            }
            steps++;
        }
        return 0;
    }
}