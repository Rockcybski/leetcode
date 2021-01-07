package listnode;

/*
 
You are given two non-empty linked lists representing two non-negative integers. 

The digits are stored in reverse order and each of their nodes contain a single digit. 

Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
 
 */
public class _2_AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int[] initialAddResult = add(l1.val, l2.val, 0);
		ListNode result = new ListNode(initialAddResult[0]);
		ListNode t1 = l1;
		ListNode t2 = l2;
		ListNode currentItem = result;
		ListNode calTemp = null;
		int carry = initialAddResult[1];
		while (t1.next != null || t2.next != null || carry != 0) {
			if (t1.next == null) {
				t1 = new ListNode(0);
			} else {
				t1 = t1.next;
			}
			if (t2.next == null) {
				t2 = new ListNode(0);
			} else {
				t2 = t2.next;
			}
			int[] addResult = add(t1.val, t2.val, carry);
			calTemp = new ListNode(addResult[0]);
			carry = addResult[1];
			currentItem.next = calTemp;
			currentItem = calTemp;
		}
		return result;
	}

	private int[] add(int a, int b, int carry) {
		return new int[] { (a + b + carry) % 10, (int) ((a + b + carry) / 10) };
	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
