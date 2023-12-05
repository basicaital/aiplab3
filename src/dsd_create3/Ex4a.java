package dsd_create3;

import java.util.Scanner;
class Node { // КЛАСС – СТРУКТУРА ЭЛЕМЕНТА СПИСКА
    public int value; // значение
    public Node next; // поле – ссылка (указатель) на следующий узел
    Node(int value, Node next) { // конструктор класса
        this.value = value;
        this.next = next;
    }
}
public class Ex4a {

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

        //сумма нечетных
        public int sumsearch(){
            Node ref = this.head;
            int sum = 0;
            while (ref != null) {
                if (ref.value%2 != 0){
                    sum = sum + ref.value;
                }
                ref = ref.next;
            }
            return sum;
        }

        //поиск количества нечетных
        public int countsearch(){
            Node ref = this.head;
            int count = 0;
            while (ref != null) {
                if (ref.value%2 != 0){
                    count ++;
                }
                ref = ref.next;
            }
            return count;
        }

        //поиск среднего среди нечетных
        public float average(List list){
            float average = (float) (list.sumsearch()/(list.countsearch()/1.0));
            return average;
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

        //то что требует пункт а
        System.out.print("\nКоличество нечетных: " + list.countsearch() + "\n");
        System.out.print("Сумма нечетных: " + list.sumsearch() + "\n");
        System.out.print("Среднее значение нечетных: " + list.average(list) + "\n");

        scanner.close();
    }
}

