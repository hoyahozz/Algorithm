lateinit var array: Array<IntArray>
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    val (N, M, R) = readLine().split(" ").map { it.toInt() }

    array = Array(N) { IntArray(M) }

    repeat(N) {
        array[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    repeat(R) {
        var startX = 0
        var startY = 0

        repeat(minOf(N, M) / 2) {
            rotate(startX, startY, N - it, M - it)
            startX++; startY++
        }
    }

    printArray()
    println(sb)
}

fun rotate(startX: Int, startY: Int, limitX: Int, limitY: Int) {
    val tmp = array[startX][startY]

    // 위
    for (y in startY until limitY - 1) {
        array[startX][y] = array[startX][y + 1]
    }

    // 오른쪽
    for (x in startX until limitX - 1) {
        array[x][limitY - 1] = array[x + 1][limitY - 1]
    }

    // 아래
    for (y in limitY - 1 downTo startY + 1) {
        array[limitX - 1][y] = array[limitX - 1][y - 1]
    }

    // 왼쪽
    for (x in limitX - 1 downTo startX + 1) {
        array[x][startY] = array[x - 1][startY]
    }

    array[startX + 1][startY] = tmp
}

fun printArray() =
    repeat(array.size) { x ->
        repeat(array[0].size) { y ->
            sb.append("${array[x][y]} ")
        }
        sb.appendLine()
    }
