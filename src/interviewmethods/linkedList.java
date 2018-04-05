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
public class linkedList 
{
    public listNode head;
    
    public linkedList()
    {
        head = null;
    }
    
    public boolean isEmpty()
    {
        return head == null;
    }
    
    public void append(int d)
    {
        if(head == null)
        {
            head = new listNode(d);
        }
        else
        {
            listNode temp = head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = new listNode(d);
        }
    }
    
    public String returnList()
    {
        listNode temp = head;
        StringBuilder output = new StringBuilder();
        while(temp != null)
        {
            output.append(temp.data);
            temp = temp.next;
        }
        return output.toString();
    }
    
    public int returnLength()
    {
        if(isEmpty()){return 0;}
        listNode temp = head;
        int c = 0;
        while(temp != null)
        {
            c++;
            temp = temp.next;
        }
        return c;
    }
    
    
    
    
    
    
}
