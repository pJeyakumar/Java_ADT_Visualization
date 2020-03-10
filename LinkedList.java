/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphicstemplate;

/**
 *
 * @author Kaviyan Jeyakumar
 */
public class LinkedList 
{
	// Variable Declaration
    LinkedList next;
    int x;
    int y;
    int intNumber;
    // Base Constructor
    LinkedList(int intNumber, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.intNumber = intNumber;
        this.next = null;
    }
    // Constructor where we connect the previous linked list
    LinkedList(LinkedList prev, int intNumber, int x, int y)
    {
        this.x = x;
        this.y = y;
        this.intNumber = intNumber;
        this.next = prev;
    }
    // Delete links off the linked list, first in-first out
    public static LinkedList linkDelete(LinkedList a, LinkedList b) 
    {
       	// Linked List Variable Declaration
        LinkedList temp = b;
        LinkedList prev = null;
        
        // Starting from the most recently added node, we go through the list until we reach the node right before the one we want to delete
        while(temp.next != null)
        {
            prev = temp;
            temp = temp.next;
        }
        // The node previous to the one we want to delete, no longer points to the end node
        prev.next = temp.next;
        // Returning the new end node
        return prev;
    }
    // Returning y value of link
    public int returnY()
    {
        return this.y;
    }
    // Returning x value of link
    public int returnX()
    {
        return this.x;
    }
    
}