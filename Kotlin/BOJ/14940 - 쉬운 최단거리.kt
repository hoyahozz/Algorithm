import java.util.*

lateinit var array: Array<IntArray>
lateinit var answer: Array<IntArray>
lateinit var visited: Array<BooleanArray>

val dx = intArrayOf(1, -1, 0, 0)
val dy = intArrayOf(0, 0, 1, -1)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    visited = Array(n) { BooleanArray(n) }
    array = Array(n) { IntArray(m) }
    answer = Array(n) { IntArray(m) }

    var startX = 0
    var startY = 0

    repeat(n) { i ->
        array[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    loop@for(i in 0 until n) {
        for(j in 0 until m) {
            if(array[i][j] == 2) {
                startX = i
                startY = j
                break@loop
            }
        }
    }

    BFS(startX, startY)

    for(i in 0 until n) {
        for(j in 0 until m) {
            print("${answer[i][j]} ")
        }
        println()
    }
}

fun BFS(startX: Int, startY: Int) {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(startX, startY))
    visited[startX][startY] = true

    var level = 1

    while(queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()
            repeat(4) {
                val x = curr.first + dx[it]
                val y = curr.second + dy[it]

                if(x > -1 && x < array.size && y > -1 && y < array[0].size && array[x][y] != 0 && !visited[x][y]) {
                    queue.add(Pair(x, y))
                    visited[x][y] = true
                    answer[x][y] = level
                }
            }
        }
        level++
    }
}
