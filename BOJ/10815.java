import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    BOJ 10815 숫자 카드
    숫자 카드는 정수 하나가 적혀져 있는 카드이다.
    상근이는 숫자 카드 N개를 가지고 있다. 정수 M개가 주어졌을 때, 이 수가 적혀있는 숫자 카드를 상근이가 가지고 있는지 아닌지를 구하는 프로그램을 작성하시오.
 */

class Main {

    static int[] myCards;
    static int[] cards;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        String[] tmp = br.readLine().split(" ");
        myCards = new int[N];

        for(int i = 0; i < N; i++) {
            myCards[i] = Integer.parseInt(tmp[i]);
        }

        int M = Integer.parseInt(br.readLine());
        tmp = br.readLine().split(" ");
        cards =  new int[M];

        for(int i = 0; i < M; i++) {
            cards[i] = Integer.parseInt(tmp[i]);
        }

        Arrays.sort(myCards);

        for(int i = 0; i < M; i++) {
            int turn = cards[i];
            if(binarySearch(turn)) {
                sb.append(1).append(" ");
            } else {
                sb.append(0).append(" ");
            };
        }
        System.out.println(sb);
    }

    public static boolean binarySearch(int goal) {
        int low = 0;
        int high = myCards.length - 1;

        while(high >= low) {
            int middle = (low + high) / 2;

            if(myCards[middle] == goal) {
                return true;
            } else if(goal > myCards[middle]) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }

        return false;
    }
}