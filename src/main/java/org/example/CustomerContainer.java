package org.example;

class Node {
    int data;
    Node next;
    /**
     * Узел
     * @param data данные для узла
     */
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CustomerContainer {

    private Node head;
    private int size;

    public CustomerContainer() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Добавляет числа в контейнер
     * @param data число для добавления
     */
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    /**
     * Получение числа по индексу
     * @param index индекс элемента
     * @return целое число по индексу
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Вы вышли за пределы контейнера.");
        } else {
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            return current.data;
        }
    }

    /**
     * Удаление числа по индексу
     * @param index индекс элемента для удаления
     */
    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Вы вышли за пределы контейнера.");
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    /**
     * Возвращение размера контейнера
     * @return размер контейнера
     */
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        CustomerContainer container = new CustomerContainer();
        container.add(10);
        container.add(20);
        container.add(30);

        System.out.println("Element at index 1: " + container.get(1));

        container.remove(1);

        System.out.println("Size of container after removal: " + container.size());
    }
}