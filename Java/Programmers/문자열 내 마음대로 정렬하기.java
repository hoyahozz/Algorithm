import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        // 테스트 코드
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.solution(new String[]{"car", "bed", "sun"}, 2)));
    }

    public String[] solution(String[] strings, int n) {
        for(int i = 0; i < strings.length; i++) {
            for(int j = i + 1; j < strings.length; j++) {
                char iCh = strings[i].charAt(n);
                char jCh = strings[j].charAt(n);
                if(iCh > jCh) { // 문자열을 비교하여 i보다 작으면 오름차순 배치
                    String tmp = strings[i];
                    strings[i] = strings[j];
                    strings[j] = tmp;
                } else if(iCh == jCh) { // 만약 같으면 사전적으로 앞에 오는 것을 넣기
                    if(strings[i].compareTo(strings[j]) > 0) {
                        String tmp = strings[i];
                        strings[i] = strings[j];
                        strings[j] = tmp;
                    }
                }
            }
        }

        return strings;
    }
}