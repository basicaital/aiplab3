package dsd_create2;

import java.util.Scanner;

class Node {
    public int value;
    public Node next;

    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}

public class Ex3 {
    static Scanner sc;

    public static Node createHead(int n) {
        System.out.println("Ввод с головы");
        int v = sc.nextInt();
        Node head = new Node(v, null);
        Node tail = head;

        for (int i = 1; i < n; i++) {
            int value = sc.nextInt();
            tail.next = new Node(value, null);
            tail = tail.next;
        }

        return head;
    }

    public static void toStringV(Node head) {
        Node ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        int size = sc.nextInt();
        Node head = createHead(size);
        toStringV(head);
    }
}