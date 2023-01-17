import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val (s, e) = readLine().split(" ").map { it.toInt() }

    array = Array(n + 1) { intArrayOf() }
    visited = BooleanArray(n + 1)

    for (i in 1..array.lastIndex) {
        if(i - 1 != 0) array[i] += intArrayOf(i - 1)
        if(i + 1 < array.size) array[i] += intArrayOf(i + 1)
    }

    repeat(m) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        array[x] += intArrayOf(y)
        array[y] += intArrayOf(x)
    }

    val queue = LinkedList<Int>()
    queue.add(s)
    visited[s] = true

    var level = 0

    while(queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()

            if(curr == e) {
                println(level)
                return@with
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
}
