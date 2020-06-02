/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphicstemplate;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JApplet;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.Color;
import java.io.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.*;
import sun.audio.*;
import java.net.URL;
import java.util.*;

/**
 *
 * @author 023627
 */
class MyAppClass extends JPanel 
{
    // Variable Declarations
    
    // Location Variables
    int intX;
    int intY;
    int bx;
    int by;
    Graphics me = null; 
    private Timer timer = new Timer();
    private Image offScreenImage = null;
    private Graphics offScreenGraphics = null;
    int intNumber = 1;    
    int intScreen = 0;
    
    // Linked List Variables
    LinkedList start = null;
    LinkedList end = null;
    LinkedList temp;
    
    // Stack Variables
    Stack sTemp;
    Stack s = new Stack();
    
    // Queue Variables
    Queue qTemp;
    Queue q = new Queue();
    
    // Binary Tree Variables
    BinaryTree bTemp;
    BinaryTree bRoot;
    	
    // Bars Variables
    Bars[] array = new Bars[10];
    int intIndex = 0;
    boolean blnFirstClick = false;
    boolean blnNextStep;
    
    public class MyKeyListener implements KeyListener
    {
@Override
public void keyTyped(KeyEvent e) 
        {
        }

@Override
public void keyPressed(KeyEvent e) 
        {
	
            // Linked List
            if (intScreen == 1)
            {
                // Adding Link
                if(e.getKeyCode() == '1' && (intX < 1000 || end == null))
                {
                  LinkedList();
                  intX += 100;                     
                }
                // Deleting Link
                else if(e.getKeyCode() == '2')
                {
                    if(start == null && end == null)
                    {
                        System.out.println("You need to add a have BEFORE deleting one... fool.");                        
                    }
                    else
                    {
                        linkDelete(end,start);
                    }
                }
                // Leaving LinkedList
                else if(e.getKeyCode() == 'E')
                {
                    intScreen = 0;
                }
            }
            
            // Stack
            else if (intScreen == 2)
            {
              // Adding node to stack, otherwise known as PUSH
              if(e.getKeyCode() == '1' && intY > -100)
              {
                  s.sPush(intX, intY);
                  intY -= 100;
              }
              // Taking node off of top of the stack, otherwise known as POP
              else if(e.getKeyCode() == '2')
              {
            	  // If the stack is already empty
                  if(s.top == null)
                  {
                      System.out.println("Buddy... Add something first at least!");
                  }
                  else
                  {
                      s.sPop();
                      intY += 100;
                  }
              }
              // Leaving Stack
              else if(e.getKeyCode() == 'E')
              {
                  intScreen = 0;
              }
            }
            
            // Queue
            else if (intScreen == 3)
            {
            	// Adding node to queue
                if(e.getKeyCode() == '1' && (intY < 700 || q.rear == null))
                {
                	// Setting y value if the rear pointer is null
                	if(q.rear == null)
                	{
                		intY = 100;
                	}
                    q.enQueue(intX, intY);
                    intY += 100;
                }
                // Taking node off of queue
                else if(e.getKeyCode() == '2')
                {
                	// Checking if queue is empty
                    if(q.rear == null)
                    {
                        System.out.println("Hey! How do you delete what you don't have?");
                    }
                    else
                    {
                        q.deQueue(); 
                    }
                }
                // Leaving Queue
                else if(e.getKeyCode() == 'E')
                {
                   intScreen = 0; 
                }
            }
            
            // Binary Tree
            else if (intScreen == 4)
            {
            	// Node declaration
                BinaryTree n1;
                // Adding a node to the tree
                if(e.getKeyCode() == '1')
                {
                	// Generating a random number from 0 - 20
                	Random r = new Random();
                	int intRandom = r.nextInt(21);
                	// If the root does not exist, we make the root (AKA the first node)
                	if(bRoot == null) 
                	{
                		bRoot = new BinaryTree(10);
                	}
                	// Otherwise we add a node that has null pointers
                	else 
                	{
                		n1 = new BinaryTree(null, null, intRandom);
                		insertBinaryTree(bRoot, n1);
                	}
                    
                }
                // Leaving Binary Tree
                else if(e.getKeyCode() == 'E')
                {
                    intScreen = 0;
                }
            }
            
            // Bubble Sort
            else if (intScreen == 5)
            {
               if(e.getKeyCode() == '1') 
               {
            	   int intTempLength;
            	   // Goes through the array ONCE 
            	   for(int i = 0; i < array.length - 1; i++) 
            	   {
            		   // Comparing the sizes of the bars
            		   if(array[i].getLength() > array[i + 1].getLength()) 
            		   {
            			   // Swaps the bars
            			   intTempLength = array[i].getLength();
            			   array[i].setLength(array[i + 1].getLength());
            			   array[i + 1].setLength(intTempLength);
            		   }
            	   }
               }
               // Resetting all variables and randomizing sizes of bars
               else if(e.getKeyCode() == '2') 
               {
                   intX = 100;
                   intY = 400;
                   Random r = new Random();
                   Bars b;
                   for(int i = 0; i < 10; i++) 
                   {
                   		int intRandom = r.nextInt(201) + 20;
                   		b = new Bars(intX, intY, intRandom, 10);
                   		array[i] = b;
                   		intX += 50;
                   }
               }
               // Returning to exit screen
               else if(e.getKeyCode() == 'E') 
               {
            	  intScreen = 0; 
               }
            }
            
            // Insertion Sort
            else if (intScreen == 6)
            {
            	if(e.getKeyCode() == '1') 
            	{
            		// Incrementing index (starting at 1, since starting at 0 is a waste of a step)
            		intIndex++;
            		// Going through the array from intIndex to the end of the array
            		if(intIndex < array.length) 
            		{
            			// Holding the length of the bar at intIndex
            			int intKey = array[intIndex].getLength();
            			int j = intIndex - 1;
            			
            			// Compare the intIndex length to all bars before it and shifting the larger bars righwards
            			while(j >= 0 && array[j].getLength() > intKey) 
            			{
            				array[j + 1].setLength(array[j].getLength());
            				j = j - 1;
            			}
            			// Length of bar intIndex is now at sorted spot
            			array[j + 1].setLength(intKey);
            		}
            	}
            	// Resetting all variables and randomizing sizes of bars
            	else if(e.getKeyCode() == '2') 
            	{
            		intIndex = 0;
                    intX = 100;
                    intY = 400;
                    Random r = new Random();
                    Bars b;
                    for(int i = 0; i < 10; i++) 
                    {
                    	int intRandom = r.nextInt(201) + 20;
                    	b = new Bars(intX, intY, intRandom, 10);
                    	array[i] = b;
                    	intX += 50;
                    }
            	}
            	// Returning to exit screen
            	else if(e.getKeyCode() == 'E')
            	{
            		intScreen = 0;
            	}
            }
            
            // Selection Sort
            else if (intScreen == 7)
            {
            	if(e.getKeyCode() == '1') 
            	{
            		// Incrementing Step Variable
            		intIndex++;
            		// Ensuring our index never goes beyond scope of the array
            		if(intIndex < array.length) 
            		{
            			// Our minimum value is our starting value
            			int intMinIndex = intIndex;
            			// Go through the rest of the array
            			for(int j = intIndex + 1; j < array.length; j++) 
            			{
            				// If any index has a smaller length than the length of intMinIndex, intMinIndex is changed
            				if(array[j].getLength() < array[intMinIndex].getLength())
            				{
            					intMinIndex = j;
            				}
            			}
            			
            			// Swap the intIndex length with the smallest bar length found in the right side of the array
            			int tempLength = array[intMinIndex].getLength();
            			array[intMinIndex].setLength(array[intIndex].getLength());
            			array[intIndex].setLength(tempLength);
            		}
            	}
            	else if(e.getKeyCode() == '2') 
            	{
                    intX = 100;
                    intY = 400;
                    intIndex = -1;
                    Random r = new Random();
                    Bars b;
                    for(int i = 0; i < 10; i++) 
                    {
                    	int intRandom = r.nextInt(201) + 20;
                    	b = new Bars(intX, intY, intRandom, 10);
                    	array[i] = b;
                    	intX += 50;
                    }
            	}
            	// Returning to main screen
            	else if(e.getKeyCode() == 'E')
            	{
            		intScreen = 0;
            	} 
            }
            
            // Quick Sort
            else if (intScreen == 8)
            {
            	if(e.getKeyCode() == '1') 
            	{
            		if(blnFirstClick == false)
            		{
            		// Add code here to shuffle the bars before sorting ** ensures performances quality
            		Quicksort(0, array.length - 1);
            		}
            		blnNextStep = true;
            		
            	}
            	else if(e.getKeyCode() == '2') 
            	{
                    intX = 100;
                    intY = 400;
                    Random r = new Random();
                    Bars b;
                    for(int i = 0; i < 10; i++) 
                    {
                    	int intRandom = r.nextInt(201) + 20;
                    	b = new Bars(intX, intY, intRandom, 10);
                    	array[i] = b;
                    	intX += 50;
                    }
            	}
            	else if(e.getKeyCode() == 'E')
            	{
            		intScreen = 0;
            	}
            }
            
            // Merge Sort
            else if(intScreen == 9) 
            {
            	if(e.getKeyCode() == '1') 
            	{
            		// Left index = 0, Right index = 9
            		Mergesort(0, array.length - 1);
            	}
            	else if(e.getKeyCode() == '2') 
            	{
                	intX = 100;
                    intY = 400;
                    intScreen = 9;
                    Random r = new Random();
                    Bars b;
                    for(int i = 0; i < 10; i++) 
                    {
                    	int intRandom = r.nextInt(201) + 20;
                    	b = new Bars(intX, intY, intRandom, 10);
                    	array[i] = b;
                    	intX += 50;
                    }
            	}
            	else if(e.getKeyCode() == 'E') 
            	{
            		intScreen = 0;
            	}
            }
            
            // Shell Sort
            else if(intScreen == 10) 
            {
            	if(e.getKeyCode() == '1') 
            	{
            		// Ensuring the index never falls below 0
            		if(intIndex > 0) 
            		{
            			// Reducing the gap size by half
            			intIndex /= 2;
            			// Running the shell sorting algorithm
            			Shellsort();
            		}
            	}
            	else if(e.getKeyCode() == '2') 
            	{
                	intX = 100;
                    intY = 400;
                    intScreen = 10;
                    intIndex = array.length;
                    Random r = new Random();
                    Bars b;
                    for(int i = 0; i < 10; i++) 
                    {
                    	int intRandom = r.nextInt(201) + 20;
                    	b = new Bars(intX, intY, intRandom, 10);
                    	array[i] = b;
                    	intX += 50;
                    }
            	}
            	else if(e.getKeyCode() == 'E') 
            	{
            		intScreen = 0;
            	}
            }
            
            // Main Menu
            else if (intScreen == 0)
            {
                mainMenu(e);
            }    
            
        }	
@Override
public void keyReleased(KeyEvent e) 
        {
System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
}
}
        MyAppClass()
        {
            // maze 2 dimensional array	
            timer.schedule(new MyTimer(), 0, 1);
            KeyListener listener = new MyKeyListener();
            addKeyListener(listener);
            setFocusable(true);
        }
        public void mainMenu(KeyEvent e)
        {
        	
            // Linked List setup
            if (e.getKeyCode() == '1')
            {
                intScreen = 1;
                intNumber = 0;
                start = null;
                end = null;
                intY = 400;
                intX = 100;
            }
            
            // Stack setup
            else if (e.getKeyCode() == '2')
            {
                intScreen = 2;
                s.top = null;
                intX = 450;
                intY = 500;
            }
            
            // Queue setup
            else if (e.getKeyCode() == '3')
            {
                intScreen = 3;
                q.rear = null;
                q.front = null;
                intY = 100;
                intX = 500;                
            }
            
            // Binary Tree setup
            else if (e.getKeyCode() == '4')
            {          
            	bRoot = null;
            	bx = 400;
            	by = 100;
                intScreen = 4;
            }
            
            // Bubble Sort setup
            else if (e.getKeyCode() == '5')
            {
                intX = 100;
                intY = 400;
                intScreen = 5;
                Random r = new Random();
                Bars b;
                for(int i = 0; i < 10; i++) 
                {
                	int intRandom = r.nextInt(201) + 20;
                	b = new Bars(intX, intY, intRandom, 10);
                	array[i] = b;
                	intX += 50;
                }
            }
            
            // Selection Sort setup
            else if (e.getKeyCode() == '6')
            {
            	intIndex = 0;
                intX = 100;
                intY = 400;
                intScreen = 6;
                Random r = new Random();
                Bars b;
                for(int i = 0; i < 10; i++) 
                {
                	int intRandom = r.nextInt(201) + 20;
                	b = new Bars(intX, intY, intRandom, 10);
                	array[i] = b;
                	intX += 50;
                }
            }
            
            // Insertion Sort setup
            else if (e.getKeyCode() == '7')
            {
                intX = 100;
                intY = 400;
                intIndex = -1;
                intScreen = 7;
                Random r = new Random();
                Bars b;
                for(int i = 0; i < 10; i++) 
                {
                	int intRandom = r.nextInt(201) + 20;
                	b = new Bars(intX, intY, intRandom, 10);
                	array[i] = b;
                	intX += 50;
                }
            }
            
            // Quick Sort setup
            else if (e.getKeyCode() == '8')
            {
                intX = 100;
                intY = 400;
                intScreen = 8;
                Random r = new Random();
                Bars b;
                for(int i = 0; i < 10; i++) 
                {
                	int intRandom = r.nextInt(201) + 20;
                	b = new Bars(intX, intY, intRandom, 10);
                	array[i] = b;
                	intX += 50;
                }
            }
            // Merge Sort setup
            else if(e.getKeyCode() == '9') 
            {
            	intX = 100;
                intY = 400;
                intScreen = 9;
                Random r = new Random();
                Bars b;
                for(int i = 0; i < 10; i++) 
                {
                	int intRandom = r.nextInt(201) + 20;
                	b = new Bars(intX, intY, intRandom, 10);
                	array[i] = b;
                	intX += 50;
                }
            }
            // Shell Sort setup
            else if(e.getKeyCode() == 'S') 
            {
            	intX = 100;
                intY = 400;
                intScreen = 10;
                intIndex = array.length;
                Random r = new Random();
                Bars b;
                for(int i = 0; i < 10; i++) 
                {
                	int intRandom = r.nextInt(201) + 20;
                	b = new Bars(intX, intY, intRandom, 10);
                	array[i] = b;
                	intX += 50;
                }
            }
            
            // Main Menu setup
            else if (e.getKeyCode() == 'E')
            {
                System.exit(0);
            }
            
        }
        
