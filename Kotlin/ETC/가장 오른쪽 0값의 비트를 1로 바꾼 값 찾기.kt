import kotlin.math.log2

/*
    양의 정수에 대해 가장 오른쪽 0 값의 비트를 1로 바꾼다. 만약 그런 0값이 없으면 원래 정수를 반환한다.
 */

fun main() = with(System.`in`.bufferedReader()) {
    val n = readLine().toInt()

    println(getRightMostUnsetBit(n))
}

fun getRightMostUnsetBit(n: Int): Int {
    if (n == 0) return 1

    if ((n and (n + 1)) == 0) return n

    val pos = getPostOfRightMostSetBit(n).toInt()
    return ((1 shl pos or n))
}

fun getPostOfRightMostSetBit(n: Int): Double {
    return log2((n.inv() and (n + 1)).toDouble())
}