package com.company;


public class LinkedListProblems {
    /**
     * You are given two linked lists representing two non-negative numbers.
     * The digits are stored in reverse order and each of their nodes contain a single digit.
     * Add the two numbers and return it as a linked list.
     * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
     * Output: 7 -> 0 -> 8
     * @return ListNode answer
     */
    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        int carry = 0;
        int n1;
        int n2;

        ListNode head = new ListNode(-1); // Pointer that runs through the list
        ListNode answer = head;              // Pointer to start of the list

        while (a != null || b != null) {
            n1 = a != null ? a.val : 0;
            n2 = b != null ? b.val : 0;

            int sum = n1 + n2 + carry;

            if (sum < 10) {
                carry = 0;
                answer.next = new ListNode(sum);
            } else {
                carry = sum / 10;
                answer.next = new ListNode(sum % 10);
            }

            // Move pointers to move through the lists
            if (a != null)
                a = a.next;
            if (b != null)
                b = b.next;

            answer = answer.next;
        }

        if (carry != 0)
            answer.next = new ListNode(carry);

        return head.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode prev;

        ListNode(int x) {
            val = x;
            next = null;
            prev = null;
        }
    }
}
