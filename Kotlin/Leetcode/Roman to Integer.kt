class Solution {
    fun romanToInt(s: String): Int {
        var result = 0

        s.forEachIndexed { index, char ->
            val character = Character.valueOf(char.toString())

            if (index < s.lastIndex) {
                val next = Character.valueOf(s[index + 1].toString())

                if (next.value > character.value) {
                    result -= character.value
                    return@forEachIndexed
                }
            }

            result += character.value
        }

        return result
    }

    private enum class Character(val value: Int) {
        I(1),
        V(5),
        X(10),
        L(50),
        C(100),
        D(500),
        M(1000),
    }
}
