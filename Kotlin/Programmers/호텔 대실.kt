class Solution {
    fun solution(book_time: Array<Array<String>>): Int {
        // 10분 청소하고 다음 손님들이 사용 가능
        val rooms = ArrayList<Time>()

        // 시간, 분단위로 비교해야 함
        book_time.sortedBy { it[0] }.forEach { bookTime ->
            val start = bookTime[0]
            val end = bookTime[1]

            val (startHour, startMinute) = start.split(":").map { it.toInt() }
            val (endHour, endMinute) = end.split(":").map { it.toInt() }
            val startTime = Time(startHour, startMinute)
            val endTime = Time(endHour, endMinute)

            if (rooms.size == 0) {
                rooms.add(endTime)
            } else {
                var isRoomEmpty = false

                for (i in rooms.indices) {
                    val lastTime = rooms[i]

                    if (lastTime.hour * 60 + lastTime.minute + 10 <= startTime.hour * 60 + startTime.minute) {
                        rooms[i] = endTime
                        isRoomEmpty = true
                        break
                    }
                }

                if (!isRoomEmpty) rooms.add(endTime)
            }
        }


        return rooms.size
    }

    data class Time(
        val hour: Int,
        val minute: Int
    )
}
