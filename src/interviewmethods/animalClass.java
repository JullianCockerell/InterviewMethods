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
public abstract class animalClass 
{
    private int order;
    protected String name;
    public animalClass(String n){name = n;}
    public void setOrder(int ord){order = ord;}
    public int getOrder(){return order;}
    
    public boolean isOlderThan(animalClass a)
    {
        return this.order < a.getOrder();
    }
}


