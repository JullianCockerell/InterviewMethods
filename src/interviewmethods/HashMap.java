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
public class HashMap 
{
    HashEntry[] table;
    int size;
    
    HashMap(int size) 
    {
        this.size = size;
        table = new HashEntry[size];
        for (int i = 0; i < size; i++)
        {
        table[i] = null;
        }
    }
    
    public void put(int key, char value) 
    {
        int hash = (key % size);
        table[hash] = new HashEntry(key, value);
    }
    
    public void put(int key)
    {
        int hash = (key % size);
        table[hash] = new HashEntry(key);
    }
    
    public boolean get(int key)
    {
        int hash = (key % size);
        if (table[hash] == null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
