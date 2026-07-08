class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {

    public static Node add(Node head, Node head1) {

        Node dummy = new Node(0);
        Node temp = dummy;

        int carry = 0;

        while (head != null || head1 != null || carry != 0) {

            int sum = carry;

            if (head != null) {
                sum += head.data;
                head = head.next;
            }

            if (head1 != null) {
                sum += head1.data;
                head1 = head1.next;
            }

            carry = sum / 10;

            temp.next = new Node(sum % 10);
            temp = temp.next;
        }

        return dummy.next;
    }
}

public class add {

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // First Number: 342 (stored as 2 -> 4 -> 3)
        Node head = new Node(2);
        head.next = new Node(4);
        head.next.next = new Node(3);

        // Second Number: 465 (stored as 5 -> 6 -> 4)
        Node head1 = new Node(5);
        head1.next = new Node(6);
        head1.next.next = new Node(4);

        System.out.print("First List : ");
        printList(head);

        System.out.print("Second List: ");
        printList(head1);

        Node result = Solution.add(head, head1);

        System.out.print("Result     : ");
        printList(result);
    }
}