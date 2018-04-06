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
public class jStackWitMin extends jStack<Integer>
{
    jStack<Integer> minStack;
    public jStackWitMin()
    {
        minStack = new jStack<Integer>();
    }
    
    public void push(int value)
    {
        if(value <= min())
        {
            minStack.push(value);
        }
        super.push(value);
    }
    
    public Integer pop()
    {
        int value = super.pop();
        if(value == min())
        {
            minStack.pop();
        }
        return value;
    }
    
    public int min()
    {
        if(minStack.isEmpty()){return Integer.MAX_VALUE;}
        return minStack.peek();
    }
}
