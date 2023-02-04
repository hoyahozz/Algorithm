fun main() = with(System.`in`.bufferedReader()) {
    val alphabets = arrayOf("c=" ,"c-", "dz=", "d-", "lj", "nj", "s=", "z=")
    var s = readLine()

    alphabets.forEach { s = s.replace(it, " ") }
    println(s.length)
}