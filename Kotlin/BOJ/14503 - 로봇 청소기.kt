import java.util.*

lateinit var array: Array<IntArray>
lateinit var visited: Array<BooleanArray>

val dx = intArrayOf(-1, 0, 1, 0)
val dy = intArrayOf(0, 1, 0, -1)

val bx = intArrayOf(1, 0, -1, 0)
val by = intArrayOf(0, -1, 0, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val sb = StringBuilder()
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val (r, c, d) = readLine().split(" ").map { it.toInt() }

    array = Array(n) { intArrayOf() }
    visited = Array(n) { BooleanArray(n) }

    repeat(n) {
        array[it] += readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    println(BFS(r, c, d))
}

fun BFS(r: Int, c: Int, d: Int): Int {
    var direction = d
    var vertex = 0
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(r, c))

    while(queue.isNotEmpty()) {
        val curr = queue.poll()

        if(array[curr.first][curr.second] == 0) {
            array[curr.first][curr.second] = 2
            vertex++
        }

        var flag = false

        for(i in 0 until 4) {
            direction = rotate(direction)
            val x = curr.first + dx[direction]
            val y = curr.second + dy[direction]

            if(x !in array.indices || y !in array[0].indices) continue

            if(array[x][y] == 0) {
                queue.add(Pair(x, y))
                flag = true
                break
            }
        }

        // 네 방향 모두 청소가 된 상태
        if(!flag) {
            val x = curr.first + bx[direction]
            val y = curr.second + by[direction]

            if(x !in array.indices || y !in array[0].indices) return vertex
            if(array[x][y] == 1) return vertex

            queue.add(Pair(x, y))
        }
    }

    return vertex
}

fun rotate(d: Int): Int =
    if(d - 1 < 0) 3
    else d - 1

