public class LinkedList {

    Node head;
    int size;

    // This inner class is made static so that main() can access it
    public class Node {
        String data;
        Node next;

        Node(String d) {
            data = d;
            next = null;
        }
    }

    public void insert(String data) {
        Node new_node = new Node(data);
        new_node.next = null;

        // If the Linked List is empty, then make the new node as head
        if (head == null) {
            head = new_node;
        } else {
            // Else traverse till the last node and insert the new_node there
            Node last =head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = new_node;
        }
        size++;
    }

    public void printList() {
        Node current =head;

        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;

        }
    }
    public void  deleteAtPosition ( int position) {

        // If linked list is empty
        if (head == null)
            return;

        // Store head node
        Node temp = head;

        // If head needs to be removed
        if (position == 0)
        {
            head = temp.next;   // Change head
            return;
        }

        // Find previous node of the node to be deleted
        for (int i=0; temp!=null && i<position-1; i++)
            temp = temp.next;

        // If position is more than number of nodes
        if (temp == null || temp.next == null)
            return;

        // Node temp->next is the node to be deleted
        // Store pointer to the next of node to be deleted
        Node next = temp.next.next;

        temp.next = next;  // Unlink the deleted node from list
    }


    public int findSize() {
        return size;
    }

    public boolean contains(String element) {
        Node current = head;

        while (current != null) {
            if (current.data.equals(element)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public String get(int index)
    {
        Node current = head;
        int count = 0; /* index of Node we are
                          currently looking at */
        while (current != null)
        {
            if (count == index)
                return current.data;
            count++;
            current = current.next;
        }
        return "";
    }
}