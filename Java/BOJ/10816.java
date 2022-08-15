import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    BOJ 10816 숫자 카드 2
    숫자 카드는 정수 하나가 적혀져 있는 카드이다.
    상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 몇 개 가지고 있는지 구하는 프로그램을 작성하시오.
 */

class Main {

    static int[] card;
    static int[] user;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        String[] temp = br.readLine().split(" ");

        card = new int[n];

        for (int i = 0; i < n; i++) {
            card[i] = Integer.parseInt(temp[i]);
        }

        Arrays.sort(card);

        int M = Integer.parseInt(br.readLine());
        temp = br.readLine().split(" ");
        user = new int[M];

        for (int i = 0; i < M; i++) {
            user[i] = Integer.parseInt(temp[i]);
        }

        answer = new int[user.length];

        for(int i = 0; i < M; i++) {
            answer[i] = UpperBound(user[i]) - LowerBound(user[i]);
            sb.append(answer[i]).append(" ");
        }

        System.out.println(sb);
    }

    static int LowerBound(int goal) {
        int left = 0;
        int right = card.length;

        while(left < right) {
            int middle = (left + right) / 2;

            if(goal <= card[middle]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }

    static int UpperBound(int goal) {
        int left = 0;
        int right = card.length;

        while(left < right) {
            int middle = (left + right) / 2;

            if(goal < card[middle]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return left;
    }
}

