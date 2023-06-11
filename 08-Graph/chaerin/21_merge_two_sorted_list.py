# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
from typing import Optional


class Solution:
    def mergeTwoLists(self, list1: Optional[ListNode], list2: Optional[ListNode]) -> Optional[ListNode]:
        head = ListNode(-1)
        cursor = head

        while list1 != None and list2 != None:
            if list1.val <= list2.val:
                cursor.next = list1  # Update next node
                list1 = list1.next  # Update l1
            else:
                cursor.next = list2  # Update next node
                list2 = list2.next  # Updata l2

            cursor = cursor.next  # Move cursor

        # Last node
        if list1 != None:
            cursor.next = list1

        else:
            cursor.next = list2

        return head.next
