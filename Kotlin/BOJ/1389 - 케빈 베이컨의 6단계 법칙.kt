import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    array = Array(n + 1) { intArrayOf() }
    visited = BooleanArray(n + 1)

    repeat(m) {
        val input = readLine().split(" ").map { it.toInt() }
        val p = input[0]
        val c = input[1]

        array[p] = array[p] + c
        array[c] = array[c] + p
    }

    var minNumber = 1
    var minCount = Integer.MAX_VALUE

    repeat(n) { start ->
        var count = 0
        repeat(n) { end ->
            if (start != end) {
                count += BFS(start + 1, end + 1)
                initVisited()
            }
        }

        if (minCount > count) {
            minNumber = start + 1
            minCount = count
        }
    }

    println(minNumber)
}

fun BFS(start: Int, end: Int): Int {
    var count = 0
    val queue = LinkedList<Int>()

    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()
            if (curr == end) return count

            for (i in array[curr]) {
                if (!visited[i]) {
                    queue.add(i)
                    visited[i] = true
                }
            }
        }
        count++
    }

    return count
}

fun initVisited() {
    for (i in visited.indices) {
        visited[i] = false
    }
}