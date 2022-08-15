import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    BOJ 11652 카드
    준규는 숫자 카드 N장을 가지고 있다. 숫자 카드에는 정수가 하나 적혀있는데, 적혀있는 수는 -2^62보다 크거나 같고, 2^62보다 작거나 같다.
    준규가 가지고 있는 카드가 주어졌을 때, 가장 많이 가지고 있는 정수를 구하는 프로그램을 작성하시오. 만약, 가장 많이 가지고 있는 정수가 여러 가지라면, 작은 것을 출력한다.
 */

class Main {
    public static void main(String[] args) throws IOException {
        // 테스트 코드
        System.out.println(solution());
    }

    public static String solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        long[] arr = new long[n];
        HashMap<Long, Long> hm = new HashMap<>();

        for(int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
            hm.put(arr[i], 0L);
        }

        for(long j : arr) {
            if(hm.containsKey(j)) {
                long count = hm.get(j);
                hm.put(j, count+1);
            }
        }

        List<Map.Entry<Long, Long>> answerList = new LinkedList<>(hm.entrySet());
        answerList.sort(Map.Entry.comparingByKey());
        answerList.sort(Map.Entry.<Long, Long>comparingByValue().reversed());

        sb.append(answerList.get(0).getKey());

        return sb.toString();
    }
}