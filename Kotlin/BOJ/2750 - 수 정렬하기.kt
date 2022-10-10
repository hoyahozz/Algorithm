fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val list = ArrayList<Int>()

    for (i in 0 until n) {
        list.add(readLine().toInt())
    }

    list.sort()

    for (i in list.indices) {
        println(list[i])
    }
}
