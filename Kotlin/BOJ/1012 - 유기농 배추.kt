val dx = listOf(0, 1, 0, -1)
val dy = listOf(1, 0, -1, 0)

fun main() = with(System.`in`.bufferedReader()) {

    val T = readLine().toInt()
    val sb = StringBuilder()

    repeat(T) {
        val (M, N, K) = readLine().split(" ").map { it.toInt() }
        val graph = Array(M) { Array(N) { 0 } }
        val visited = Array(M) { Array(N) { false } }
        var component = 0

        repeat(K) {
            val (x, y) = readLine().split(" ").map { it.toInt() }
            graph[x][y] = 1
        }

        for (i in 0 until M) {
            for (j in 0 until N) {
                if (!visited[i][j] && graph[i][j] == 1) {
                    DFS(graph, visited, i, j)
                    component++
                }

            }
        }

        sb.append(component).append("\n")
    }

    print(sb)
}

fun DFS(graph: Array<Array<Int>>, visited: Array<Array<Boolean>>, x: Int, y: Int) {

    visited[x][y] = true

    repeat(4) {
        val curX = x + dx[it]
        val curY = y + dy[it]

        if (curX != -1 && curY != -1 && curX != graph.size && curY != graph[0].size) {
            if (!visited[curX][curY] && graph[curX][curY] == 1) {
                DFS(graph, visited, curX, curY)
            }
        }
    }
}
