val go = Array(19) { IntArray(19) }
val dx = intArrayOf(-1, 0, 1, 1)
val dy = intArrayOf(1, 1, 1, 0)

fun main() = with(System.`in`.bufferedReader()) {
    repeat(19) {
        go[it] = readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    repeat(19) { x ->
        repeat(19) { y ->
            if (go[y][x] != 0) {
                if (search(y, x)) return@with
            }
        }
    }

    println(0)
}

fun search(x: Int, y: Int): Boolean {
    val color = go[x][y]

    for (i in 0 until 4) {
        var curX = x
        var curY = y
        var level = 1

        while (true) {
            curX += dx[i]
            curY += dy[i]

            if (!check(curX, curY, color)) break

            level++
        }

        curX = x
        curY = y

        while (true) {
            curX -= dx[i]
            curY -= dy[i]

            if (!check(curX, curY, color)) break

            level++
        }

        if (level == 5) {
            println(color)
            println("${x + 1} ${y + 1}")
            return true
        }
    }

    return false
}

fun check(curX: Int, curY: Int, color: Int): Boolean {
    if (curX !in 0..18 || curY !in 0..18) return false
    if (go[curX][curY] != color) return false

    return true
}
