import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Math.sqrt

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    var N = br.readLine().toInt()

    while(true) {
        if(N < 2) {
            println(2)
            break
        }

        if(isPrime(N) && isPalindrome(N)) {
            println(N)
            break
        }
        N++
    }
}

fun isPrime(n: Int): Boolean {
    var mod = 2
    while(mod <= sqrt(n.toDouble())) {
        if(n % mod == 0) return false
        mod++
    }
    return true
}

fun isPalindrome(num: Int): Boolean {
    return num.toString() == num.toString().reversed()
}
