/*
    연결하여 만들 수 있는 가장 큰 수 찾기

    숫자가 주어지면, 이를 연결하여 만들 수 있는 가장 큰 수를 찾아라.
    각각의 숫자는 연결하ㅕㅇ 만들 수 있는 가장 큰 숫자를 만들기 위해 서로 연결된다.

    e.g.
    input : {2, 3, 4, 0, 6}
    output : 64320

    input : {10, 68, 75, 7, 21, 12}
    output : 77568211210
 */

fun main() = with(System.`in`.bufferedReader()) {
    val input = arrayOf(10, 68, 75, 7, 21, 12).toList().map { it.toString() }.sortedWith { a, b ->
        when {
            a + b < b + a -> 1
            a + b > b + a -> -1
            else -> 0
        }
    }

    for (i in input) {
        print(i)
    }
}
