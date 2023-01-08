lateinit var array: Array<Array<String>>
lateinit var visited: Array<BooleanArray>

val dx = intArrayOf(-1, 1, 0, 0)
val dy = intArrayOf(0, 0, -1, 1)

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    var count = 0
    val numbers = ArrayList<Int>()

    array = Array(n) { arrayOf() }
    visited = Array(n) { BooleanArray(n) }

    repeat(n) {
        array[it] = readLine().split("").filter { it.isNotEmpty() }.toTypedArray()
    }

    repeat(n) { x ->
        repeat(n) { y ->
            if(array[x][y] == "1" && !visited[x][y]) {
                count++
                numbers.add(DFS(x, y))
            }
        }
    }

    println(count)
    numbers.sorted().forEach { println(it) }
}

fun DFS(x: Int, y: Int): Int {
    var count = 1
    visited[x][y] = true

    repeat(4) {
        val nextX = x + dx[it]
        val nextY = y + dy[it]
        if (nextX >= 0 && nextX < array.size && nextY >= 0 && nextY < array.size) {
            if(array[nextX][nextY] == "1" && !visited[nextX][nextY]) {
                count += DFS(nextX, nextY)
            }
        }
    }

    return count
}
