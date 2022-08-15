fun main() {
    val n = readLine()!!.toInt()
    val fivoList = arrayListOf(0, 1)
    var count = 2

    while (count <= n) {
        fivoList.add(count, (fivoList[count - 2] + fivoList[count - 1]))
        count++
    }

    print(fivoList[n])
}