package zad4;

import java.util.Scanner;


/*    Ввести с клавиатуры список из n целых чисел.
        а) Найти сумму, количество и среднее значение среди нечетных чисел.
        б) Найти среди отрицательных нечетных чисел минимальное и максимальное
        значения и их номера и поменять их местами.*/
public class ZadanieFourB {
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

//    public static void findAvg(Node head) {
//        Node ref = head;
//        int count = 0;
//        int sum = 0;
//        while (ref != null) {
//            if (ref.value % 2 != 0) {
//                count++;
//                sum = sum + ref.value;
//            }
//            ref = ref.next;
//        }
//        System.out.println();
//        System.out.println("count = " + count + " sum = " + sum);
//        System.out.println("avg = " + (double) sum / count);
//    }

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
//        printList(head);
//        findAvg(head);
        if(findMax(head)!=null){
            int valueMax = findMax(head)[0];
            int indexMax = findMax(head)[1];
            System.out.println("index = "+ indexMax + " valueMax = " + valueMax);
        }
        else{
            System.out.println("нет отрицательных нечетных чисел");
        }
    }
}