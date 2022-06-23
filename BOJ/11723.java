import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    BOJ 11723 집합
    비어있는 공집합 S가 주어졌을 때, 아래 연산을 수행하는 프로그램을 작성하시오.
    add x: S에 x를 추가한다. (1 ≤ x ≤ 20) S에 x가 이미 있는 경우에는 연산을 무시한다.
    remove x: S에서 x를 제거한다. (1 ≤ x ≤ 20) S에 x가 없는 경우에는 연산을 무시한다.
    check x: S에 x가 있으면 1을, 없으면 0을 출력한다. (1 ≤ x ≤ 20)
    toggle x: S에 x가 있으면 x를 제거하고, 없으면 x를 추가한다. (1 ≤ x ≤ 20)
    all: S를 {1, 2, ..., 20} 으로 바꾼다.
    empty: S를 공집합으로 바꾼다.
*/

class Main {

    static ArrayList<Integer> S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        S = new ArrayList<>();

        int N = Integer.parseInt(br.readLine());

        for(int i = 0; i < N; i++) {
            String[] tmp = br.readLine().split(" ");
            int x = 0;
            String command = tmp[0];

            if(tmp.length == 2) {
                x = Integer.parseInt(tmp[1]);
            }

            switch (command) {
                case "add" : add(x); break;
                case "remove" : remove(x); break;
                case "check" : check(x, sb); break;
                case "toggle" : toggle(x); break;
                case "all" : all(); break;
                case "empty" : empty(); break;
            }
        }

        System.out.println(sb);
    }

    public static void add(int value) {
        for(int i : S) {
            if(i == value) {
                return;
            }
        }

        S.add(value);
    }

    public static void remove(int value) {
        for(int i = 0; i < S.size(); i++) {
            if(S.get(i) == value) {
                S.remove(i);
                return;
            }
        }
    }

    public static void check(int value, StringBuilder sb) {
        for(int i : S) {
            if(i == value) {
                sb.append(1).append("\n");
                return;
            }
        }
        sb.append(0).append("\n");
    }

    public static void toggle(int value) {
        for(int i = 0; i < S.size(); i++) {
            if(S.get(i) == value) {
                S.remove(i);
                return;
            }
        }

        S.add(value);
    }

    public static void all() {
        S.clear();

        for(int i = 1; i <= 20; i++) {
            S.add(i);
        }
    }

    public static void empty() {
        S.clear();
    }
}