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
public class HashEntry 
{
    private int key;
    private char value;

      HashEntry(int key, char value) 
      {
            this.key = key;
            this.value = value;
      }     
      
      HashEntry(int key)
      {
          this.key = key;
      }

      public int getKey() 
      {
            return key;
      }
      
      public char getValue() 
      {
            return value;
      }
    
}
