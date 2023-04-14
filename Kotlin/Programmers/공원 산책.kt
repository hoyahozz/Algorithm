class Solution {
    var current = 0 to 0

    // N, S, W, E
    val dx = intArrayOf(-1, 1, 0, 0)
    val dy = intArrayOf(0, 0, -1, 1)

    fun solution(park: Array<String>, routes: Array<String>): IntArray {
        findStart(park)

        routes.forEach { route ->
            moving(park, route)
        }

        return intArrayOf(current.first, current.second)
    }

    fun findStart(park: Array<String>) {
        park.forEachIndexed { i, array ->
            array.forEachIndexed { j, string ->
                if(string == 'S') {
                    current = i to j
                }
            }
        }
    }

    fun moving(park: Array<String>, route: String) {
        val (direction, number) = route.split(" ")

        var x = current.first
        var y = current.second

        repeat(number.toInt()) {
            when(direction) {
                "N" -> {
                    x += dx[0]
                    y += dy[0]
                }
                "S" -> {
                    x += dx[1]
                    y += dy[1]
                }
                "W" -> {
                    x += dx[2]
                    y += dy[2]
                }
                "E" -> {
                    x += dx[3]
                    y += dy[3]
                }
            }
            if(x !in park.indices || y !in park[0].indices) return
            if(park[x][y] == 'X') return
        }

        current = x to y
    }
}