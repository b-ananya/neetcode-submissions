# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:
    def removeNthFromEnd(self, head: Optional[ListNode], n: int) -> Optional[ListNode]:
        
        slow = head
        fast = head

        i = 0
        while i < n + 1:
            if fast == None:
                head = slow.next
                return head
            fast = fast.next
            i += 1
        
        while fast != None:
            fast = fast.next
            slow = slow.next
        
        temp = slow.next
        slow.next = temp.next

        return head
