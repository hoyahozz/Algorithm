import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() = with(System.`in`.bufferedReader()) {
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val (n, m) = readLine().split(" ").map { it.toInt() }

    val titles = ArrayList<Title>()

    for (i in 0 until n) {
        val (name, number) = readLine().split(" ")
        titles.add(Title(name, number.toInt()))
    }

    for (i in 0 until m) {
        val value = readLine().toLong()
        bw.write(binarySearch(titles, value) + "\n")
    }
    bw.flush()
    bw.close()
}

fun binarySearch(titles: ArrayList<Title>, target: Long): String {
    var low = 0
    var high = titles.size - 1

    while (low < high) {
        val middle = (low + high) / 2

        if (titles[middle].value < target) low = middle + 1
        else high = middle
    }

    return titles[high].name
}

data class Title(
    val name: String,
    val value: Int
)