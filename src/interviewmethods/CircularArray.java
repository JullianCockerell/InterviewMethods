/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods;
import java.lang.Object;
import java.util.Iterator;
/**
 *
 * @author julliancockerell
 */
public class CircularArray<T> implements Iterable<T> 
{
    private T[] items;
    private int head = 0;
    private int size;
    
    public Iterator<T> iterator()
    {
        return new CircularArrayIterator<T>(this);
    }
    
    private class CircularArrayIterator<TI> implements Iterator<TI> 
    {
        private int _current = -1;
        private TI[] _items;
        
        public CircularArrayIterator(CircularArray<TI> array)
        {
            _items = array.items;
        }
        
        @Override
        public boolean hasNext()
        {
            return _current < items.length - 1;
        }
        
        @Override 
        public TI next()
        {
            _current++;
            TI item = (TI) _items[convert(_current)];
            return item;
        }
        
        @Override
        public void remove()
        {
            throw new java.lang.UnsupportedOperationException();
        }
    }
    
    public CircularArray(int size)
    {
        items = (T[]) new Object[size];
        this.size = size;
    }
    
    private int convert(int index)
    {
        if(index < 0){index += items.length;}
        return (head + index) % items.length;
    }
    
    public void rotate(int shiftRight)
    {
        head = convert(shiftRight);
    }
    
    public T get(int i)
    {
        if(i < 0 || i >= items.length)
        {
            throw new java.lang.IndexOutOfBoundsException();
        }
        return items[convert(i)];
    }
    
    public void set(int i, T item)
    {
        items[convert(i)] = item;
    }
    
    public int getSize()
    {
        return size;
    }
}
