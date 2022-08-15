import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    BOJ 10828 스택
    정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

    명령은 총 다섯 가지이다.

    push X: 정수 X를 스택에 넣는 연산이다.
    pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
    size: 스택에 들어있는 정수의 개수를 출력한다.
    empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
    top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
 */

class Main {
    public static void main(String[] args) throws IOException {
        // 테스트 코드
        System.out.println(solution());
    }

    public static String solution() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        ArrayList<Integer> stack = new ArrayList<Integer>();

        for(int i = 0; i < count; i++) {
            String command = br.readLine();

            if(command.contains("push")) {
                int value = 0;
                StringTokenizer st = new StringTokenizer(command, " ");
                if(st.hasMoreTokens()) {
                    st.nextToken();
                    value = Integer.parseInt(st.nextToken());
                }
                push(stack, value);
            }
            if(command.equals("top")) {
                sb.append(top(stack)).append("\n");
            }
            if(command.equals("pop")) {
                sb.append(pop(stack)).append("\n");
            }
            if(command.equals("size")) {
                sb.append(size(stack)).append("\n");
            }
            if(command.equals("empty")) {
                sb.append(empty(stack)).append("\n");
            }

        }

        return sb.toString();
    }

    public static void push(ArrayList<Integer> stack, int value) {
        stack.add(value);
    }

    public static int pop(ArrayList<Integer> stack) {
        int pop = stack.size() != 0 ? stack.get(stack.size() - 1) : -1;
        if (pop != -1) stack.remove(stack.size() - 1);
        return pop;
    }

    public static int size(ArrayList<Integer> stack) {
        return stack.size();
    }

    public static int empty(ArrayList<Integer> stack) {
        return stack.size() > 0 ? 0 : 1;
    }

    public static int top(ArrayList<Integer> stack) {
        return stack.size() > 0 ? stack.get(stack.size() - 1) : -1;
    }
}