        private class MyTimer extends java.util.TimerTask 
        { 
                public void run()    
                { 
                 // Run thread on event dispatching thread 
                 if (!EventQueue.isDispatchThread()) 
                 { 
                     EventQueue.invokeLater(this); 
                 } 
                 else 
                 { 
                     if (MyAppClass.this != null) 
                     { 
                         MyAppClass.this.repaint();                         
                     } 
                 }  
             } // End of Run 
         } 
        
        public void renderOffScreen( Graphics g) 
        { 
            me = g;
            me.setFont(new Font("Serif",Font.PLAIN,18));            
            // Main Menu
            if (intScreen == 0)
            {
            	// Title
                me.setFont(new Font("Serif",Font.BOLD,36));
                me.drawString("A Little Bit of Everything", 275, 50);
                // Subtitles
            	me.setFont(new Font("Serif",Font.ITALIC, 36));
                me.drawString("ADT Structures", 100, 130);
                me.drawString("Elementary Sorts", 500, 130);
                // Options
                me.setFont(new Font("Serif",Font.PLAIN,36));
                me.drawString("Press 1 for Linked List",100,200);
                me.drawString("Press 2 for Stack",100,300);
                me.drawString("Press 3 for Queue",100,400);
                me.drawString("Press 4 for Binary Tree",100,500);
                me.drawString("Press 5 for Bubble Sort",500,200);
                me.drawString("Press 6 for Insertion Sort",500,300);
                me.drawString("Press 7 for Selection Sort",500,400);
                me.drawString("Press 8 for Quick Sort",500,500);   
                me.drawString("Press 9 for Merge Sort", 500, 600);
                me.drawString("Press S for Shell Sort", 500, 700);
            }
            
            // Linked List
            else if (intScreen == 1)
            {
                me.clearRect(1000, 1000, 1000, 1000);
                me.setFont(new Font("Serif",Font.BOLD,36));
                me.drawString("Linked List", 375, 50);
                me.setFont(new Font("Serif",Font.PLAIN,18));
                me.drawString("Press 1 to add a Node", 100, 200);
                me.drawString("Press 2 to remove a Node", 100, 250);
                me.drawString("Press E to go back", 100, 300);
                temp = start;
                while(temp != null)
                {
                    me.fillRect(temp.returnX(), temp.returnY(), 75, 75);
                    me.fillRect(temp.returnX() - 30, temp.returnY() + 10, 100, 25);
                    temp = temp.next;    
                }
            }
            
            // Stack
            else if (intScreen == 2)
            {
                me.clearRect(1000, 1000, 1000, 1000);
                me.setFont(new Font("Serif",Font.BOLD,36));
                me.drawString("Stack", 375, 50);
                me.setFont(new Font("Serif",Font.PLAIN,18));
                me.drawString("Press 1 to 'Push'", 100, 200);
                me.drawString("Press 2 to 'Pop'", 100, 250);
                me.drawString("Press E to go back", 100, 300);
                sTemp = s.top;
                while(sTemp != null)
                {
                    me.fillRect(sTemp.returnX(), sTemp.returnY(), 75, 75);
                    me.fillRect(sTemp.returnX() + 30, sTemp.returnY() +40, 10, 100);
                    sTemp = sTemp.link;
                }                
            }
            
            // Queue
            else if (intScreen == 3)
            {
                me.clearRect(1000, 1000, 1000, 1000);
                me.setFont(new Font("Serif",Font.BOLD,36));
                me.drawString("Queue", 375, 50);
                me.setFont(new Font("Serif",Font.PLAIN,18));
                me.drawString("Press 1 to 'Enqueue'", 100, 200);
                me.drawString("Press 2 to 'Dequeue'", 100, 250);
                me.drawString("Press E to go back", 100, 300);
                qTemp = q.rear;
                while(qTemp != null)
                {
                  me.fillRect(qTemp.returnX(), qTemp.returnY(), 75, 75);
                  me.fillRect(qTemp.returnX() + 30, qTemp.returnY() + 40, 10, 100);
                  qTemp = qTemp.link;
                }
            }
            
            // Binary Tree
            else if (intScreen == 4)
            {
                me.clearRect(1000, 1000, 1000, 1000);
                me.setFont(new Font("Serif",Font.BOLD,36));
                me.drawString("Binary Tree", 375, 50);
                me.setFont(new Font("Serif",Font.PLAIN,18));
                me.drawString("Press 1 to Add", 100, 200);
                me.drawString("Press E to go back", 100, 250);
                bTemp = bRoot;
             	if(bTemp != null) 
            	{
            		g = displayTree(g, bTemp, 0,0);
            	}
            }
            
            // Bubble Sorting
            else if (intScreen == 5)
            {
                me.clearRect(1000, 1000, 1000, 1000);
                me.setFont(new Font("Serif",Font.BOLD,36));
                me.drawString("Bubble Sorting", 375, 50);
                me.setFont(new Font("Serif",Font.PLAIN,18));
                me.drawString("Press 1 to Start Sort",100,200);
                me.drawString("Press 2 to Reset", 100, 250);
                me.drawString("Press E to go back",100,300);
                
                for (int i = 0; i < array.length; i++)
                {
                	g.fillRect(array[i].getX(), array[i].getY(), array[i].getWidth(), array[i].getLength());
                }
            }
            
            // Selection Sorting
            else if (intScreen == 6)
            {
                me.clearRect(1000, 1000, 1000, 1000);   
                me.setFont(new Font("Serif",Font.BOLD,36));
                me.drawString("Selection Sorting", 375, 50);
                me.setFont(new Font("Serif",Font.PLAIN,18));
                me.drawString("Press 1 to Start Sort",100,200);
                me.drawString("Press 2 to Reset", 100, 250);
                me.drawString("Press E to go back",100,300);
                
                for (int i = 0; i < array.length; i++)
                {
                	g.fillRect(array[i].getX(), array[i].getY(), array[i].getWidth(), array[i].getLength());
                }
            }
            
            // Insertion Sort
            else if (intScreen == 7)
            {
                me.clearRect(1000, 1000, 1000, 1000); 
                me.setFont(new Font("Serif",Font.BOLD,36));
                me.drawString("Insertion Sorting", 375, 50);
                me.setFont(new Font("Serif",Font.PLAIN,18));
                me.drawString("Press 1 to Start Sort",100,200);
                me.drawString("Press 2 to Reset", 100, 250);
                me.drawString("Press E to go back",100,300);
                
                for (int i = 0; i < array.length; i++)
                {
                	g.fillRect(array[i].getX(), array[i].getY(), array[i].getWidth(), array[i].getLength());
                }
            }
            
            // Quick Sort
            else if (intScreen == 8)
            {
                me.clearRect(1000, 1000, 1000, 1000); 
                me.setFont(new Font("Serif",Font.BOLD,36));
                me.drawString("Quick Sorting", 375, 50);
                me.setFont(new Font("Serif",Font.PLAIN,18));
                me.drawString("Press 1 to Start Sort",100,200);
                me.drawString("Press 2 to Reset", 100, 250);
                me.drawString("Press E to go back",100,300);
                
                for (int i = 0; i < array.length; i++)
                {
                	g.fillRect(array[i].getX(), array[i].getY(), array[i].getWidth(), array[i].getLength());
                }
            }
            // Merge Sort
            else if(intScreen == 9) 
            {
                me.clearRect(1000, 1000, 1000, 1000); 
                me.setFont(new Font("Serif",Font.BOLD,36));
                me.drawString("Merge Sorting", 375, 50);
                me.setFont(new Font("Serif",Font.PLAIN,18));
                me.drawString("Press 1 to Start Sort",100,200);
                me.drawString("Press 2 to Reset", 100, 250);
                me.drawString("Press E to go back",100,300);
                
                for (int i = 0; i < array.length; i++)
                {
                	g.fillRect(array[i].getX(), array[i].getY(), array[i].getWidth(), array[i].getLength());
                }
            }
            // Shell Sort
            else if(intScreen == 10) 
            {
                me.clearRect(1000, 1000, 1000, 1000); 
                me.setFont(new Font("Serif",Font.BOLD,36));
                me.drawString("Shell Sorting", 375, 50);
                me.setFont(new Font("Serif",Font.PLAIN,18));
                me.drawString("Press 1 to Start Sort",100,200);
                me.drawString("Press 2 to Reset", 100, 250);
                me.drawString("Press E to go back",100,300);
                
                for (int i = 0; i < array.length; i++)
                {
                	g.fillRect(array[i].getX(), array[i].getY(), array[i].getWidth(), array[i].getLength());
                }
            }
        }     
        
