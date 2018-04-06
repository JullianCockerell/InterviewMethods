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
public class jStackWitCapac extends jStack<Integer>
{
    public int capacity;
    public int curSize = 0;
    public jStackWitCapac(int size)
    {
        this.capacity = size;
    }
    
    public void push(int value)
    {
        super.push(value);
        curSize++;
    }
    
    public Integer pop()
    {
        curSize--;
        return super.pop();
    }
    public boolean isFull()
    {
        return curSize >= capacity;
    }
}
