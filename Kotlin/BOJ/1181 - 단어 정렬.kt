fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()
    val words = HashSet<String>()
    repeat(n) { words.add(readLine()) }
    words.sortedWith(compareBy<String> { it.length }.thenBy { it }).forEach { println(it) }
}
