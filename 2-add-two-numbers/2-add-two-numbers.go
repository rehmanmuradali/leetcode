/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	carry := 0
	resultHead := ListNode{}
	current := &resultHead
	for l1 != nil || l2 != nil || carry != 0 {
		sum := carry
		if l1 != nil {
			sum += l1.Val
		}
		if l2 != nil {
			sum += l2.Val
		}

		carry = sum / 10
		sum %= 10

		current.Next = &ListNode{sum, nil}

		if l1 != nil {
			l1 = l1.Next
		}
		if l2 != nil {
			l2 = l2.Next
		}

		current = current.Next
	}
	return resultHead.Next
}