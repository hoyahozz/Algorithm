import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    BOJ 1475 방 번호
    다솜이는 은진이의 옆집에 새로 이사왔다.
    다솜이는 자기 방 번호를 예쁜 플라스틱 숫자로 문에 붙이려고 한다.
    다솜이의 옆집에서는 플라스틱 숫자를 한 세트로 판다.
    한 세트에는 0번부터 9번까지 숫자가 하나씩 들어있다.
    다솜이의 방 번호가 주어졌을 때, 필요한 세트의 개수의 최솟값을 출력하시오.
    (6은 9를 뒤집어서 이용할 수 있고, 9는 6을 뒤집어서 이용할 수 있다.)
*/

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] tmp = br.readLine().split("");

        int[] counts = new int[10];

        int answer = 0;
        for (int i = 0; i < tmp.length; i++) {
            int value = Integer.parseInt(tmp[i]);
            counts[value]++;
        }

        int sixCount = counts[6] + counts[9];

        if (sixCount % 2 != 0) {
            sixCount = (sixCount / 2) + 1;
        } else {
            sixCount /= 2;
        }

        counts[6] = sixCount;
        counts[9] = sixCount;

        for (int i = 0; i < 10; i++) {
            if (answer < counts[i]) {
                answer = counts[i];
            }
        }

        sb.append(answer);

        System.out.println(sb);
    }
}