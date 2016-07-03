package leetcode;

public class Linked_List_Cycle_II {

	public static ListNode detectCycle(ListNode head) {
		ListNode slow = head;
		ListNode fast = head;

		while (true) {
			if (fast == null || fast.next == null) {
				return null; //遇到null了，说明不存在环
			}

			slow = slow.next;
			fast = fast.next.next;
			if (fast == slow) {
				break;//第一次相遇在Z点
			}
		}

		slow = head; //slow从头开始走，
		while (slow != fast) {//二者相遇在Y点，则退出
			slow = slow.next;
			fast = fast.next;
		}

		return slow;

	}
}
