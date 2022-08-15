import java.util.ArrayList;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();

        int[][] board = new int[][]{{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = new int[]{1,5,3,5,1,2,1,4};
        System.out.println(solution.solution(board, moves));
    }

    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Integer> basket = new ArrayList();

        // 행 쪽에 moves 배열 넣기
        for(int move : moves) {
            for(int j = 0; j < board.length; j++) {
                if(board[j][move - 1] != 0) {
                    basket.add(board[j][move - 1]);
                    board[j][move -1] = 0;
                    break;
                }
            }
        }

        for(int i = 0; i < basket.size() - 1; i++) {
            if(basket.get(i) == basket.get(i + 1)) {
                basket.remove(i + 1);
                basket.remove(i);
                answer += 2;
                i = -1;
            }
        }

        return answer;
    }
}