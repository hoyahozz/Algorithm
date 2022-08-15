import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution solution = new Solution();

        String[] id_list = new String[]{"muzi", "frodo", "apeach", "neo"};
        String[] report = new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"};
        int k = 2;

        System.out.println(Arrays.toString(solution.solution(id_list, report, k)));
    }

    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        HashMap<String, ArrayList<String>> idMap = new HashMap<>();
        HashMap<String, Integer> reportMap = new HashMap<>();

        for(String user : id_list) {
            reportMap.put(user, 0);
        }

        for(int i = 0; i < report.length; i++) {
            StringTokenizer st = new StringTokenizer(report[i], " ");
            String user = st.nextToken();
            String rep_user = st.nextToken();

            if(idMap.containsKey(user)) {
                ArrayList<String> value = idMap.get(user);
                if(!value.contains(rep_user))
                    value.add(rep_user);
            } else {
                ArrayList<String> value = new ArrayList<>();
                value.add(rep_user);
                idMap.put(user, value);
            }

        }

        for(int i = 0; i < id_list.length; i++) {
            ArrayList<String> repList = idMap.get(id_list[i]);
            if(repList != null) {
                for(String rep : repList) {
                    if(reportMap.containsKey(rep)) {
                        int value = reportMap.get(rep);
                        reportMap.put(rep, (value + 1));
                    }
                }
            }
        }

        for(int i = 0; i < id_list.length; i++) {
            ArrayList<String> repList = idMap.get(id_list[i]);
            if(repList != null) {
                for(String rep : repList) {
                    if(reportMap.get(rep) >= k) {
                        answer[i]++;
                    }
                }
            }
        }

        return answer;
    }
}