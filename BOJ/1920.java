import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    BOJ 1920번 수 찾기
    첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다. 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다. 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
    다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다. 모든 정수의 범위는 -231 보다 크거나 같고 231보다 작다.
 */

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] tmp = br.readLine().split(" ");
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(tmp[i]);
        }

        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());

        tmp = br.readLine().split(" ");
        for(int i = 0; i < m; i++) {
            sb.append(BinarySearch(Integer.parseInt(tmp[i]), arr)).append("\n");
        }

        System.out.println(sb);
    }

    static int BinarySearch(int goal, int[] arr) {
        int low = 0;
        int high = arr.length - 1;

        while(high >= low) {
            int middle = (high + low) / 2;
            if(arr[middle] == goal) {
                return 1;
            } else if(arr[middle] > goal) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }
        }
        return 0;
    }
}