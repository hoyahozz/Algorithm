import java.util.*
import kotlin.math.abs

lateinit var locations: Array<Location>
lateinit var visited: BooleanArray

fun main() = with(System.`in`.bufferedReader()) {

    val t = readLine().toInt()

    repeat(t) {
        val n = readLine().toInt()
        locations = Array(n + 2) { Location.empty }
        visited = BooleanArray(n + 2)

        locations[0] = readLine().split(" ").map { it.toInt() }.run { Location(this[0], this[1]) }

        repeat(n) {
            locations[it + 1] = readLine().split(" ").map { it.toInt() }.run { Location(this[0], this[1]) }
        }

        locations[locations.lastIndex] = readLine().split(" ").map { it.toInt() }.run { Location(this[0], this[1]) }

        when(BFS()) {
            true -> println("happy")
            false -> println("sad")
        }
    }
}

fun BFS(): Boolean {
    val queue = LinkedList<Location>()
    queue.add(locations[0])
    visited[0] = true

    while(queue.isNotEmpty()) {
        val curr = queue.poll()
        if(curr == locations.last()) return true

        locations.forEachIndexed { index, data ->
            if(isCanGo(curr, data) && !visited[index]) {
                queue.add(data)
                visited[index] = true
            }
        }
    }

    return false
}

fun isCanGo(starting: Location, destination: Location): Boolean {
    return abs(destination.x - starting.x) + abs(destination.y - starting.y) <= 1000
}

data class Location(val x: Int, val y: Int) {
    companion object {
        val empty = Location(0, 0)
    }
}
