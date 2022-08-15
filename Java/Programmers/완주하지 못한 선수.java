import java.util.*;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();
        System.out.println(solution.solution(new String[]{"leo", "kiki", "eden", "hoya", "kiki"}, new String[]{"eden", "leo", "kiki", "hoya"}));
    }

    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> map = new HashMap<>();

        for (String i : participant) {
            map.put(i, map.getOrDefault(i, 0) + 1); // 중복 제거를 위한 코드
        }

        for (String j : completion) {
            map.put(j, map.get(j) - 1); // 완주한 선수가 있으면 -1
        }

        for (String k : map.keySet()) {
            if (map.get(k) != 0) {
                answer = k;
                break;
            }
        }

        return answer;
    }
}