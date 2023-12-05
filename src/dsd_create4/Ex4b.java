package dsd_create4;

import java.util.Scanner;
class Node {
    public int value; //
    public Node next;
    Node(int value, Node next) {
        this.value = value;
        this.next = next;
    }
}
public class Ex4b {
    static class List {
        public Node head;
        public Node tail;
        List(Node node) {
            this.head = node;
            this.tail = node;
        }

        public void addNode(Node node) {
            this.tail.next = node;
            this.tail = this.tail.next;
        }

        public void print() {
            Node ref = this.head;
            while (ref != null) {
                System.out.print(" " + ref.value);
                ref = ref.next;
            }
            System.out.print("\n");
        }

        public void addlist(List list, int lenght){
            Scanner scanner = new Scanner(System.in);
            int val;
            for (int i = 0; i < lenght-1; i++) {
                System.out.print("Введите " + (i+2) + " элемент: ");
                val = scanner.nextInt();
                list.addNode(new Node(val, null));
            }

            scanner.close();
        }

        //поиск минимального отрицательного
        public int[] min(){
            Node ref = this.head;
            int min = 0;
            int imin = 0;
            int count = 0;
            while (ref != null) {
                if (ref.value%2 != 0 && ref.value < min){
                    min = ref.value;
                    imin = count;
                }
                count++;
                ref = ref.next;
            }
            return new int[] {imin, min};
        }

        //поиск минимального отрицательного
        public int[] max(){
            Node ref = this.head;
            int max = 0;
            int imax = 0;
            int count = 0;
            while (ref != null) {
                if (max == 0 && ref.value < 0 && ref.value%2 != 0){
                    max = ref.value;
                    imax = count;
                } else if (max < 0 && ref.value < 0 && ref.value%2 != 0 && max < ref.value){
                    max = ref.value;
                    imax = count;
                }
                count++;
                ref = ref.next;
            }
            return new int[] {imax, max};
        }

        public void swap(int i1, int val1, int i2, int val2){
            Node end = this.head;
            int count = 0;
            while (end != null) {
                if (count == i1){
                    end.value = val2;
                }
                if (count == i2){
                    end.value = val1;
                }
                end = end.next;
                count ++;
            }
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //длина списка
        System.out.print("Введите длину списка: ");
        int listlenght = scanner.nextInt();

        //первый элемент
        System.out.print("Введите 1 элемент: ");
        int val = scanner.nextInt();
        Node head = new Node(val, null);
        List list = new List(head);

        //заполнение списка
        list.addlist(list, listlenght);

        //вывод списка
        list.print();

        //ищем минимальный
        int[] min = list.min();

        //ищем максимальный
        int[] max = list.max();

        //меняем местами
        list.swap(min[0],min[1],max[0],max[1]);

        //вывод списка
        list.print();

        scanner.close();
    }
}