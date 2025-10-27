/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class ListNode(var value: Int) {
    var next: ListNode? = null
}

class Solution {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        if (headA == null || headB == null) return null

        var aListNode = headA
        var bListNode = headB

        while (aListNode != bListNode) {
            aListNode = if (aListNode == null) {
                headB
            } else {
                aListNode.next
            }

            bListNode = if (bListNode == null) {
                headA
            } else {
                bListNode.next
            }
        }

        return aListNode
    }
}