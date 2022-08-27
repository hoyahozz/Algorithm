import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val N = br.readLine().toInt()
    val numbers = br.readLine().split(" ").map { it.toInt() }

    val parent = numbers[0]

    for (child in 1 until numbers.size) {
        val gcd = GCD(parent, numbers[child])
        println("${parent / gcd}/${numbers[child] / gcd}")
    }
}

fun GCD(parent: Int, child: Int): Int {
    var parent = parent
    var child = child

    while(child != 0) {
        val gcd = parent % child
        parent = child
        child = gcd
    }

    return parent
}