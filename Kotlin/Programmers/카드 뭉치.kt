package programmers

class Solution {
    fun solution(cards1: Array<String>, cards2: Array<String>, goal: Array<String>): String {
        var (first, second) = arrayOf(0, 0)

        goal.forEach {
            if (first < cards1.size && cards1[first] == it) first++
            else if (second < cards2.size && cards2[second] == it) second++
            else return "No"
        }

        return "Yes"
    }
}

fun main() {
    println(
        Solution().solution(
            arrayOf("i", "water", "drink"),
            arrayOf("want", "to"),
            arrayOf("i", "want", "to", "drink", "water")
        )
    )
}