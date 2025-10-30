class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null) return null
        var slow = head
        var fast = head.next
        while (slow != fast) {
            if (fast == null || fast.next == null) return null
            slow = slow?.next
            fast = fast.next?.next
        }
        // 慢指针回到起点
        slow = head
        fast = fast?.next
        // 两指针共同走 相遇点就是起始点
        while (slow != fast) {
            slow = slow?.next
            fast = fast?.next
        }
        return slow
    }
}