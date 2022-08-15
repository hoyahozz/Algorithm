class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        System.out.println(solution(new int[]{5,5,5,1020}));
    }

    public static double solution(int[] arr) {

        double sum = 0;

        for (int j : arr) {
            sum += j;
        }

        return sum / arr.length;
    }
}

/* in kotlin
    fun solution(arr: IntArray): Double {

        var sum = 0.0
        for(i in arr.indices) {
            sum += arr[i]
        }

        return sum / arr.size
    }

    한 줄로 arr.average() 도 가능
 */