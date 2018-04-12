/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewmethods;
import java.util.HashMap;
import java.util.ArrayList;
/**
 *
 * @author JullianCockerell
 */
public class jProject
{
    private ArrayList<jProject> children = new ArrayList<jProject>();
    private HashMap<String, jProject> map = new HashMap<String, jProject>();
    private String name;
    private int depend = 0;
    
    public jProject(String n)
    {
        name = n;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void plusDepend()
    {
        depend++;
    }
    
    public void minusDepend()
    {
        depend--;
    }
    
    public void addEdge(jProject node)
    {
        if(!map.containsKey(node.getName()))
        {
            children.add(node);
            map.put(node.getName(), node);
            node.plusDepend();
        }
    }
    
    public ArrayList<jProject> getChildren(){return children;}
    public int getDependNum() {return depend;}
    
}
