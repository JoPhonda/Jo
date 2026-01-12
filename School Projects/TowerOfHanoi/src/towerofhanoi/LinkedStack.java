// Project 3 Fall 2025
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Joseph Kim (906687763)

// LLM Statement:
//I have not used any assistance for the assignment beyond course resources and
// staff.
package towerofhanoi;
import stack.*;
import java.util.EmptyStackException;
// -------------------------------------------------------------------------
/**
 *  Linked stack that acts like a stack with 1 top Node and a next Node.
 *  @param <T> Generic item that linked stack holds (towers)
 * 
 *  @author Jo
 *  @version Oct 22, 2025
 */
public class LinkedStack<T> implements StackInterface<T>
{
    private int size;
    private Node topNode;
    
    // ----------------------------------------------------------
    /**
     * Create a new LinkedStack object.
     */
    public LinkedStack() {
        topNode = null;
        size = 0;
    }
    
    @Override
    public void clear()
    {
        topNode = null;
        size = 0;
        
    }

    @Override
    public boolean isEmpty()
    {
        return topNode == null;
    }

    @Override
    public T peek()
    {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return topNode.getData();
    }

    @Override
    public T pop()
    {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        size--;
        Node temp = topNode;
        topNode = topNode.getNextNode();
        return temp.getData();
    }

    @Override
    public void push(T entry)
    {
        size++;
        Node node = new Node(entry);
        node.setNextNode(topNode);
        topNode = node;
        
    }
    // ----------------------------------------------------------
    /**
     * Returns size.
     * @return size
     */
    public int size() {
        return size;
    }
    
 // ----------------------------------------------------------
    /**
     * Returns the string of this linked stack in an array form.
     * @return toString
     */
    public String toString() {
        String s = "[";
        Node curr = topNode;
        for (int i = 0; i < size; i++) {
            s += curr.getData();
            if (i < size - 1) {
                s += ", ";
            }
            curr = curr.getNextNode();
        }
        return s + "]";
    }
    
 // ----------------------------------------------------------
    /**
     * Node class that makes a node with data and next.
     */
    private class Node {
        private T data;
        private Node next;
        public Node(T data) {
            this.data = data; 
        }
        public T getData() {
            return data;
        }
        public Node getNextNode() {
            return next;
        }
        public void setNextNode(Node n) {
            this.next = n;
        }
    }
}

