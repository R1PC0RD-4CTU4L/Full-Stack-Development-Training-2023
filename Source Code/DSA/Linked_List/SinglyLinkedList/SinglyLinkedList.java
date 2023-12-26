package SinglyLinkedList;

public class SinglyLinkedList {

    Node head;
    Node tail;
    int sizeofLL = 0;

    /*
     * Method 1 - createLinkedList() - Takes a value and Creates A Linked List and
     * returns the address
     * of the head node
     */

    public Node createLinkedList(String value) {

        Node newNode = new Node();
        head = newNode;
        tail = newNode;
        newNode.value = value;
        newNode.next = null;
        sizeofLL++;

        return head;

    }

    /*
     * Method 2 - insertNodeAtFirst() - Takes value and inserts a new node in the
     * beginnning of the Linked List. Returns void
     */

    public void insertNodeAtFirst(String value) {
        Node newNode = new Node();

        // Case 1 - Linked List Doesnt Exist. Method Called Without Linked List Creation
        if (head == null) {
            createLinkedList(value);
            return;
        }
        // Case 2 - Linked List Exists. Inserting Node At Beginning
        else {

            newNode.value = value;
            newNode.next = head;
            head = newNode;
            sizeofLL++;
        }
    }

    /*
     * Method 3 - insertNodeAtLast() - Takes value and inserts a new node in the
     * end of the Linked List. Returns void
     */

    public void insertNodeAtLast(String value) {
        Node newNode = new Node();

        // Case 1 - Linked List Doesnt Exist. Method Called Without Linked List Creation
        if (head == null) {
            createLinkedList(value);
            return;
        }
        // Case 2 - Linked List Exists. Inserting Node At End
        else {

            newNode.value = value;
            newNode.next = null;
            tail.next = newNode;
            tail = newNode;
            sizeofLL++;
        }
    }

    /*
     * Method 4 - insertNode() - Takes value and a position. Inserts a new node in
     * the given position of the Linked List. Returns void
     */

    public void insertNode(String value, int position) {

        // Case 1 - Linked List Doesnt Exist. Method Called Without Linked List Creation
        if (head == null) {
            createLinkedList(value);
            return;
        }

        // Case 2 - Position Value Given is 1. Insertion At Beginning

        if (position == 1) {
            insertNodeAtFirst(value);
            return;
        }
        // Case 3 - Position Value Given is Greater Than Size of Linked List . Insertion
        // At End
        else if (position > sizeofLL) {
            insertNodeAtLast(value);
            return;
        } else {

            Node newNode = new Node();
            newNode.value = value;

            Node tempNode = head;

            for (int i = 1; i < position - 1; i++) {
                tempNode = tempNode.next;
            }

            Node nextNode = tempNode.next;

            newNode.next = nextNode;
            tempNode.next = newNode;
            sizeofLL++;

        }
    }

    /*
     * Method 5 - printList() - Prints The Entire Linked List. Returns void
     */

    public void printList() {
        if (head == null) {
            System.out.println("NULL");

        } else {
            Node tempNode = head;
            for (int i = 1; i <= sizeofLL; i++) {
                System.out.print(tempNode.value + "-->");
                tempNode = tempNode.next;
            }
            System.out.print("NULL \n");
        }
    }

    /*
     * Method 6 - getListSize() - Returns the current Linked List Size
     */

    public int getListSize() {
        return sizeofLL;

    }

    /*
     * Method 7 - deleteNodeFromFirst() Deletion Of Node From The Beginnning of the
     * Linked List. Returns void
     */

    public void deleteNodeFromFirst() {

        // Case 1- If Linked List is Empty!

        if (head == null) {
            System.out.println("Nothing To Delete!");

            // Case 2- If Only one element is present
        } else if (head.next == null) {
            head = null;
            tail = null;
            System.out.println("Last Node Deleted. Nothing To Delete From First!");
            sizeofLL--;
        } else {

            head = head.next;
            System.out.println("Node Deleted From First!");
            sizeofLL--;

        }

    }

    /*
     * Method 8 - deleteNodeFromLast() Deletion Of Node From The End of the
     * Linked List. Returns void
     */

    public void deleteNodeFromLast() {

        // Case 1- If Linked List is Empty!

        if (head == null) {
            System.out.println("Nothing To Delete!");

            // Case 2- If Only one element is present
        } else if (head.next == null) {
            head = null;
            tail = null;
            System.out.println("Last Node Deleted. Nothing To Delete From Last!");
            sizeofLL--;
        } else {

            Node tempNode = head;

            for (int i = 1; i < sizeofLL; i++) {
                tempNode = tempNode.next;
            }

            tempNode.next = null;
            tail = tempNode;
            sizeofLL--;
            System.out.println("Node Deleted From Last");

        }

    }

    /*
     * Method 9 - deleteNode() Deletion Of Node From Given Position. Returns void
     */

    public void deleteNode(int position) {

        // Case 1- If Linked List is Empty!

        if (head == null) {
            System.out.println("Nothing To Delete!");

            // Case 2- If Only one element is present
        } else if (head.next == null) {
            head = null;
            tail = null;
            System.out.println("Last Node Deleted. Nothing To Delete!");
            sizeofLL--;
        }

        else if (position == 1) {
            deleteNodeFromFirst();
            return;
        } else if (position >= sizeofLL) {
            deleteNodeFromLast();
            return;
        } else {

            Node tempNode = head;

            for (int i = 1; i < position - 1; i++) {
                tempNode = tempNode.next;

            }

            Node toBeDeleted = tempNode.next;
            Node nextNode = toBeDeleted.next;

            tempNode.next = nextNode;
            toBeDeleted.next = null;
            System.out.println("Node Deleted From Position " + position);
            sizeofLL--;

        }

    }

}
