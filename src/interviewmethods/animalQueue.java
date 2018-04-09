/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods;
import java.util.LinkedList;

/**
 *
 * @author JullianCockerell
 */
public class animalQueue 
{
    LinkedList<dogClass> dogs = new LinkedList<dogClass>();
    LinkedList<catClass> cats = new LinkedList<catClass>();
    private int order = 0;

    public void enqueue(animalClass a)
    {
        a.setOrder(order);
        order++;
        if(a instanceof dogClass){dogs.addLast((dogClass) a);}
        else if (a instanceof catClass) {cats.addLast((catClass) a);}
    }
    

    public animalClass dequeueAny()
    {
        if(dogs.size() == 0){return dequeueCat();}
        else if(cats.size() == 0){return dequeueDog();}
        
        dogClass dog = dogs.peek();
        catClass cat = cats.peek();
        if(dog.isOlderThan(cat)){return dequeueDog();}
        else{return dequeueCat();}
    }
    
    public dogClass dequeueDog()
    {
        return dogs.poll();
    }
    
    public catClass dequeueCat()
    {
        return cats.poll();
    }
}

class catClass extends animalClass
{
    public catClass(String n)
    {
        super(n);
    }
}

class dogClass extends animalClass
{
    public dogClass(String n) 
    {
        super(n);
    }
}
