import Date.Companion.operate

/* https://school.programmers.co.kr/learn/courses/30/lessons/150370 */

class Solution {
    fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
        var answer: IntArray = intArrayOf()
        val termList = ArrayList<Term>()

        val today = today.toDate()

        for (i in terms.indices) {
            val tmp = terms[i].split(" ")
            termList.add(Term(tmp[0], tmp[1]))
        }

        for (i in privacies.indices) {
            val tmp = privacies[i].split(" ")
            val date = tmp[0].toDate()
            val type = tmp[1]
            val term = termList.find { it.type == type }!!

            val operateDate = date.operate(term.month.toInt())

            if (today.compareTo(operateDate) == 1) answer += (i + 1)
        }

        return answer
    }

    fun String.toDate(): Date {
        val dayTmp = this.split(".")
        return Date(dayTmp[0].toInt(), dayTmp[1].toInt(), dayTmp[2].toInt())
    }
}

data class Term(
    val type: String,
    val month: String,
)

data class Date(
    var year: Int,
    var month: Int,
    var day: Int,
) : Comparable<Date> {
    companion object {
        fun Date.operate(month: Int): Date {
            this.day--

            if (day == 0) {
                this.day = 28
                this.month--
            }

            if ((this.month + month) / 12 != 0) {
                this.year += (this.month + month) / 12
                this.month = (this.month + month) % 12
            } else {
                this.month += month
            }

            if (this.month == 0) {
                this.year--
                this.month = 12
            }

            return this
        }
    }

    override fun compareTo(other: Date): Int {
        return compareValuesBy(this, other, { it.year }, { it.month }, { it.day })
    }
}
