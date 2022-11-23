/*
    문자열 재정렬

    알파벳 대문자와 숫자(0 ~ 9)로만 구성된 문자열이 입력으로 주어집니다. 이때 모든 알파벳을
    오름차순으로 정렬하여 이어서 출력한 뒤에, 그 뒤에 모든 숫자를 더한 값을 이어서 출력합니다.
    • 예를 들어 K1KA5CB7이라는 값이 들어오면 ABCKK13을 출력합니다.

    AJKDLSI412K4JSJ9D -> ADDIJJJKKLSS20
 */

fun main() = with(System.`in`.bufferedReader()) {
    val s = readLine()

    val alphabet = ArrayList<Char>()
    var number = 0

    for (c in s) {
        if (c.isDigit()) number += c.digitToInt()
        else alphabet.add(c)
    }

    print("${alphabet.apply { sort() }.joinToString("")}$number")
}
