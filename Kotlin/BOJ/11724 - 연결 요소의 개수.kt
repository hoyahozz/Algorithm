fun main() = with(System.`in`.bufferedReader()) {
    val (N, M) = readLine().split(" ").map { it.toInt() }
    val hs = HashMap<Int, ArrayList<Int>>()

    // 간편한 계산을 위해 간선이 없는 0 정점 추가
    hs[0] = arrayListOf()

    repeat(N) {
        hs[it + 1] = ArrayList()
    }

    repeat(M) {
        val (vertex, edge) = readLine().split(" ").map { it.toInt() }
        hs[vertex] = hs.getOrDefault(vertex, ArrayList()).apply { add(edge) }
        hs[edge] = hs.getOrDefault(edge, ArrayList()).apply { add(vertex) }
    }

    val visited = Array(N + 1) { false }
    var component = -1

    for (vertex in hs.keys) {
        if (!visited[vertex]) {
            component++
            DFS(hs, visited, vertex)
        }
    }

    println(component)
}

fun DFS(hs: HashMap<Int, ArrayList<Int>>, visited: Array<Boolean>, start: Int) {
    visited[start] = true

    for (edge in hs[start]!!) {
        if (!visited[edge]) {
            DFS(hs, visited, edge)
        }
    }
}
