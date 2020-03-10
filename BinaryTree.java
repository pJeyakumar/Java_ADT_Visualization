/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javagraphicstemplate;

/**
 *
 * @author 334322625
 */
public class BinaryTree 
{
		// Variable Declaration
        BinaryTree left;
        BinaryTree right;
        int x;
        int y;
        int data;
        // Base Constructor
        public BinaryTree(int data)
        {          
            left = null;
            right = null;
            this.data = data;
        }
        // Constructor with left and right pointer
        public BinaryTree(BinaryTree left, BinaryTree right, int data)
        {
            this.data = data;
            this.left = left;
            this.right = right;
        }
        // Return left pointer
        public BinaryTree getLeft()
        {
            return left;
        }
        // Return x value of node
        public int returnX()
        {
            return this.x;
        }
        // Return y value of node
        public int returnY()
        {
            return this.y;
        }
        // Return right pointer
        public BinaryTree getRight()
        {
            return right;
        }
        // Set left pointer to specified node
        public void setLeft(BinaryTree b)
        {
            left = b; 
        }
        // Set right pointer to specified node
        public void setRight(BinaryTree b)
        {
            right = b;
        }
        // Get data of the node
        public int getData()
        {
            return data;
        }    
    }