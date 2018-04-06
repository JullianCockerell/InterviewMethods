/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods;
import java.util.Stack;

/**
 *
 * @author JullianCockerell
 */
public class stackQueue<T>
{
    Stack<T> stackNewest, stackOldest;
    public stackQueue()
    {
        stackNewest = new Stack<T>();
        stackOldest = new Stack<T>();
    }
    
    public int size()
    {
        return stackNewest.size() + stackOldest.size();
    }
    
    public void add(T value)
    {
        stackNewest.push(value);
    }
    
    public void shiftStacks()
    {
        if(stackOldest.isEmpty())
        {
            while(!stackNewest.isEmpty())
            {
                stackOldest.push(stackNewest.pop());
            }
        }
    }
    
    public T peek()
    {
        shiftStacks();
        return stackOldest.peek();
    }
    
    public T remove()
    {
        shiftStacks();
        return stackOldest.pop();
    }
    
    
}