        public void paint(Graphics g) 
        {
            final Dimension d = getSize(); 
             if (offScreenImage == null) 
             {    
                 // Double-buffer: clear the offscreen image.                 
                 offScreenImage = createImage(d.width, d.height);    
             }         
             offScreenGraphics  = offScreenImage.getGraphics();      
             offScreenGraphics.setColor(Color.white); 
             offScreenGraphics.fillRect(0, 0, d.width, d.height) ;      
            
            renderOffScreen(offScreenImage.getGraphics());  
            g.drawImage(offScreenImage, 0, 0, null);
       
        }
        
        // Method for creating the first link in the linked list and adding new links to the linked list
        public void LinkedList()
        {
           if(start == null && end == null)
           {
        	   intX = 100;
               LinkedList l = new LinkedList(intNumber++,intX,intY);
               start = l;
               end = l;
           }
           else
           {            
             start = new LinkedList(start,intNumber++,intX,intY);
           }
        }
        
        // Method for deleting links off the linked list
        public void linkDelete(LinkedList a, LinkedList b)
        {
        	// Linked List Variable Declaration
            LinkedList temp = b;
            LinkedList prev = null;
            // If there is only 1 link in the linked list
            if(a == b)
            {
             start = null;
             end = null;
            }
            // Deleting links off the linked list, first in first out way
            else
            {
                while(temp.next != null)
                {
                    prev = temp;
                    temp = temp.next;
                }
                prev.next = temp.next;
                end = prev;
            }           
        } 
        
