import java.util.Scanner;

public class RemoveNthNodefromEnd {
    public static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    public static Node removeNthFromEnd(Node head, int n){
        Node dummy = new Node(0);
        dummy.next = head;
        Node first = dummy;
        Node second = dummy;
        for (int i = 0; i <= n; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;

        return dummy.next;
    }

    public static Node createLinkedList(Scanner sc, String name) {
        System.out.print("Enter nodes for " + name + " (space-separated): ");
        String[] parts = sc.nextLine().trim().split("\\s+");
        if (parts.length == 0 || parts[0].isEmpty()) {
            return null;
        }
        Node head = new Node(Integer.parseInt(parts[0]));
        Node current = head;
        for (int i = 1; i < parts.length; i++) {
            current.next = new Node(Integer.parseInt(parts[i]));
            current = current.next;
        }
        return head;
    }

    public static void printLinkedList(Node head) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
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
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Remove Nth Node from End ===");
        Node head = createLinkedList(sc, "the list");
        System.out.print("Enter n (1-based from end): ");
        int n = Integer.parseInt(sc.nextLine().trim());

        Node result = removeNthFromEnd(head, n);

        System.out.print("Resulting list: ");
        printLinkedList(result);
        sc.close();
    }
}
