fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val members = ArrayList<Pair<Int, String>>()

    repeat(n) {
        val input = readLine().split(" ")
        members.add(Pair(input[0].toInt(), input[1]))
    }

    members.sortedBy { it.first }.forEach {
        println("${it.first} ${it.second}")
    }
}
