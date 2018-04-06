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

public class jStack<T> 
{
    private static class stackNode<T>
    {
        private T data;
        private stackNode<T> next;
        public stackNode(T data)
        {
            this.data = data;
        }
    }
    
    private stackNode<T> top;
    
    public T pop()
    {
        if(top == null){System.out.println("Stack is empty!");}
        T item = top.data;
        top = top.next;
        return item;
    }
    
    public void push(T item)
    {
        stackNode<T> t = new stackNode<T>(item);
        t.next = top;
        top = t;
    }
    
    public T peek()
    {
        if(top == null){System.out.println("Stack is empty!");}
        return top.data;
    }
    
    public boolean isEmpty()
    {
        return top == null;
    }
}
