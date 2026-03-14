class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int []temp1 = new int[n];
        
        Stack<Integer> s= new Stack<>();
        for( int i=0;i<n;i++){
            while(!s.isEmpty() && temperatures[i] >temperatures[s.peek()]){
                int index = s.pop();
                temp1[index] = i - index;
            }
            s.push(i);
    }
    return temp1;
    }
}