//package ru.geekbrains.lesson3;

public class MyLinkedList<T> {

    private Node head;


    public Node getHead() {
        return head;
    }

    /**
     * Добавить элемент в начало списка
     *
     * @param value значение
     */
    public void addFirst(T value) {
        Node node = new Node(value);
        if (head != null) {
            node.setNext(head);
        }
        head = node;
    }

    /**
     * Удалить элемент из начала списка
     */
    public void removeFirst() {
        if (head != null) {
            head = head.getNext();
        }
    }

    /**
     * Найти элемент
     *
     * @param value значение
     * @return результат поиска
     */
    public boolean contains(T value) {
        Node node = head;
        while (node != null) {
            if (node.getValue().equals(value))
                return true;
            node = node.getNext();
        }
        return false;
    }

    /**
     * Добавить элемент в конец списка
     *
     * @param value значение
     */
    public void addLast(T value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node last = head;
            while (last.getNext() != null) {
                last = last.getNext();
            }
            last.setNext(node);
        }
    }

    /**
     * Удалить элемент из конца списка
     */
    public void removeLast() {
        if (head == null)
            return;
        Node last = head;
        while (last.getNext() != null) {
            if (last.getNext().getNext() == null) {
                // Удаляем ссылку на последний элемент
                last.setNext(null);
                return;
            }
            last = last.getNext();
        }
        head = null;
    }

    /**
     * Метод разворота односвязного списка без рекурсии
     */
    public void revert() {

        if (head == null || head.getNext() == null) {
            return;
        }

        Node currNode = null;
        Node currNextNext = null;
        boolean first = true;

        do {
            currNode = head;

            if (first) {
                head = currNode.getNext();
                currNode.setNext(null);
                first = false;
            } else {
                head = currNextNext;
            }

            currNextNext = head.getNext();
            head.setNext(currNode);

        } while (currNextNext != null);

    }

}
