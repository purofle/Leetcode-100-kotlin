class ListNode(var value: Int) {
    var next: ListNode? = null
}

class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current = head

        while (current != null) {
            val next = current.next

            current.next = prev // reverse!
            prev = current

            current = next // 到头了
        }

        return prev
    }
}