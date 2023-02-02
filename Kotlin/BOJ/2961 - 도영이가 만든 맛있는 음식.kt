import kotlin.math.absoluteValue

private var n = 0
private lateinit var foods: Array<Pair<Long, Long>>
private lateinit var selected: ArrayList<Pair<Long, Long>>
private var answer = Long.MAX_VALUE

fun main() {
    val br = System.`in`.bufferedReader()
    n = br.readLine().toInt()
    foods = Array(n) { Pair(0L, 0L) }
    selected = arrayListOf()
    repeat(n) {
        br.readLine().split(" ").map { it.toLong() }.apply {
            foods[it] = Pair(this[0], this[1])
        }
    }
    rec(0)
    println(answer)
}

private fun rec(idx: Int) {
    if (idx == n) {
        if (selected.size >= 1) {
            var s = 1L
            var b = 0L
            selected.forEach {
                s *= it.first
                b += it.second
            }
            answer = Math.min((s - b).absoluteValue, answer)
        }
    } else {
        selected.add(foods[idx])
        rec(idx + 1)
        selected.dropLast(1)

        rec(idx + 1)
    }
}