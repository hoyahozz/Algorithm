lateinit var array: IntArray
lateinit var moneys: IntArray

fun main() = with(System.`in`.bufferedReader()) {

    val (N, M, K) = readLine().split(" ").map { it.toInt() }
    moneys = readLine().split(" ").map { it.toInt() }.toIntArray()
    var answer = 0
    val hashSet = HashSet<Int>()

    array = IntArray(N) { it }

    repeat(M) {
        val (V, W) = readLine().split(" ").map { it.toInt() - 1 }
        union(V, W)
    }

    repeat(N) { hashSet += find(it) }
    hashSet.forEach { answer += moneys[it] }

    if (answer > K) println("Oh no")
    else println(answer)
}

fun union(a: Int, b: Int) {
    val findA = find(a)
    val findB = find(b)

    if (moneys[findA] <= moneys[findB]) array[findB] = findA
    else array[findA] = findB
}

fun find(targetIndex: Int): Int {
    if (array[targetIndex] == targetIndex) return targetIndex
    array[targetIndex] = find(array[targetIndex])
    return array[targetIndex]
}
