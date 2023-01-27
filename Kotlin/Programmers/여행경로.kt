package programmers

val hs = HashMap<String, ArrayList<Pair<String, Boolean>>>()
var answer = ArrayList<String>()
var size = 0

class Solution {
    fun solution(tickets: Array<Array<String>>): Array<String> {
        tickets.sortedBy { it[1] }.forEach {
            makeHashMap(it[0], it[1])
        }

        size = tickets.size

        DFS("ICN", 0)

        return answer.toTypedArray()
    }

    fun DFS(key: String, depth: Int): Boolean {
        answer += key
        if (depth == size) return true

        hs[key]?.let {
            for (i in it.indices) {
                val curr = it[i]

                if (!curr.second) {
                    it[i] = Pair(curr.first, true)
                    if (DFS(curr.first, depth + 1)) return true
                    it[i] = Pair(curr.first, false)
                }
            }
        }

        answer.removeLast()
        return false
    }

    fun makeHashMap(key: String, value: String) {
        hs[key] = hs.getOrDefault(key, ArrayList()).apply { add(value to false) }
    }
}

fun main() {
    val tickets = arrayOf(
        arrayOf("ICN", "AAA"),
        arrayOf("ICN", "CCC"),
        arrayOf("CCC", "DDD"),
        arrayOf("AAA", "BBB"),
        arrayOf("AAA", "BBB"),
        arrayOf("DDD", "ICN"),
        arrayOf("BBB", "AAA"),
    )

    println(Solution().solution(tickets).contentDeepToString())
}