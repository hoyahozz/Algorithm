import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {

    val n = readLine().toInt()
    val e = readLine().toInt()

    array = Array(n + 1) { intArrayOf() }
    visited = BooleanArray(n + 1)

    repeat(e) {
        val input = readLine().split(" ").map { it.toInt() }
        val parent = input[0]
        val child = input[1]

        array[parent] += array[parent] + child
        array[child] += array[child] + parent
    }

    println(BFS(1))
    // println(DFS(1) - 1)
}

fun BFS(start: Int): Int {
    val queue = LinkedList<Int>()
    var count = 0

    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val curr = queue.poll()

        for (i in array[curr]) {
            if (!visited[i]) {
                queue.add(i)
                visited[i] = true
                count++
            }
        }
    }

    return count
}

fun DFS(start: Int): Int {
    var count = 1
    visited[start] = true

    for(i in array[start]) {
        if(!visited[i]) {
            visited[i] = true
            count += DFS(i)
        }
    }

    return count
}