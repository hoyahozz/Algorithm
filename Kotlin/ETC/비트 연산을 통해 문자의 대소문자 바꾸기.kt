/*
    주어진 문자열에 대해 대문자는 소문자로, 소문자는 대문자로 변경하는 함수를 작성하시오.
 */

fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().toCharArray()

    println(toggleCase(input))
}

fun toggleCase(arr: CharArray): String {

    for(i in arr.indices) {
        arr[i] = (arr[i].code xor 32).toChar()
    }

    return arr.concatToString()
}