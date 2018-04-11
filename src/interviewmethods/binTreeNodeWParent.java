/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods;

/**
 *
 * @author julliancockerell
 */
public class binTreeNodeWParent
{
   binTreeNodeWParent parent;
   binTreeNodeWParent left;
   binTreeNodeWParent right;
   int value;
   
   public  void addNode(int data)
   {
       if(this.left == null)
       {
           this.left = new binTreeNodeWParent(data);
           this.left.parent = this;
       }
       else if (this.right == null)
       {
           this.right = new binTreeNodeWParent(data);
           this.right.parent = this;
       }
       else
       {
           System.out.println("No open nodes to insert!");
       }
   }
   
   public binTreeNodeWParent()
   {
       parent = null;
       left = null;
       right = null;
   }
   
   public binTreeNodeWParent(int data)
   {
       parent = null;
       left = null;
       right = null;
       value = data;
   }
   
}