        // Method for inserting the new node into the correct position on the binary tree
        public void insertBinaryTree(BinaryTree bN, BinaryTree bTemp) 
        {
        	int intbNData = bN.getData();
        	int intbTempData = bTemp.getData();
        	
        	// If the number of the root is greater than the number of the node we are inserting, the node will be inserted to the right.
        	if(intbNData > intbTempData) 
        	{
        		// If the right is not pointing to anything, we add the node here
        		if(bN.getRight() == null) 
        		{
        			bN.setRight(bTemp);
        			return;
        		}
        		// Otherwise we keep recursing
        		else
        		{
        			insertBinaryTree(bN.getRight(), bTemp);
        		}
        	}
        	// Otherwise the node will be inserted to the left
        	else 
        	{
        		// If the left is not pointing to anything, we add the node here
        		if(bN.getLeft() == null) 
        		{
        			bN.setLeft(bTemp);
        			return;
        		}
        		// Otherwise we keep recursing
        		else 
        		{
        			insertBinaryTree(bN.getLeft(), bTemp);
        		}
        	}
        }
        
        // Displaying the binary tree onto the console
        Graphics displayTree(Graphics g, BinaryTree temp, int intX, int intY) 
        {
        	// Base case 
        	if(temp == null) 
        	{
        		return g;
        	}
        	else 
        	{
        		// Setting the x and y values
        		int x = bx + intX*130;
        		int y = by + intY*80;
        		// Drawing the rectangle (node)
        		g.fillRect(x, y, 75, 75);
        		// Drawing rightward and leftward pointers
        		g.drawLine(x + 45, y + 40, x - 70, y + 80);
        		g.drawLine(x + 45, y + 40, x + 120, y + 80);
        		// Writing number
        		g.setFont(new Font("TimesRoman", Font.PLAIN, 30));
        		g.setColor(Color.white);
        		g.drawString(String.valueOf(temp.getData()), x + 25, y + 35);
        		g.setColor(Color.black);
        		// Recursing through the left and right side of the tree
        		g = displayTree(g, temp.getLeft(), intX - 1, intY + 1);
        		g = displayTree(g, temp.getRight(), intX + 1, intY + 1);
        	}
        	return g;
        }
        // Finding the paritions of the array
        public int partition(int low, int high) 
        {
        	int pivot = array[high].getLength();
        	int i = low - 1;
        	
        	for(int j = low; j < high; j++) 
        	{
        		if(array[j].getLength() < pivot) 
        		{
        			i++;
      
        			int temp = array[i].getLength();
        			array[i].setLength(array[j].getLength());
        			array[j].setLength(temp);
        		}
        	}
        	
        	int temp = array[i + 1].getLength();
        	array[i + 1].setLength(array[high].getLength());
        	array[high].setLength(temp);
        	return i + 1;
        }
        // Implement 3-way paritioning for quick sort
        // Sorts the partitions of the array
        public void Quicksort(int low, int high)
        {
        	if(low < high)
        	{
        		int pi = partition(low, high);
        		
        		Quicksort(low, pi - 1);
        		Quicksort(pi + 1, high);
        	}
        }
        // Merges the two sub arrays of the original array
        public void merge(int l, int m, int r) 
        {
        	// Finding the sizes of the two sub arrays
        	int sizeSubOne = m - l + 1;
        	int sizeSubTwo = r - m;
        	
        	// Creating the sub arrays with their corresponding sizes
        	int subOne[] = new int[sizeSubOne];
        	int subTwo[] = new int[sizeSubTwo];
        	
        	// Copy the data into the two temp sub arrays
        	for(int i = 0; i < sizeSubOne; i++) 
        	{
        		subOne[i] = array[l + i].getLength();
        	}
        	for(int j = 0; j < sizeSubTwo; j++) 
        	{
        		subTwo[j] = array[m + 1 + j].getLength();
        	}
        	// Initial indexes of 1st and 2nd sub arrays
        	int i = 0;
        	int j = 0;
        	// Initial index of merged array
        	int k = l;
        	while(i < sizeSubOne && j < sizeSubTwo) 
        	{
        		if(subOne[i] <= subTwo[j]) 
        		{
        			array[k].setLength(subOne[i]);
        			i++;
        		}
        		else 
        		{
        			array[k].setLength(subTwo[j]);
        			j++;
        		}
        		k++;
        	}
        	// Filling in any missing blank spots
        	while(i < sizeSubOne)
        	{
        		array[k].setLength(subOne[i]);
        		i++;
        		k++;
        	}
        	while(j < sizeSubTwo)
        	{
        		array[k].setLength(subTwo[j]);
        		j++;
        		k++;
        	}
        }
        // Sorting function that sorts the array using merge()
        public void Mergesort(int l, int r) 
        {
        	// Ensuring the left index is smaller than the right index
        	if(l < r) 
        	{
        		// Finding the middle point
        		int middlePoint = (l + r)/2;
        		
        		// Sorting 1st Half
        		Mergesort(l, middlePoint);
        		// Sorting 2nd Half
        		Mergesort(middlePoint + 1, r);
        		
        		// Merging the sorted halves
        		merge(l, middlePoint, r);
        	}
        }
        // Sorting function that sorts the array using the Shell Sort Algorithm
        public void Shellsort() 
        {
        	int length = array.length;
        	// Doing gapped insertion sort for this gap size
        	for(int i = intIndex; i < length; i++) 
        	{
        		// We remember what the value for our initial index value was
        		int temp = array[i].getLength();
        		int j;
        		// Shift earlier gap-sorted elements until the correct location for array[i] is found
        		for(j = i; j >= intIndex && array[j - intIndex].getLength() > temp; j-= intIndex) 
        		{
        			array[j].setLength(array[j - intIndex].getLength());
        		}
        		// Put temp value into its correct position
        		array[j].setLength(temp);
        	}
        }
    }