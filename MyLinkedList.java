import org.w3c.dom.Node;

public class MyLinkedList {
    private Node head; // Head is the first node in a linked list

    // Node is nested static class, so that main() can access it,
    // and because it only exists
    // along with linked list,
    // Node is private because it's implementation detail,
    // and should not be exposed
    private static class Node{
        private Node next;
        private int data; // can be declared in specific type of data like int data.

        //Constructor
        public Node(int data){
            this.data = data;
            next = null;
        }
    }

   // Method to add a new node
    public  void add( int data){
        //Create a new node with given data
        Node new_node = new Node(data);
        new_node.next = null;

        //If the linked list is empty,
        //then make the new node as head
        if(head == null){
            head = new_node;
            return;
        }

            //Else traverse till the last node
            //and insert the new_node there,
            //which means change the next of last node to new node.
            //new_node is going to be the last node, so
            //make the next of it as null
            new_node.next = null;
            //traverse till the last node
            Node last = head; //the pointer now place at the last node.
            //chỗ này là tạo tạm một cái Node tên là last dùng cái pointer head rà
            //xuống cái list,nếu last.next vẫn chỉ đến một node khác
            // thì thay thế node đó bằng node last rồi tiếp tục,
            // cho đến khi nào cái last.next = null thì dừng lại. Lúc này
            // Node last là node cuối cùng vì last.next = null.
            while (last.next != null){
                last = last.next;
            }
            //After the last node is found. change the next of last node to new_node
            last.next = new_node;
            return;

    }


    //Method to insert a node after a given node
    public void insert(Node prev_node, int data){
        //check if the given Node is null
        if(prev_node == null){
            System.out.println("The given previous node cannot be null.");
            return;
        }
        //Allocate the node and put in data
        Node new_node = new Node(data);
        //Change next of new_node as next of prev_node
        new_node.next = prev_node.next;
        //Make next of prev_node as new_node
        prev_node.next = new_node;

    }

    //DELETION BY KEY
    void deleteNode(int key)
    {
        // Store head node
        Node temp = head, prev = null;

        // If head node itself holds the key to be deleted
        if ((temp != null) && (temp.data == key))
        {
            head = temp.next; // Changed head
            return;
        }

        // Search for the key to be deleted, keep track of the
        // previous node as we need to change temp.next
        while (temp != null && temp.data != key)
        {
            prev = temp;
            temp = temp.next;
        }

        // If key was not present in linked list
        if (temp == null) {
            System.out.println(key + " is not in the list.");
            return;
        }

        // Unlink the node from linked list
        if(temp != null){
            prev.next = temp.next;
            System.out.println(key + " found and deleted.");
        }

    }

    //Method to printout the List
    public static void printList(MyLinkedList list){
        Node currNode = list.head;
        System.out.print("Linked List: ");

        //traverse through the list
        while(currNode != null){
            //print the data at the curent node
            System.out.print(currNode.data + " ");
            //Go to the next node
            currNode = currNode.next;
        }
    }

    public static void main(String [] args){
        MyLinkedList list = new MyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        printList(list);
    }
}
