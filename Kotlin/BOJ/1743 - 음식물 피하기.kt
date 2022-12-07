val dx = arrayOf(0, 0, -1, 1)
val dy = arrayOf(-1, 1, 0, 0)

fun main() = with(System.`in`.bufferedReader()) {

    val sb = StringBuilder()
    val (N, M, K) = readLine().split(" ").map { it.toInt() }
    var max = Integer.MIN_VALUE
    val passage = Array(N) { IntArray(M) }
    val visited = Array(N) { BooleanArray(M) }

    repeat(K) {
        val (x, y) = readLine().split(" ").map { it.toInt() - 1 }
        passage[x][y] = 1
    }

    repeat(N) { x ->
        repeat(M) { y ->
            if (!visited[x][y] && passage[x][y] == 1) {
                val cur = DFS(passage, visited, x, y)
                if (max < cur) {
                    max = cur
                }
            }
        }
    }

    sb.append(max)

    print(sb)
}

fun DFS(passage: Array<IntArray>, visited: Array<BooleanArray>, x: Int, y: Int): Int {
    visited[x][y] = true
    var target = 1

    repeat(4) {
        val curX = x + dx[it]
        val curY = y + dy[it]

        if (curX > -1 && curY > -1 && curX < passage.size && curY < passage[0].size) {

            if (!visited[curX][curY] && passage[curX][curY] == 1) {
                target += DFS(passage, visited, curX, curY)
            }
        }
    }

    return target
}
