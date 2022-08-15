import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        System.out.println(Arrays.toString(solution(3, 19)));
    }

    public static int[] solution(int n, int m) {
        int[] answer;
        int gcd = 0;
        int lcm;
        int initN = n;
        int initM = m;

        // 최대공약수
        int count = 1;
        do {
            if (initN % count == 0 && initM % count == 0) { // 둘 모두 나눴을 때 나머지가 없는 경우
                gcd = count; // 초기에는 1이니까 1은 기본 세팅
            }

            count++;

        } while (count <= initM || count <= initN); // 카운트가 M,N보다 작거나 같을 때까지만 (하나라도 넘어서게 되면 의미가 없으니까!)

        // 최소공배수
        while (true) {
            if (initN > initM) { // N이 M보다 커지면 M도 더해주기
                initM += m;
            } else if (initN < initM) {
                initN += n;
            } else { // 같아지면 최소공배수라는 의미
                lcm = initM;
                break;
            }
        }

        answer = new int[]{gcd, lcm};
        return answer;
    }
}

/* in kotlin
fun solution(n : Int, m : Int): IntArray {

    var gcd = 0
    val lcm : Int
    var initN = n
    var initM = m

    var count = 1
    do {
        if(initN % count == 0 && initM % count == 0) {
            gcd = count
        }

        count++
    } while(count <= initN || count <= initM)

    while(true) {
        if(initN < initM) {
            initN += n
        } else if(initN > initM) {
            initM += m
        } else {
            lcm = initN
            break
        }
    }

    return intArrayOf(gcd,lcm)
}
 */