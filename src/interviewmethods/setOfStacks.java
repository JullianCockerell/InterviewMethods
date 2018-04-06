/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods;
import java.util.ArrayList;

/**
 *
 * @author JullianCockerell
 */
public class setOfStacks 
{
    ArrayList<jStackWitCapac> stacks = new ArrayList<jStackWitCapac>();
    public int capacity;
    public setOfStacks(int capacity)
    {
        this.capacity = capacity;
    }
    
    public jStackWitCapac getLastStack()
    {
        if(stacks.size() == 0)
        {
            return null;
        }
        return stacks.get(stacks.size() - 1);
    }
    
    public void push(int data)
    {
        jStackWitCapac last = getLastStack();
        if(last != null && !last.isFull())
        {
            last.push(data);
        }
        else
        {
            jStackWitCapac stack = new jStackWitCapac(capacity);
            stack.push(data);
            stacks.add(stack);
        }
    }
    
    public int pop()
    {
        jStackWitCapac last = getLastStack();
        if(last == null)
        {
            System.out.println("Stacks are empty!");
        }
        int output = last.pop();
        if(last.curSize == 0)
        {
            stacks.remove(stacks.size() - 1);
        }
        return output;
    }
}
