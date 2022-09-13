fun main() = with(System.`in`.bufferedReader()) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val pair = ArrayList<Pair<Int, Int>>()

    repeat(n) {
        val command = readLine().split(" ")

        when (command[0]) {
            "order" -> order(pair, command[1].toInt(), command[2].toInt())
            "sort" -> sort(pair)
            "complete" -> complete(pair, command[1].toInt())
        }
        output(pair)
    }
}

fun order(pair: ArrayList<Pair<Int, Int>>, key: Int, value: Int) {
    pair.add(key to value)
}

fun sort(pair: ArrayList<Pair<Int, Int>>) {
    pair.sortBy { it.first }
    pair.sortBy { it.second }
}

fun complete(pair: ArrayList<Pair<Int, Int>>, key: Int) {
    pair.removeIf { it.first == key }
}

fun output(pair: ArrayList<Pair<Int, Int>>) {
    if (pair.isNotEmpty()) {
        println(pair.joinToString(" ") { it.first.toString() })
    } else {
        println("sleep")
    }
}