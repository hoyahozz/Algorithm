import java.util.*

lateinit var array: Array<Array<String>>
lateinit var visited: Array<BooleanArray>

val dx = intArrayOf(0, 0, -1, 1)
val dy = intArrayOf(-1, 1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    array = Array(m) { Array(n) { "" } }
    visited = Array(m) { BooleanArray(n) }

    repeat(m) { i ->
        val stArr = ArrayList<String>()
        readLine().forEach {
            stArr.add(it.toString())
        }

        array[i] = stArr.toTypedArray()
    }

    var wNumber = 0
    var bNumber = 0

    repeat(m) { i ->
        repeat(n) { j ->
            if(!visited[i][j]) {
                val vertex = BFS(i, j)
                when(array[i][j]) {
                    "W" -> wNumber += vertex * vertex
                    "B" -> bNumber += vertex * vertex
                }
            }
        }
    }

    print("$wNumber $bNumber")
}

fun BFS(startX: Int, startY: Int): Int {
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(startX, startY))
    visited[startX][startY] = true

    val team = array[startX][startY]
    var vertex = 0

    while (queue.isNotEmpty()) {
        val curr = queue.poll()
        vertex++

        for(i in 0 until 4) {
            val x = curr.first + dx[i]
            val y = curr.second + dy[i]

            if(x < 0 || x >= array.size || y < 0  || y >= array[0].size) continue
            if(visited[x][y]) continue
            if(array[x][y] != team) continue

            queue.add(Pair(x, y))
            visited[x][y] = true
        }
    }

    return vertex
}
