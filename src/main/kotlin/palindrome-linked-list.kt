class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

class Solution {
    fun isPalindrome(head: ListNode?): Boolean {
        var current = head
        var list = ""
        while (current != null) {
            list += "${current.`val`}"
            current = current.next
        }
        return list.reversed() == list
    }
}