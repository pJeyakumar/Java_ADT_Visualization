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
public class Queue 
{
	// Variable Declaration
    Queue link;
    Queue front;
    Queue rear;
    Queue temp;
    Queue end;
    int x;
    int y;
    // Base Constructor
    Queue()
    {
        front = null;
        rear = null;
    }
    // Constructor where we are given x and y values
    Queue(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    // Constructor where we cannot prev node to this one
    Queue(int x, int y,Queue prev)
    {
        this.x = x;
        this.y = y;
        this.link = prev;
    }
    // Returning x value of the node
    public int returnX()
    {
       return this.x;
    }
    // Returning y value of the node
    public int returnY()
    {
       return this.y; 
    }
    // Adding a new node to the back of queue
    public void enQueue(int x, int y)
    {
        if(front == null && rear == null)
        {
          Queue q = new Queue(x,y);
          temp = q;
        }
        else
        {
           Queue q = new Queue(x,y,temp);
           temp = q;
        }
        if(front == null)
        {
            front = temp;
        }
        rear = temp;
    }
    // Deleting first node in queue
    public void deQueue()
    {
        if(front == rear)
        {
            front = null;
            rear = null;
        }
        else
        {
            end = rear;
            while(end.link != front)
            {
                end = end.link;
            }
            front = end;
            end.link = null;    
        }
    }    
}