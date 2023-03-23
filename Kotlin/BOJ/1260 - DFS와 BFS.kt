import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M, V) = readLine().split(" ").map { it.toInt() }

    array = Array(N + 1) { intArrayOf() }

    repeat(M) {
        val (A, B) = readLine().split(" ").map { it.toInt() }
        array[A] += intArrayOf(B)
        array[B] += intArrayOf(A)
    }

    repeat(N + 1) {
        array[it].sort()
    }

    visited = BooleanArray(array.size)
    DFS(V)
    println()
    visited = BooleanArray(array.size)
    BFS(V)
}

fun BFS(start: Int) {
    val queue = LinkedList<Int>()

    queue.add(start)
    visited[start] = true

    while(queue.isNotEmpty()) {
        val curr = queue.poll()
        print("$curr ")

        for(i in array[curr]) {
            if(!visited[i]) {
                queue.add(i)
                visited[i] = true
            }
        }
    }
}

fun DFS(start: Int) {
    visited[start] = true
    print("$start ")

    for(i in array[start]) {
        if(!visited[i]) {
            DFS(i)
        }
    }
}

/*
4 5 1
2 4
3 4
4 1
2 1
3 1
 */