import java.util.Stack;

class Solution {

    // Stack
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < prices.length; i++) {

            while(!stack.isEmpty() && prices[i] < prices[stack.peek()]) {
                int index = stack.pop();
                answer[index] = i - index;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = (prices.length - 1) - index;
        }

        return answer;
    }


    // 완전탐색
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for(int i = 0; i < prices.length; i++) {
            int values = 0;

            for(int j = i + 1; j < prices.length; j++) {
                // 가격이 떨어진 경우
                values++;
                if(prices[i] > prices[j]) {
                    break;
                }
            }

            answer[i] = values;
        }

        return answer;
    }
}

