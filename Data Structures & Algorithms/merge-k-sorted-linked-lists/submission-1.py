# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next

class Solution:

    def mergeTwo(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        dummy = ListNode()
        current = dummy
        cur1 = list1
        cur2 = list2

        while cur1 != None or cur2 != None:
            if cur1 == None or (cur2 != None and cur1.val >= cur2.val):
                current.next = cur2
                cur2 = cur2.next
                current = current.next
            else:
                current.next = cur1
                cur1 = cur1.next
                current = current.next
        head = dummy.next
        return head

    def mergeKLists(self, lists: List[Optional[ListNode]]) -> Optional[ListNode]:

        i = 0
        head = None
        while i < len(lists):
            head = self.mergeTwo(head, lists[i])
            i += 1
        
        return head
        