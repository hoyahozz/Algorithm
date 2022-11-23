import kotlin.math.max
import kotlin.math.min

/*
    배열이 주어지고, 배열의 모든 왼쪽 값은 자신의 값 보다 작고,
    모든 오른쪽 값은 자신의 값 보다 큰 항목을 찾는다.
    그런 조건에 맞는 항목을 찾으면 그 항목의 색인 값을 반환하고, 그런 항목이 없으면 -1 값을 반환한다. 예상 시간 복잡도는O(n)

    Input: arr[] = {5, 1, 4, 3, 6, 8, 10, 7, 9}
    Output: 4
    All elements on left of arr[4] are smaller than it and all elements on right are greater.

    Input: arr[] = {5, 1, 4, 4};
    Output: -1
 */

fun main() = with(System.`in`.bufferedReader()) {
    val arr = intArrayOf(5, 1, 4, 3, 6, 8, 10, 7, 9)

    val leftMax = IntArray(arr.size)
    var rightMin = Integer.MAX_VALUE
    leftMax[0] = Integer.MIN_VALUE

    for (i in 0 until arr.lastIndex) {
        leftMax[i + 1] = max(leftMax[i], arr[i])
    }

    println(leftMax.toList())

    for (i in arr.lastIndex downTo 0) {
        if (leftMax[i] < arr[i] && rightMin > arr[i]) {
            println(i)
            return@with
        }
        rightMin = min(arr[i], rightMin)
    }

    println(-1)
}
