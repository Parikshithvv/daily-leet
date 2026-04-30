class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<operations.length;i++){
            String s = operations[i];

            if(s.equals("+")){
                int top = st.pop();
                int newscore = top + st.peek();
                st.push(top);
                st.push(newscore);
            }
            else if(s.equals("D")){
                st.push(st.peek() * 2);


            }else if(s.equals("C")){
                st.pop();

            }else{
                st.push(Integer.parseInt(s));
            }
    
            }
            int totalsum = 0;
            for(int score : st){
                totalsum += score;
            }

        return totalsum;
        
    }
}