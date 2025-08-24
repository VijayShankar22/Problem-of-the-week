/*
Problem of the Week – Deep Clone a Linked List with Random Pointer  

Company: Snapchat  

Scenario:  
You are given a singly linked list where each node contains two pointers:  
• next: Points to the next node in the list  
• random: Points to any node in the list (or null)  

Your task is to create a deep copy of this list. That means you should create a new list where  
each node is a new object, and has the same value and same structure (both next and random  
pointers) as the original list.  

Input Format:  
• A head node of a singly linked list. Each node contains:  
  o int val  
  o Node* next  
  o Node* random  

Output Format:  
• Return the head of the deep cloned linked list.  

Example:  
Input:  
A linked list represented as:  
Node1(val=7) → Node2(val=13) → Node3(val=11) → Node4(val=10) → Node5(val=1)  

Random pointers:  
Node2.random → Node1  
Node3.random → Node5  
Node4.random → Node3  
Node5.random → Node1  

Output:  
A deep clone with same structure but different memory references.  
*/

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Deep_clone_a_linked_list {
    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        HashMap<Node, Node> map = new HashMap<>();

        Node temp = head;
        while (temp != null) {
            map.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            Node clonedNode = map.get(temp);
            clonedNode.next = (temp.next != null) ? map.get(temp.next) : null;
            clonedNode.random = (temp.random != null) ? map.get(temp.random) : null;
            temp = temp.next;
        }

        Node clonedHead = map.get(head);

        System.out.println("Original List:");
        printList(head);
        System.out.println("\nCloned List:");
        printList(clonedHead);
    }
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randomVal;
            if (temp.random != null) {
                randomVal = temp.random.val;
            } else {
                randomVal = -1;
            }
            System.out.println("Node val = " + temp.val + ", Random points to = " + randomVal);
            temp = temp.next;
        }
    }
}
