package dsd_create1;
class Node { // описание элемента
    public int value;
    public Node next;
    Node(int value, Node next) { // конструктор
        this.value = value;
        this.next = next;
    }}
public class Ex2_2{ // главный класс
    public static void main(String[] args) {
    // добавление элементов с перемещением головы (наращивание с головы)
        Node head=null; // начальное значение ссылки на голову
        for (int i =9; i>=0; i--) {
            head=new Node(i, head);
        }
    // вывод элементов на экран
        Node ref = head;
        while (ref != null) {
            System.out.print(" " + ref.value);
            ref = ref.next;
        }
    }
}