import java.util.LinkedList
import java.util.Queue

// #1
class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val tasks: Queue<Task> = LinkedList()
        var dayPerComplete = 0

        for (i in progresses.indices) {
            tasks.offer(
                Task(
                    progress = progresses[i],
                    speed = speeds[i],
                )
            )
        }

        while (tasks.isNotEmpty()) {
            tasks.forEach { it.work() }

            while (tasks.peek()?.isComplete == true) {
                tasks.poll()
                dayPerComplete++
            }

            if (dayPerComplete != 0) {
                answer += dayPerComplete
                dayPerComplete = 0
            }
        }

        return answer.toIntArray()
    }

    data class Task(
        var progress: Int,
        val speed: Int
    ) {
        fun work() {
            progress += speed
        }

        val isComplete get() = progress >= 100
    }
}

// #2 Queue 의 특성을 잘 활용한 케이스
class Solution {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val answer = mutableListOf<Int>()
        val remainDays: Queue<Int> = LinkedList()

        for (i in progresses.indices) {
            val progress = progresses[i]
            val speed = speeds[i]
            remainDays.offer(ceil((100.0 - progress) / speed).toInt())
        }
        
        while (remainDays.isNotEmpty()) {
            var daysPerComplete = 1
            val headDay = requireNotNull(remainDays.poll())
            var nextDay = remainDays.peek()
            
            while (nextDay != null && headDay >= nextDay) {
                remainDays.poll()
                nextDay = remainDays.peek()
                daysPerComplete++
            }
            
            answer.add(daysPerComplete)

        }

        return answer.toIntArray()
    }
}
