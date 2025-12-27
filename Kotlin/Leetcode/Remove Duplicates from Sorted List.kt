/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */
class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head == null) return head

        var current = head!!

        while (current != null) {
            var next = current?.next
            val currentValue = current.`val`
            var nextValue = next?.`val`

            while (currentValue == nextValue) {
                current?.next = next?.next
                next = next?.next
                nextValue = next?.`val`
            }

            current = current.next
        }

        return head
    }
}
