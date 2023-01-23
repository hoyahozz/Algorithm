import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val n = readLine().toInt()
    val m = readLine().toInt()

    array = Array(n + 1) { intArrayOf() }
    visited = BooleanArray(n + 1)

    repeat(m) {
        val input = readLine().split(" ").map { it.toInt() }
        array[input[0]] += intArrayOf(input[1])
        array[input[1]] += intArrayOf(input[0])
    }

    sb.append(BFS() - 1)

    println(sb)
}

fun BFS(): Int {
    val queue = LinkedList<Int>()
    queue.add(1)
    visited[1] = true

    var point = 0
    var level = 0

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()
            if(level <= 2) {
                point++
            }

            for(i in array[curr]) {
                if(!visited[i]) {
                    queue.add(i)
                    visited[i] = true
                }
            }
        }
        level++
    }

    return point
}
