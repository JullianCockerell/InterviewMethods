/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods;

/**
 *
 * @author JullianCockerell
 */
public class jQueue<T>
{
    private static class queueNode<T>
    {
        private T data;
        private queueNode<T> next;
        public queueNode(T data)
        {
            this.data = data;
        }
    }
    
    private queueNode first;
    private queueNode last;
    
    public void add(T item)
    {
        queueNode<T> t = new queueNode<T>(item);
        if(last != null)
        {
            last.next = t;
        }
        last = t;
        if(first == null)
        {
            first = last;
        }
    }
    
    public T remove()
    {
        if(first == null){System.out.println("Queue is empty!");}
        T data = (T) first.data;
        first = first.next;
        if(first == null)
        {
            last = null;
        }
        return data;
    }
    
    public T peek()
    {
        if(first == null)
        {
            System.out.println("Queue is empty!");
        }
        return (T) first.data;
    }
    
    public boolean isEmpty()
    {
        return first == null;
    }
}
