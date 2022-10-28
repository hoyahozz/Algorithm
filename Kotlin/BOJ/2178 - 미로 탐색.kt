import java.util.*

var n = 0
var m = 0
val arr = Array(201) { IntArray(201) }

val dx = arrayOf(-1, 1, 0, 0)
val dy = arrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().split(" ").map { it.toInt() }

    n = input[0]
    m = input[1]

    for (i in 0 until n) {
        val text = readLine()
        for (j in 0 until m) {
            arr[i][j] = Character.getNumericValue(text[j])
        }
    }

    println(BFS(0, 0))
}

fun BFS(x: Int, y: Int): Int {
    val que: Queue<Node> = LinkedList()
    val start = Node(x, y)

    que.offer(start)

    while (que.isNotEmpty()) {
        val current = que.poll()
        val currentX = current.x
        val currentY = current.y

        for (i in 0 until 4) {
            val nx = currentX + dx[i]
            val ny = currentY + dy[i]

            if (nx < 0 || nx >= n || ny < 0 || ny > m) continue

            if (arr[nx][ny] == 0) continue

            if (arr[nx][ny] == 1) {
                arr[nx][ny] = arr[currentX][currentY] + 1
                que.offer(Node(nx, ny))
            }
        }
    }

    return arr[n - 1][m - 1]
}

data class Node(
    var x: Int,
    var y: Int
)
