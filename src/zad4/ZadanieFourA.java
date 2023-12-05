package zad4;

import java.util.Scanner;

class Node { // КЛАСС – СТРУКТУРА ЭЛЕМЕНТА СПИСКА
    public int value; // значение
    public Node next; // поле – ссылка (указатель) на следующий узел

    Node(int value, Node next) { // конструктор класса
        this.value = value;
        this.next = next;
    }
}

/*    Ввести с клавиатуры список из n целых чисел.
        а) Найти сумму, количество и среднее значение среди нечетных чисел.
        б) Найти среди отрицательных нечетных чисел минимальное и максимальное
        значения и их номера и поменять их местами.*/
public class ZadanieFourA {
    static Scanner sc;

    public static Node fillList(int n) {
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

    public static void printList(Node head) {
        Node ref = head;
        while (ref != null) {
            System.out.print(ref.value + " ");
            ref = ref.next;
        }
    }

    public static void findAvg(Node head) {
        Node ref = head;
        int count = 0;
        int sum = 0;
        while (ref != null) {
            if (ref.value % 2 != 0) {
                count++;
                sum = sum + ref.value;
            }
            ref = ref.next;
        }
        System.out.println();
        System.out.println("count = " + count + " sum = " + sum);
        System.out.println("avg = " + (double) sum / count);
    }

    public static int[] findMin(Node head) {
        Node ref = head;
        int min = 0;
        while (ref != null) {
            if ((ref.value % 2 != 0) && (ref.value < 0)) {
                min = ref.value;
            }
            ref = ref.next;
        }
        if (min == 0) {
            return null;
        }
        else{
            ref = head;
            while (ref != null) {
                if ((ref.value % 2 != 0) && (ref.value < 0) && (ref.value < min)) {
                    min = ref.value;
                }
                ref = ref.next;
            }
            ref = head;
            int indexMin = 0;
            while (ref != null) {
                if(min==ref.value){
                    break;
                }
                indexMin++;
                ref = ref.next;
            }


            return new int[]{min, indexMin};
        }
    }
    public static int[] findMax(Node head) {
        Node ref = head;
        int max = 0;
        while (ref != null) {
            if ((ref.value % 2 != 0) && (ref.value < 0)) {
                max = ref.value;
            }
            ref = ref.next;
        }
        if (max == 0) {
            return null;
        }
        else{
            ref = head;
            while (ref != null) {
                if ((ref.value % 2 != 0) && (ref.value < 0) && (ref.value > max)) {
                    max = ref.value;
                }
                ref = ref.next;
            }
            ref = head;
            int indexMax = 0;
            while (ref != null) {
                if(max==ref.value){
                    break;
                }
                indexMax++;
                ref = ref.next;
            }


            return new int[]{max, indexMax};
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        System.out.println("size");
        int size = sc.nextInt();
        Node head = fillList(size);
        printList(head);
        findAvg(head);
        if(findMin(head)!=null){
            int valueMin = findMin(head)[0];
            int indexMin = findMin(head)[1];
            System.out.println("index = "+ indexMin + " valueMin = " + valueMin);
            int valueMax = findMax(head)[0];
            int indexMax = findMax(head)[1];
            System.out.println("index = "+ indexMax + " valueMax = " + valueMax);
        }
        else{
            System.out.println("нет отрицательных нечетных чисел");
        }
    }
}
