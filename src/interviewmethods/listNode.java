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
public class listNode {
    listNode next = null;
    int data;
    
    public listNode()
    {
    }
    
    public listNode(int d)
    {
        data = d;
    }
    
    public int length()
    {
        int c = 0;
        listNode temp = this;
        while(temp != null)
        {
            c++;
            temp = temp.next;
        }
        return c;
    }
    
    public void printNodes()
    {
        listNode temp = this;
        while(temp != null)
        {
            System.out.print(temp.data);
            temp = temp.next;
        }
        System.out.println("");
    }
    
    public void append(int data)
    {
        listNode temp = this;
        while(temp.next != null)
        {
            temp = temp.next;
        }
        temp.next = new listNode(data);
    }
}
