import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        int[][] arr1 = new int[][]{{1},{2}};
        int[][] arr2 = new int[][]{{3},{4}};

        System.out.println(Arrays.deepToString(solution(arr1, arr2)));
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {

        System.out.println(arr1.length);
        System.out.println(arr1[1].length);

        int[][] answer = new int[arr1.length][arr2[1].length]; // answer[행][열]
        // 애를 많이 먹었던 부분, arr[2][2] = {{1},{2}} 같은 케이스에도 대응하기 위함
        // arr1.length = 행 길이
        // arr1[1].length = 열 길이

        for(int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr1[0].length; j++) {
                answer[i][j] = arr1[i][j] + arr2[i][j];
            }
        }
        return answer;
    }
}