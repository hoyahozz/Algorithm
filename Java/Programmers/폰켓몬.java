import java.util.*;

class Solution {
    public static void main(String[] args){
        // 테스트 코드
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[]{1,2,3,4}));
    }

    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<Integer>();
        for(int i : nums) hs.add(i);
        return hs.size() > nums.length / 2 ? nums.length / 2 : hs.size();
    }
}