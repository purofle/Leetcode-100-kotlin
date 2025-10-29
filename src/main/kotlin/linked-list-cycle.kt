class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    // 龟兔赛跑算法
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null) return false
        var slow = head
        var fast = head.next
        while (slow != fast) {
            // 快的追不上慢的 两个都到头
            if (slow == null || fast?.next == null) {
                return false
            }
            slow = slow.next
            fast = fast.next?.next
        }
        return true
    }
}