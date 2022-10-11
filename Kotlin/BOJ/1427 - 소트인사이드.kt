fun main() = with(System.`in`.bufferedReader()) {
    print(readln().split("").sortedDescending().joinToString(""))
}
