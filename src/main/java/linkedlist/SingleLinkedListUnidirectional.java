package linkedlist;

public class SingleLinkedListUnidirectional<T> {
    Node head;

    //declared static, so that main can access directly for test being
    static class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    public void insertLast(SingleLinkedListUnidirectional linkedList, T dataToInsert) {
        if(linkedList == null)
            linkedList = new SingleLinkedListUnidirectional();

        Node newNode = new Node(dataToInsert);

        //if head is null, meaning first node to insert
        if(linkedList.head == null) {
            linkedList.head = newNode;
            return;
        }

        //if data already exist in linkedlist, then traverse till end to insert new node at end
        Node lastNode = linkedList.head;
        while (lastNode.next != null) {
            lastNode = lastNode.next;
        }
        lastNode.next = newNode;
    }


    public static void main(String[] args) {
        SingleLinkedListUnidirectional<Integer> linkedList = new SingleLinkedListUnidirectional<>();

        linkedList.insertLast(linkedList, 10);
        linkedList.insertLast(linkedList, 3);
        linkedList.insertLast(linkedList, 50);

        printList(linkedList);
    }

    // Method to print the LinkedList.
    public static void printList(SingleLinkedListUnidirectional list) {
        Node currNode = list.head;

        System.out.println("LinkedList: ");
        System.out.println("head=="+ list.head.data);

        // Traverse through the LinkedList
        while (currNode != null) {
            // Print the data at current node
            System.out.print(currNode.data + "(next=" + (currNode.next != null ? currNode.next.data : "") + ")  ");

            // Go to next node
            currNode = currNode.next;
        }
    }
}
