import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: BooleanArray
lateinit var moneys: IntArray

fun main() = with(System.`in`.bufferedReader()) {

    val (N, M, K) = readLine().split(" ").map { it.toInt() }
    moneys = readLine().split(" ").map { it.toInt() }.toIntArray()
    var answer = 0

    array = Array(N) { intArrayOf() }
    visited = BooleanArray(N)

    repeat(M) {
        val (V, W) = readLine().split(" ").map { it.toInt() - 1 }
        array[V] += intArrayOf(W)
        array[W] += intArrayOf(V)
    }

    repeat(N) {
        if (!visited[it] && moneys[it] <= K) {
            answer += BFS(it)
        }
    }

    if (answer > K) println("Oh no")
    else println(answer)
}

fun BFS(start: Int): Int {
    val queue = LinkedList<Int>()
    var minimumPrice = Int.MAX_VALUE

    queue.add(start)
    visited[start] = true

    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        if(minimumPrice > moneys[curr]) minimumPrice = moneys[curr]

        for (i in array[curr]) {
            if (!visited[i]) {
                queue.add(i)
                visited[i] = true
            }
        }
    }

    return minimumPrice
}
