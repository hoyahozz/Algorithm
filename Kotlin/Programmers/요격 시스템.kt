// targets -> 500,000...
// 미사일 비용 최소
// A나라 폭격 미사일 -> X축에 평행한 직선(s,e)
// B나라 요격 미사일 -> X좌표에 걸쳐있는 모든 미사일 요격 가능
// (s, e) 로 표현되는 폭격 미사일은 s, e 좌표로는 요격 불가
// (3, 5) 이면, 3좌표와 5좌표로는 요격 불가능하다는 뜻
// 또한 실수에서도 요격이 가능함 (0.5)

class Solution {
    fun solution(targets: Array<IntArray>): Int {
        var answer = 0
        var max = -1
        val sortedTargets = targets.sortedBy { it[0] }

        for(target in sortedTargets) {
            val (currLow, currMax) = target

            if(max <= currLow) {
                answer++
                max = currMax
                continue
            }

            max = minOf(max, currMax)
        }

        return answer
    }
}