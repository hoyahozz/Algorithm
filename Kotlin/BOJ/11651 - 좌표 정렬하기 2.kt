fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    val list = ArrayList<Pair<Int, Int>>()

    repeat(n) {
        val (x, y) = readLine().split(" ").map { it.toInt() }
        list.add(Pair(x, y))
    }

    list.sortWith(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })

    list.forEach {
        println("${it.first} ${it.second}")
    }
}
