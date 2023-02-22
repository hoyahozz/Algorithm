lateinit var parent: IntArray

fun main() {
    parent = intArrayOf(0, 1, 2, 3, 4, 5, 6)

    union(1, 4) // 1, 4 연결
    union(5, 6) // 5, 6 연결

    union(4, 6) // 4, 6 연결
    /*
        4의 대표 노드는 1이므로, 결과적으로 a = 1
        6의 대표 노드는 5이므로, 결과적으로 b = 5
        union(1, 5)
     */

    find(6)

    /*
        6의 대표 노드를 찾으며, 경로 압축 실행
        (6 -> 5 -> 1) 이 성립되어 결과값으로 1 출력
        경로 압축까지 실행되어 위 코드 실행 후 배열 값은 아래와 같아짐
        [0, 3, 2, 3, 1, 3, 3]
     */
}

fun union(a: Int, b: Int) {
    // 각 매개변수의 대표 노드 탐색
    val findA = find(a)
    val findB = find(b)

    parent[findB] = findA
}

fun find(targetIndex: Int): Int {
    if (parent[targetIndex] == targetIndex) return targetIndex
    parent[targetIndex] = find(parent[targetIndex]) // 경로 압축
    return parent[targetIndex]
}
