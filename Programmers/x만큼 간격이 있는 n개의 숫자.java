class Solution {
    public static void main(String[] args) {
        long[] a = solution(1, 5);

        for (long l : a) {
            System.out.println(l);
        }
    }

    public static long[] solution(long x, int n) {
        long[] answer = new long[n];
        long init = x;

        for(int i = 0; i < n; i++) {
            answer[i] = x;
            x += init;
        }
        return answer;
    }
}