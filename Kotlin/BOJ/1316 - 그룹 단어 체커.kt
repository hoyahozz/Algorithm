import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    var count = 0

    loop@ for (i in 0 until N) {
        val str = br.readLine()
        val words = ArrayList<Char>()

        for (j in str.indices) {
            if (j < str.length - 1) {
                if (str[j] == str[j + 1]) continue
            }

            if (words.contains(str[j])) continue@loop

            words.add(str[j])
        }

        count++
    }
    println(count)
}
