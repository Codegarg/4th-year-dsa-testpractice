import java.util.Scanner;

public class AddTwoNumbers {
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node dummy = new Node(0);
        Node p = l1, q = l2, curr = dummy;
        int carry = 0;
        while (p != null || q != null || carry != 0) {
            int x = (p != null) ? p.data : 0;
            int y = (q != null) ? q.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new Node(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        return dummy.next;
    }

    // Helper method to create linked list from user input
    public static Node createLinkedList(Scanner sc, String listName) {
        System.out.print("Enter digits for " + listName + " (space-separated): ");
        String[] digits = sc.nextLine().split(" ");
        Node head = new Node(Integer.parseInt(digits[0]));
        Node current = head;
        for (int i = 1; i < digits.length; i++) {
            current.next = new Node(Integer.parseInt(digits[i]));
            current = current.next;
        }
        return head;
    }

    // Helper method to print linked list
    public static void printLinkedList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Add Two Numbers (Linked List) ===");
        
        Node l1 = createLinkedList(sc, "List 1");
        Node l2 = createLinkedList(sc, "List 2");
        Node result = addTwoNumbers(l1, l2);
        System.out.print("Result: ");
        printLinkedList(result);

        sc.close();
    }
}