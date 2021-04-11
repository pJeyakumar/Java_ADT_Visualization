package javagraphicstemplate;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kaviyan Jeyakumar
 */
class Stack 
{
	// Variable Declaration
    Stack top;
    Stack link;
    int x;
    int y;
    // Base Constructor
    Stack()
    {
        top= null;
    }
    // Constructor where we are given the x and y values
    Stack(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    // Returning x value of stack node
    public int returnX()
    {
        return this.x;
    }
    // Returning y value of stack node
    public int returnY()
    {
        return this.y;
    }
    // Adding new node to the top of stack
    public void sPush(int x, int y)
    {
      Stack s = new Stack(x,y);
      s.link = top;
      top = s;
    }
    // Taking of node on the top of the stack
    public void sPop()
    {
        top = top.link;
    }
}