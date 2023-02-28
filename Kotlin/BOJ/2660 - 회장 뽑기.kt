import java.util.*
import kotlin.collections.HashMap
import kotlin.properties.Delegates

lateinit var array: Array<IntArray>
var n by Delegates.notNull<Int>()

fun main() = with(System.`in`.bufferedReader()) {
    n = readLine().toInt()
    array = Array(n) { intArrayOf() }
    val candidates = HashMap<Int, Int>()
    var minimumValue = Int.MAX_VALUE

    while (true) {
        val (x, y) = readLine().split(" ").map { it.toInt() - 1 }

        if (x == -2 && y == -2) break

        array[x] += intArrayOf(y)
        array[y] += intArrayOf(x)
    }

    repeat(n) {
        val value = BFS(it)
        minimumValue = value.coerceAtMost(minimumValue)
        candidates[it] = value
    }

    candidates.filterValues { it == minimumValue }.let {
        println("$minimumValue ${it.size}")
        it.keys.forEach { key -> print("${key + 1} ") }
    }
}

fun BFS(start: Int): Int {
    val visited = BooleanArray(n)
    var depth = 0

    val queue = LinkedList<Int>()
    queue.add(start)
    visited[start] = true

    while(queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()

            for(i in array[curr]) {
                if(!visited[i]) {
                    visited[i] = true
                    queue.add(i)
                }
            }
        }
        depth++
    }

    return depth - 1
}