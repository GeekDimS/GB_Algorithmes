//package ru.geekbrains.lesson3;

import java.util.LinkedList;

public class Program {

    public static void main(String[] args) {
        LinkedList<Integer> linkedList01 = new LinkedList<>();

        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        myLinkedList.addLast("1");
        myLinkedList.addLast("2");
        myLinkedList.addLast("3");
        myLinkedList.addLast("4");
        myLinkedList.addLast("5");
        Node middleNode = middleNode(myLinkedList.getHead());
       // Node revertNode = revert(myLinkedList.getHead());
        myLinkedList.revert();
    }

    public static Node middleNode(Node head) {
        int counter = 1;

        Node node = head;
        while (node.getNext() != null) {
            counter++;
            node = node.getNext();
        }

        counter = counter / 2 + 1;

        node = head;
        for (int i = 0; i < counter - 1; i++) {
            node = node.getNext();
        }

        return node;
    }

//    /**
//     * Метод разворота односвязного списка без рекурсии
//     * @param head Список для разворота
//     * @return Развёрнутый список
//     */
//    public static Node revert(Node head) {
//
//        Node node = head;
//
//        if (node == null || node.getNext() == null) {
//            return node;
//        }
//
//        Node currNode = null;
//        Node currNextNext = null;
//        boolean first = true;
//
//        do {
//            currNode = node;
//
//            if(first){
//                node = currNode.getNext();
//                currNode.setNext(null);
//                first = false;
//            }else {
//                node = currNextNext;
//            }
//
//            currNextNext = node.getNext();
//            node.setNext(currNode);
//
//        } while (currNextNext != null);
//        return node;
//    }
}
