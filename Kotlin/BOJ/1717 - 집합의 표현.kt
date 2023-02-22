lateinit var array: IntArray
val sb = StringBuilder()

fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }

    array = IntArray(n + 1) { it }

    repeat(m) {
        val (type, a, b) = readLine().split(" ").map { it.toInt() }

        if (type == 0) union(a, b)
        else isSame(a, b)
    }

    println(sb)
}

fun union(a: Int, b: Int) {
    val findA = find(a)
    val findB = find(b)

    array[findB] = findA
}

fun find(targetIndex: Int): Int {
    if (array[targetIndex] == targetIndex) return targetIndex
    array[targetIndex] = find(array[targetIndex])
    return array[targetIndex]
}

fun isSame(a: Int, b: Int) {
    if (find(a) == find(b)) sb.appendLine("YES")
    else sb.appendLine("NO")
}
