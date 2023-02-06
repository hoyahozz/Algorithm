import java.util.*

lateinit var array: Array<IntArray>

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val (m, n) = readLine().split(" ").map { it.toInt() }

    array = Array(n) { IntArray(m) }

    repeat(n) { i ->
        array[i] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    val level = BFS()

    repeat(array.size) { i ->
        repeat(array[0].size) { j ->
            if(array[i][j] == 0) {
                println(-1)
                return@with
            }
        }
    }

    println(level)
}

fun BFS(): Int {
    val queue = LinkedList<Pair<Int, Int>>()

    repeat(array.size) { i ->
        repeat(array[0].size) { j ->
            if(array[i][j] == 1) queue.add(i to j)
        }
    }

    var level = 0

    while(queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()

            for(i in 0 until 4) {
                val x = curr.first + dx[i]
                val y = curr.second + dy[i]

                if(x !in array.indices || y !in array[0].indices) continue
                if(array[x][y] != 0) continue

                array[x][y] = 1
                queue.add(x to y)
            }
        }
        level++
    }

    return level - 1
}