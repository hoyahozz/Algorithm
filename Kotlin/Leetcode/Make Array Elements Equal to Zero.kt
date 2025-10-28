class Solution {
    fun countValidSelections(nums: IntArray): Int {
        var result = 0

        nums.forEachIndexed { index, value ->
            if (value == 0) {
                Direction.entries.forEach { direction ->
                    if (check(nums.copyOf(), index, direction)) result++
                }
            }
        }

        return result
    }

    private fun check(
        nums: IntArray,
        startIndex: Int,
        direction: Direction,
    ): Boolean {
        var current = startIndex;
        var nextDirection = direction

        while (current >= 0 && current < nums.size) {
            if (nums[current] > 0) {
                nextDirection = nextDirection.reversed()
                nums[current] -= 1
            }

            current += nextDirection.step
        }

        return nums.all { it == 0 }
    }

    private enum class Direction(val step: Int) {
        LEFT(-1),
        RIGHT(1);

        fun reversed(): Direction =
            if (this == LEFT) RIGHT else LEFT
    }
}
