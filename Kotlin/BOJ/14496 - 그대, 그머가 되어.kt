import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val (a, b) = readLine().split(" ").map { it.toInt() }
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val sb = StringBuilder()

    array = Array(n + 1) { intArrayOf() }
    visited = BooleanArray(n + 1)

    repeat(m) {
        val input = readLine().split(" ").map { it.toInt() }

        array[input[0]] += intArrayOf(input[1])
        array[input[1]] += intArrayOf(input[0])
    }

    sb.append(BFS(a, b))

    println(sb)
}

fun BFS(start: Int, end: Int): Int {

    val queue = LinkedList<Int>()
    queue.add(start)
    visited[start] = true

    var level = 0

    while(queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()

            if(curr == end) return level

            for(i in array[curr]) {
                if(!visited[i]) {
                    queue.add(i)
                    visited[i] = true
                }
            }
        }
        level++
    }

    return -1
}