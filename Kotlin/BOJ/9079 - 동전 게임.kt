import java.util.*

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val sb = StringBuilder()

    repeat(n) {
        val arrays = Array(3) { intArrayOf() }
        repeat(3) {
            arrays[it] = readLine().split(" ").map {
                if (it == "H") 0
                else 1
            }.toIntArray()
        }

        sb.append(BFS(arrays)).append("\n")
    }

    println(sb)
}

fun BFS(start: Array<IntArray>): Int {
    val visited = ArrayList<String>()
    val queue = LinkedList<String>()
    var level = 0

    queue.add(makeString(start))
    visited.add(makeString(start))

    while (queue.isNotEmpty()) {
        repeat(queue.size) {
            val curr = queue.poll()
            if (check(curr)) return level

            rotateDiagonalWay(makeArray(curr), true).apply {
                if (!visited.contains(this)) {
                    visited.add(this)
                    queue.add(this)
                }
            }

            rotateDiagonalWay(makeArray(curr), false).apply {
                if (!visited.contains(this)) {
                    visited.add(this)
                    queue.add(this)
                }
            }

            repeat(3) {
                rotateVerticalWay(it, makeArray(curr)).apply {
                    if (!visited.contains(this)) {
                        visited.add(this)
                        queue.add(this)
                    }
                }
            }

            repeat(3) {
                rotateHorizontalWay(it, makeArray(curr)).apply {
                    if (!visited.contains(this)) {
                        visited.add(this)
                        queue.add(this)
                    }
                }
            }
        }
        level++
    }

    return -1
}

fun rotateDiagonalWay(array: Array<IntArray>, isLeft: Boolean): String {
    if (isLeft) {
        repeat(3) {
            array[it][it].apply {
                if (this == 0) array[it][it] = 1
                else array[it][it] = 0
            }
        }
    } else {
        var i = 0
        var j = 2

        repeat(3) {
            if (array[i][j] == 1) array[i][j] = 0
            else array[i][j] = 1

            i++
            j--
        }
    }

    return makeString(array)
}

fun rotateVerticalWay(row: Int, array: Array<IntArray>): String {

    repeat(3) {
        array[it][row].apply {
            if (this == 0) array[it][row] = 1
            else array[it][row] = 0
        }
    }

    return makeString(array)
}

fun rotateHorizontalWay(column: Int, array: Array<IntArray>): String {

    repeat(3) {
        array[column][it].apply {
            if (this == 0) array[column][it] = 1
            else array[column][it] = 0
        }
    }

    return makeString(array)
}

fun makeString(array: Array<IntArray>): String {
    var binary = ""

    repeat(3) { i ->
        repeat(3) { j ->
            binary += array[i][j]
        }
    }

    return binary
}

fun makeArray(s: String): Array<IntArray> {
    val arrays = Array(3) { IntArray(3) }

    for (i in s.indices) {
        arrays[i / 3][i % 3] = Character.getNumericValue(s[i])
    }

    return arrays
}

fun check(s: String): Boolean {
    repeat(s.length) {
        if (s[0] != s[it]) return false
    }

    return true
}
